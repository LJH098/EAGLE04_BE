package EAGLE04.demo.application.service.auth;

import EAGLE04.demo.adapter.in.auth.response.NaverLoginResponse;
import EAGLE04.demo.adapter.out.jpa.member.MemberRepository;
import EAGLE04.demo.application.domain.MemberEntity;
import EAGLE04.demo.application.port.in.auth.LoginUseCase;
import EAGLE04.demo.application.port.out.member.MemberPort;
import EAGLE04.demo.common.dto.NaverInfoDTO;
import EAGLE04.demo.common.security.domain.JwtManager;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
    private final MemberRepository memberRepository;
    private final JwtManager jwtManager;

    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    private String clientSecret;
    @Override
    public NaverLoginResponse naverLogin(String code, String state) {
    String naverAccessToken = getNaverAccessToken(code, state);
    NaverInfoDTO userInfo = getUserInfo(naverAccessToken);
    return login(userInfo);
    }

    private String getNaverAccessToken (String code, String state) {
        WebClient webclient = WebClient.builder()
                .baseUrl("https://nid.naver.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        JSONObject response = webclient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/oauth2.0/token")
                        .queryParam("client_id", clientId)
                        .queryParam("client_secret", clientSecret)
                        .queryParam("grant_type", "authorization_code")
                        .queryParam("state", state)
                        .queryParam("code", code)
                        .build())
                .retrieve().bodyToMono(JSONObject.class).block();

        // 네이버에서 온 응답에서 토큰을 추출
        return response.get("access_token").toString();
    }

    private NaverInfoDTO getUserInfo (String accessToken) {
        WebClient webclient = WebClient.builder()
                .baseUrl("https://openapi.naver.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        JSONObject response = webclient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/nid/me")
                        .build())
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(JSONObject.class).block();

        // 원하는 정보 추출하기
        Map<String, Object> res = (Map<String, Object>) response.get("response");

        return NaverInfoDTO.builder()
                .email(res.get("email").toString())
                .name(res.get("name").toString())
                .provider("naver")
                .providerId(res.get("id").toString())
                .build();
    }

    private NaverLoginResponse login(NaverInfoDTO info) {
        String email = info.email();
        Optional<MemberEntity> member = memberRepository.findByEmail(email);
        if(member.isEmpty()) {
            //회원가입
            return signIn(info, email);
        } else
            return NaverLoginResponse.from(jwtManager.generateAccessToken(member.get().getId()));
    }

    private NaverLoginResponse signIn(NaverInfoDTO info, String email) {
        MemberEntity member = MemberEntity.builder()
                .email(email)
                .name(info.name())
                .provider(info.provider())
                .providerId(info.providerId())
                .build();
        memberRepository.save(member);
        return NaverLoginResponse.from(jwtManager.generateAccessToken(member.getId()));
    }
}

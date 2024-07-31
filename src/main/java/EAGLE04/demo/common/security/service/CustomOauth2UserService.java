package EAGLE04.demo.common.security.service;

import EAGLE04.demo.adapter.out.jpa.member.MemberPersistenceAdapter;
import EAGLE04.demo.application.domain.MemberEntity;
import EAGLE04.demo.application.domain.MemberRole;
import EAGLE04.demo.common.security.domain.NaverUserDetails;
import EAGLE04.demo.common.security.oauth2.CustomOauth2UserDetails;
import EAGLE04.demo.common.security.oauth2.OAuth2UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    private final MemberPersistenceAdapter memberPersistenceAdapter;
    private MemberEntity memberEntity;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        log.info("getAttributes : {}", oAuth2User.getAttributes());

        String provider = userRequest.getClientRegistration().getRegistrationId();

        OAuth2UserInfo oAuth2UserInfo = null;

        // 뒤에 진행할 다른 소셜 서비스 로그인을 위해 구분 => 네이버
        if (provider.equals("naver")) {
            log.info("네이버 로그인");
            oAuth2UserInfo = new NaverUserDetails((Map) oAuth2User.getAttributes().get("response"));
        }

        String providerId = oAuth2UserInfo.getProviderId();
        String email = oAuth2UserInfo.getEmail();
        String name = oAuth2UserInfo.getName();

        Optional<MemberEntity> findMemberEntity = memberPersistenceAdapter.findByProviderAndProviderId(provider, providerId);
        if (findMemberEntity.isEmpty()) {
            memberEntity = MemberEntity.builder()
                    .name(name)
                    .provider(provider)
                    .providerId(providerId)
                    .role(MemberRole.MEMBER)
                    .email(email)
                    .build();
            memberPersistenceAdapter.command(memberEntity);
        } else {
            memberEntity = findMemberEntity.get();
        }
        return new CustomOauth2UserDetails(memberEntity, oAuth2User.getAttributes());
    }
}

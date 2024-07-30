package EAGLE04.demo.application.service.auth;

import EAGLE04.demo.adapter.in.auth.request.LoginRequest;
import EAGLE04.demo.adapter.in.auth.response.LoginResponse;
import EAGLE04.demo.adapter.out.jpa.member.MemberRepository;
import EAGLE04.demo.application.domain.MemberEntity;
import EAGLE04.demo.application.port.in.auth.LoginUseCase;
import EAGLE04.demo.application.port.out.member.MemberPort;
import EAGLE04.demo.common.security.domain.JwtManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService implements LoginUseCase {
    private final MemberPort memberPort;
    private final MemberRepository memberRepository;
    private final JwtManager jwtManager;

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<MemberEntity> member = memberRepository.findByName(request.name());
        if (member.isEmpty()) {
            return signIn(request);
        } else {
            jwtManager.generateAccessToken(member.get().getId());
            return LoginResponse.builder()
                    .accessToken(jwtManager.generateAccessToken(member.get().getId()))
                    .build();
        }
    }

    @Override
    public LoginResponse signIn(LoginRequest request) {
        MemberEntity member = MemberEntity.builder()
                .name(request.name())
                .password(request.password())
                .build();
        memberPort.command(member);
        jwtManager.generateAccessToken(member.getId());
        return LoginResponse.builder()
                .accessToken(jwtManager.generateAccessToken(member.getId()))
                .build();
    }
}

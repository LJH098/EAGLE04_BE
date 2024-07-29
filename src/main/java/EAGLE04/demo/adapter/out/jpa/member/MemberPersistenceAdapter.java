package EAGLE04.demo.adapter.out.jpa.member;

import EAGLE04.demo.application.domain.MemberEntity;
import EAGLE04.demo.application.port.member.MemberPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements MemberPort {

    private final MemberRepository memberRepository;

    @Override
    public MemberEntity findById(Long memberId) {
        return memberRepository
                .findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    @Override
    public Optional<MemberEntity> findByProviderAndProviderId(String provider, String providerId) {
        return memberRepository.findByProvider(provider)
                .filter(m -> m.getProviderId().equals(providerId));
    }

    @Override
    public void command(MemberEntity memberEntity) {
        memberRepository.save(memberEntity);
    }
}


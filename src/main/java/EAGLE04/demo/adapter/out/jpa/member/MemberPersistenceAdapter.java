package EAGLE04.demo.adapter.out.jpa.member;

import EAGLE04.demo.application.domain.MemberEntity;
import EAGLE04.demo.application.port.out.member.MemberPort;
import EAGLE04.demo.common.exception.member.MemberNotFoundException;
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
                .orElseThrow(() -> MemberNotFoundException.EXECPTION);
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

    @Override
    public MemberEntity findByEmail(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> MemberNotFoundException.EXECPTION);
    }

    @Override
    public MemberEntity findByName(String name) {
        return memberRepository.findByName(name)
                .orElseThrow(() -> MemberNotFoundException.EXECPTION);
    }
}


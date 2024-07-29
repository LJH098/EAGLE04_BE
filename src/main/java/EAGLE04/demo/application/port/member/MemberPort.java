package EAGLE04.demo.application.port.member;

import EAGLE04.demo.application.domain.MemberEntity;

import java.util.Optional;

public interface MemberPort {
    MemberEntity findById(Long memberId);
    Optional<MemberEntity> findByProviderAndProviderId(String provider, String providerId);
    void command(MemberEntity memberEntity);
}

package EAGLE04.demo.common.security.service;

import EAGLE04.demo.adapter.out.jpa.member.MemberPersistenceAdapter;
import EAGLE04.demo.application.domain.MemberEntity;
import EAGLE04.demo.common.security.domain.MemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberDetailService implements UserDetailsService {

    private final MemberPersistenceAdapter memberPersistenceAdapter;

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
        MemberEntity member = memberPersistenceAdapter.findById(Long.valueOf(memberId));
        return new MemberDetails(member);
    }
}

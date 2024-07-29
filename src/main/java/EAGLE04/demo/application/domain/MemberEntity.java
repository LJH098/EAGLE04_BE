package EAGLE04.demo.application.domain;

import EAGLE04.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = MemberEntity.ENTITY_PREFIX + "_TB")
@Builder(toBuilder = true)
public class MemberEntity extends BaseEntity {
    public static final String ENTITY_PREFIX = "MEMBER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = ENTITY_PREFIX + "_PASSWORD")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = ENTITY_PREFIX + "_ROLE", nullable = false)
    @Builder.Default
    private MemberRole role = MemberRole.MEMBER;

    @Column(name = ENTITY_PREFIX + "PROVIDER")
    private String provider;

    @Column(name = ENTITY_PREFIX + "PROVIDER_ID")
    private String providerId;

    @Column(name = ENTITY_PREFIX + "NAME")
    private String name;
}

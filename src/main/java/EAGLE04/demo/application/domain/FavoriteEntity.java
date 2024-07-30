package EAGLE04.demo.application.domain;

import EAGLE04.demo.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = FavoriteEntity.ENTITY_PREFIX + "_TB")
@Builder(toBuilder = true)
public class FavoriteEntity extends BaseEntity {
    public static final String ENTITY_PREFIX = "FAVORITE";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = MemberEntity.ENTITY_PREFIX + "_PK")
    private MemberEntity memberEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = CatergoryEntity.ENTITY_PREFIX + "_PK")
    private CatergoryEntity catergoryEntity;
}

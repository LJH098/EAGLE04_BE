package EAGLE04.demo.application.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = ItemEntity.ENTITY_PREFIX + "_TB")
@Builder(toBuilder = true)
public class ItemEntity {
    public static final String ENTITY_PREFIX = "ITEM";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_NAME", unique = true)
    private String name;

    @Column(name = ENTITY_PREFIX + "_DESCRIPTION", nullable = false, columnDefinition="TEXT")
    private String description;

    @Column(name = ENTITY_PREFIX + "_ADDITIONAL_DESCRIPTION", columnDefinition="TEXT")
    private String additionalDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = CategoryEntity.ENTITY_PREFIX + "_PK")
    private CategoryEntity categoryEntity;

    @Column(name = ENTITY_PREFIX + "IMAGE_URL")
    private String imageUrl;
}

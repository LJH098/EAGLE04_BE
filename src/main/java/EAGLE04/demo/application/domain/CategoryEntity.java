package EAGLE04.demo.application.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = CategoryEntity.ENTITY_PREFIX + "_TB")
@Builder(toBuilder = true)
public class CategoryEntity {
    public static final String ENTITY_PREFIX = "CATERGORY";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_NAME", unique = true)
    private String name;

    @OneToMany(mappedBy = "categoryEntity", fetch = FetchType.LAZY)
    private List<ItemEntity> itemEntities = new ArrayList<>();
}

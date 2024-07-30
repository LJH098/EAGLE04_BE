package EAGLE04.demo.application.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = CatergoryEntity.ENTITY_PREFIX + "_TB")
@Builder(toBuilder = true)
public class CatergoryEntity {
    public static final String ENTITY_PREFIX = "CATERGORY";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_NAME", unique = true)
    private String name;
}

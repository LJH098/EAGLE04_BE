package EAGLE04.demo.adapter.out.jpa.category;

import EAGLE04.demo.application.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}

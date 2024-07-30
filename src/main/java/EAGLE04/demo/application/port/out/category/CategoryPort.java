package EAGLE04.demo.application.port.out.category;

import EAGLE04.demo.application.domain.CategoryEntity;

import java.util.List;

public interface CategoryPort {
    CategoryEntity findById(Long id);
    List<CategoryEntity> findAll();
}

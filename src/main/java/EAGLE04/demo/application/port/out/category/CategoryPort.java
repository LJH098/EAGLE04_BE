package EAGLE04.demo.application.port.out.category;

import EAGLE04.demo.application.domain.CategoryEntity;

public interface CategoryPort {
    CategoryEntity findById(Long id);
}

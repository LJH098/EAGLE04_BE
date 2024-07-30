package EAGLE04.demo.adapter.out.jpa.category;

import EAGLE04.demo.application.domain.CategoryEntity;
import EAGLE04.demo.application.port.out.category.CategoryPort;
import EAGLE04.demo.common.exception.category.CategoryNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPort {
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> CategoryNotFoundException.EXECPTION);
    }

    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepository.findAll();
    }
}

package EAGLE04.demo.application.service.category;

import EAGLE04.demo.adapter.in.category.response.GetCategoriesResponse;
import EAGLE04.demo.application.port.in.catergory.GetCategoriesUseCase;
import EAGLE04.demo.application.port.out.category.CategoryPort;
import EAGLE04.demo.common.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetCategoriesService implements GetCategoriesUseCase {
    private final CategoryPort categoryPort;

    @Override
    public GetCategoriesResponse getCategories() {
        List<CategoryDTO> categoryDTOs =  categoryPort.findAll().stream()
                .map(CategoryDTO::of)
                .toList();
        return new GetCategoriesResponse(categoryDTOs);
    }
}

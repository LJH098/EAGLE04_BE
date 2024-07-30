package EAGLE04.demo.application.service.category;

import EAGLE04.demo.adapter.in.category.response.GetItemsResponse;
import EAGLE04.demo.application.domain.CategoryEntity;
import EAGLE04.demo.application.port.in.catergory.GetItemsUseCase;
import EAGLE04.demo.application.port.out.category.CategoryPort;
import EAGLE04.demo.common.dto.ItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetItemsService implements GetItemsUseCase {
    private final CategoryPort categoryPort;

    @Override
    public GetItemsResponse getItems(Long categoryId) {
        CategoryEntity category = categoryPort.findById(categoryId);
        List<ItemDTO> itemDTOS = category.getItemEntities().stream()
                .map(ItemDTO::of)
                .toList();
        return new GetItemsResponse(itemDTOS);
    }
}

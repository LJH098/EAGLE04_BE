package EAGLE04.demo.application.port.in.catergory;

import EAGLE04.demo.adapter.in.category.response.GetItemsResponse;
import EAGLE04.demo.common.dto.ItemDTO;

import java.util.List;

public interface GetItemsUseCase {
    GetItemsResponse getItems(Long categoryId);
}

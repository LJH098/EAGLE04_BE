package EAGLE04.demo.application.port.in.catergory;

import EAGLE04.demo.adapter.in.category.response.GetItemsResponse;

public interface GetItemsUseCase {
    GetItemsResponse getItems(Long categoryId);
}

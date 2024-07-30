package EAGLE04.demo.adapter.in.category;

import EAGLE04.demo.adapter.in.ApiResult;
import EAGLE04.demo.adapter.in.ApiUtils;
import EAGLE04.demo.adapter.in.category.response.GetItemsResponse;
import EAGLE04.demo.application.port.in.catergory.GetItemsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private final GetItemsUseCase getItemsUseCase;

    @GetMapping("{category-id}/items")
    public ApiResult<GetItemsResponse> getItems(@PathVariable("category-id") Long categoryId) {
        return ApiUtils.success(getItemsUseCase.getItems(categoryId));
    }
}

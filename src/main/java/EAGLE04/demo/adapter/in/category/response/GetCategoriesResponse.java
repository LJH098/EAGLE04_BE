package EAGLE04.demo.adapter.in.category.response;

import EAGLE04.demo.common.dto.CategoryDTO;

import java.util.List;

public record GetCategoriesResponse(List<CategoryDTO> categories) {
}

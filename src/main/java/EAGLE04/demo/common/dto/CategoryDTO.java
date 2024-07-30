package EAGLE04.demo.common.dto;

import EAGLE04.demo.application.domain.CategoryEntity;

public record CategoryDTO(Long id, String name) {
    public static CategoryDTO of(CategoryEntity category) {
        return new CategoryDTO(category.getId(), category.getName());
    }
}

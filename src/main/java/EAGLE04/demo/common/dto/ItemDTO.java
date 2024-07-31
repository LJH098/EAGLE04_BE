package EAGLE04.demo.common.dto;

import EAGLE04.demo.application.domain.ItemEntity;
import lombok.Builder;

@Builder
public record ItemDTO(Long id, String name, String description, String imageUrl) {
    public static ItemDTO of(ItemEntity item) {
        return ItemDTO.builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .imageUrl(item.getImageUrl())
                .build();
    }
}

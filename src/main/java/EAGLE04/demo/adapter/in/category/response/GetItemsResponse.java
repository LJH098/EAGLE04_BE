package EAGLE04.demo.adapter.in.category.response;

import EAGLE04.demo.common.dto.ItemDTO;

import java.util.List;

public record GetItemsResponse(List<ItemDTO> items) {
}

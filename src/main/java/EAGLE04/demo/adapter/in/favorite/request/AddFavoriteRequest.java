package EAGLE04.demo.adapter.in.favorite.request;

import java.util.List;

public record AddFavoriteRequest(List<Long> categoryIds) {
}

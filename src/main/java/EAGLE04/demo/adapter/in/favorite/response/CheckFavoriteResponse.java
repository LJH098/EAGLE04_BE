package EAGLE04.demo.adapter.in.favorite.response;

public record CheckFavoriteResponse(Boolean isFavorite, String name) {
    public static CheckFavoriteResponse of(Boolean isFavorite, String name) {
        return new CheckFavoriteResponse(isFavorite, name);
    }
}

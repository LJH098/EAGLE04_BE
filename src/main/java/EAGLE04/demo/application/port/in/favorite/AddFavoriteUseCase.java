package EAGLE04.demo.application.port.in.favorite;

import java.util.List;

public interface AddFavoriteUseCase {
    Void add(Long memberId, List<Long> categoryId);
}

package EAGLE04.demo.application.service.favorite;

import EAGLE04.demo.adapter.in.favorite.response.CheckFavoriteResponse;
import EAGLE04.demo.application.port.in.favorite.CheckFavoriteUseCase;
import EAGLE04.demo.application.port.out.favorite.FavoritePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckFavoriteService implements CheckFavoriteUseCase {
    private final FavoritePort favoritePort;
    @Override
    public Boolean existsByMemberId(Long memberId) {
        return favoritePort.existsByMemberId(memberId);
    }
}

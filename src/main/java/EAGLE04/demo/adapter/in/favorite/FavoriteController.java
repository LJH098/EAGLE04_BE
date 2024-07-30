package EAGLE04.demo.adapter.in.favorite;

import EAGLE04.demo.adapter.in.ApiResult;
import EAGLE04.demo.adapter.in.ApiUtils;
import EAGLE04.demo.adapter.in.favorite.response.CheckFavoriteResponse;
import EAGLE04.demo.application.port.in.favorite.CheckFavoriteUseCase;
import EAGLE04.demo.common.annotation.AuthenticationMemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorite")
public class FavoriteController {
    private final CheckFavoriteUseCase checkFavoriteUseCase;

    @GetMapping("/check")
    public ApiResult<Boolean> check(@AuthenticationMemberId Long memberId) {
        return ApiUtils.success(checkFavoriteUseCase.existsByMemberId(memberId));
    }
}

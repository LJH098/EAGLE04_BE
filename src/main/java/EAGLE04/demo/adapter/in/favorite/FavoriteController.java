package EAGLE04.demo.adapter.in.favorite;

import EAGLE04.demo.adapter.in.ApiResult;
import EAGLE04.demo.adapter.in.ApiUtils;
import EAGLE04.demo.adapter.in.favorite.request.AddFavoriteRequest;
import EAGLE04.demo.application.port.in.favorite.AddFavoriteUseCase;
import EAGLE04.demo.application.port.in.favorite.CheckFavoriteUseCase;
import EAGLE04.demo.common.annotation.AuthenticationMemberId;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorite")
public class FavoriteController {
    private final CheckFavoriteUseCase checkFavoriteUseCase;
    private final AddFavoriteUseCase addFavoriteUseCase;
    @GetMapping("/check")
    public ApiResult<Boolean> check(@AuthenticationMemberId Long memberId) {
        return ApiUtils.success(checkFavoriteUseCase.existsByMemberId(memberId));
    }

    @PostMapping("/add")
    public ApiResult<Void> add(@AuthenticationMemberId Long memberId,@RequestBody AddFavoriteRequest request) {
        return ApiUtils.success(addFavoriteUseCase.add(memberId, request.categoryIds()));
    }
}

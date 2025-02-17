package EAGLE04.demo.adapter.in.auth;

import EAGLE04.demo.adapter.in.ApiResult;
import EAGLE04.demo.adapter.in.ApiUtils;
import EAGLE04.demo.adapter.in.auth.request.LoginRequest;
import EAGLE04.demo.adapter.in.auth.request.NaverLoginRequest;
import EAGLE04.demo.adapter.in.auth.response.LoginResponse;
import EAGLE04.demo.adapter.in.auth.response.NaverLoginResponse;
import EAGLE04.demo.application.port.in.auth.LoginUseCase;
import EAGLE04.demo.application.port.in.auth.NaverLoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final NaverLoginUseCase naverLoginUseCase;
    private final LoginUseCase loginUseCase;
    @PostMapping("/login/naver")
    public ApiResult<NaverLoginResponse> naverLogin(@RequestBody NaverLoginRequest request) {
        NaverLoginResponse response = naverLoginUseCase.naverLogin(request.code(), request.state());
        return ApiUtils.success(response);
    }

    @PostMapping("/login")
    public ApiResult<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = loginUseCase.login(request);
        return ApiUtils.success(response);
    }
}

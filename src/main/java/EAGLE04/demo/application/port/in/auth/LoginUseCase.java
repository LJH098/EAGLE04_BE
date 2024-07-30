package EAGLE04.demo.application.port.in.auth;

import EAGLE04.demo.adapter.in.auth.request.LoginRequest;
import EAGLE04.demo.adapter.in.auth.response.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest request);
    LoginResponse signIn(LoginRequest request);
}

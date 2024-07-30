package EAGLE04.demo.application.port.in.auth;

import EAGLE04.demo.adapter.in.auth.response.NaverLoginResponse;

public interface NaverLoginUseCase {
    NaverLoginResponse naverLogin(String code, String state);
}

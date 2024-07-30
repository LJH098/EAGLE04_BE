package EAGLE04.demo.adapter.in.auth.response;

import lombok.Builder;

@Builder
public record NaverLoginResponse(String accessToken) {
    public static NaverLoginResponse from(String accessToken) {
        return NaverLoginResponse.builder()
                .accessToken(accessToken)
                .build();
    }
}

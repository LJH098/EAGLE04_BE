package EAGLE04.demo.adapter.in.auth.response;

import lombok.Builder;

@Builder
public record LoginResponse(String accessToken, String name) {
}

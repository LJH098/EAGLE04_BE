package EAGLE04.demo.common.dto;

import lombok.Builder;

@Builder
public record NaverInfoDTO(String name, String providerId, String provider, String email) {
}

package EAGLE04.demo.common.dto.papago;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PapagoResponseDto(@JsonProperty("message")PapagoMessage message) {
}

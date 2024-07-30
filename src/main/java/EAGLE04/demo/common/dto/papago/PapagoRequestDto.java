package EAGLE04.demo.common.dto.papago;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record PapagoRequestDto(@JsonProperty("text")String text,
                               @JsonProperty("target")String target,
                               @JsonProperty("source")String source) {
}

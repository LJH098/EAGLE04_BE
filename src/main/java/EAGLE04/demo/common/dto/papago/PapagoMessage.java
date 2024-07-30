package EAGLE04.demo.common.dto.papago;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PapagoMessage(@JsonProperty("result")PapagoResult result) {
}

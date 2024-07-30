package EAGLE04.demo.common.dto.papago;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record PapagoResult(@JsonProperty("translatedText")String translatedtext,
                           @JsonProperty("tarLangType")String tarlangtype,
                           @JsonProperty("srcLangType")String srclangtype) {
}

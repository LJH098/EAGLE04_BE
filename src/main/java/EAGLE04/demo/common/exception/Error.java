package EAGLE04.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Error {

    private String code;

    private String reason;

    private String status;
}
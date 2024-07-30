package EAGLE04.demo.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EagleException extends RuntimeException{
    private BaseError errorCode;

    public Error getError() {
        return this.errorCode.getError();
    }
}

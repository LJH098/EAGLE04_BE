package EAGLE04.demo.common.security.exception;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class UnSupportedJwtException extends AuthenticationException {

    public static AuthenticationException EXECPTION = new UnSupportedJwtException();

    private UnSupportedJwtException() {
        super(SecurityErrorCode.UNSUPPORTED_JWT.getCode());
    }
}

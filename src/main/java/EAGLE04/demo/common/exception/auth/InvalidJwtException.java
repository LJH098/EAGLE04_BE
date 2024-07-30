package EAGLE04.demo.common.exception.auth;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class InvalidJwtException extends AuthenticationException {

    public static AuthenticationException EXECPTION = new InvalidJwtException();

    private InvalidJwtException() {
        super(SecurityErrorCode.INVALID_JWT.getReason());
    }
}

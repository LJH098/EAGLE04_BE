package EAGLE04.demo.common.security.exception;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class ExpiredJwtException extends AuthenticationException {

    public static AuthenticationException EXECPTION = new ExpiredJwtException();

    private ExpiredJwtException() {
        super(SecurityErrorCode.EXPIRED_JWT.getReason());
    }
}

package EAGLE04.demo.common.exception.auth;

import lombok.Getter;
import org.springframework.security.core.AuthenticationException;

@Getter
public class SignatureJwtException extends AuthenticationException {

    public static AuthenticationException EXECPTION = new SignatureJwtException();

    public SignatureJwtException() {
        super(SecurityErrorCode.SIGNATURE_JWT.getReason());
    }
}

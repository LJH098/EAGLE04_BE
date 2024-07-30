package EAGLE04.demo.common.exception.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SecurityErrorCode {
    INVALID_JWT(401, "AUTH_401_1", "잘못된 토큰입니다."),
    EXPIRED_JWT(401, "AUTH_401_2", "만료된 토큰입니다."),
    UNSUPPORTED_JWT(401, "AUTH_401_3", "지원되지 않는 토큰입니다."),
    SIGNATURE_JWT(401, "AUTH_401_4", "토큰의 형식이 잘못 됬습니다."),
    NEED_AUTHENTICATION(401, "AUTH_401_4", "인증이 필요합니다."),
    NO_PERMISSION(403, "AUTH_403_1", "권한이 없습니다."),
;
    private final Integer status;
    private final String code;
    private final String reason;
}

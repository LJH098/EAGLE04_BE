package EAGLE04.demo.common.config;

import EAGLE04.demo.adapter.in.ApiResult;
import EAGLE04.demo.adapter.in.ApiUtils;
import EAGLE04.demo.common.exception.EagleException;
import EAGLE04.demo.common.exception.Error;
import EAGLE04.demo.common.exception.auth.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ExpiredJwtException.class)
    protected ApiResult<?> handleExpiredJwtAuthenticationException(ExpiredJwtException e) {
        return ApiUtils.error(
                SecurityErrorCode.EXPIRED_JWT.getReason(),
                HttpStatus.UNAUTHORIZED,
                SecurityErrorCode.EXPIRED_JWT.getCode());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnSupportedJwtException.class)
    protected ApiResult<?> handleUnsupportedJwtException(UnSupportedJwtException e) {
        return ApiUtils.error(
                SecurityErrorCode.UNSUPPORTED_JWT.getReason(),
                HttpStatus.UNAUTHORIZED,
                SecurityErrorCode.UNSUPPORTED_JWT.getCode());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidJwtException.class)
    protected ApiResult<?> handleInvalidJwtException(InvalidJwtException e) {
        return ApiUtils.error(
                SecurityErrorCode.UNSUPPORTED_JWT.getReason(),
                HttpStatus.UNAUTHORIZED,
                SecurityErrorCode.INVALID_JWT.getCode());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SignatureJwtException.class)
    protected ApiResult<?> handleSignatureJwtException(SignatureJwtException e) {
        return ApiUtils.error(
                SecurityErrorCode.SIGNATURE_JWT.getReason(),
                HttpStatus.UNAUTHORIZED,
                SecurityErrorCode.SIGNATURE_JWT.getCode());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EagleException.class)
    protected ApiResult<?> handleIllegalArgumentException(EagleException e) {
        Error error = e.getError();
        return ApiUtils.error(error.getReason(), HttpStatus.valueOf(error.getStatus()), error.getCode());
    }
}

package EAGLE04.demo.common.config;

import EAGLE04.demo.adapter.in.ApiResult;
import EAGLE04.demo.adapter.in.ApiUtils;
import EAGLE04.demo.common.exception.EagleException;
import EAGLE04.demo.common.exception.Error;
import EAGLE04.demo.common.exception.auth.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.format.DateTimeParseException;


@RestControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({InvalidFormatException.class, DateTimeParseException.class})
    public ApiResult<?> jsonParseExceptionHandler(
            JsonProcessingException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
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
    protected ApiResult<?> handleEagleExceptuonHandler(EagleException e) {
        Error error = e.getError();
        return ApiUtils.error(error.getReason(), HttpStatus.valueOf(error.getStatus()), error.getCode());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
    protected ApiResult<?> handleNoHandlerFoundException(NoHandlerFoundException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ApiResult<?> handleMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ApiResult<?> handleException(Exception e) {
        return ApiUtils.error(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

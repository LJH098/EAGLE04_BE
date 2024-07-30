package EAGLE04.demo.common.exception.auth;

import EAGLE04.demo.adapter.in.ApiUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@Slf4j
public class JwtAuthenticationPoint implements AuthenticationEntryPoint {

    private final HandlerExceptionResolver resolver;

    public JwtAuthenticationPoint(
            @Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException {
        if (request.getAttribute("exception") == null) {
            handleAuthenticationException(response);
        } else {
            resolver.resolveException(
                    request, response, null, (Exception) request.getAttribute("exception"));
        }
    }

    private void handleAuthenticationException(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.isCommitted();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                response.getWriter(),
                ApiUtils.error(SecurityErrorCode.NEED_AUTHENTICATION.getReason(),
                        HttpStatus.BAD_REQUEST, SecurityErrorCode.NEED_AUTHENTICATION.getCode()));

    }
}

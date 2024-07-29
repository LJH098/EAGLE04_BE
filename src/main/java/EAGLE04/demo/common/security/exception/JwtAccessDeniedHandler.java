package EAGLE04.demo.common.security.exception;

import EAGLE04.demo.adapter.in.ApiUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAccessDeniedHandler
        implements org.springframework.security.web.access.AccessDeniedHandler {

    @Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException)
            throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.isCommitted();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                response.getWriter(),
                ApiUtils.error(
                        SecurityErrorCode.NO_PERMISSION.getReason(),
                        HttpStatus.FORBIDDEN,
                        SecurityErrorCode.NO_PERMISSION.getCode()));
    }
}

package EAGLE04.demo.adapter.in;

import org.springframework.http.HttpStatus;

public class ApiUtils {
    public static <T>ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

    public static ApiResult<?> error(String message, HttpStatus status, String code){
        return new ApiResult<>(false, null, new ApiError(message, status.value(),code));
    }
    private ApiUtils() {}
}
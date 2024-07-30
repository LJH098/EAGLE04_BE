package EAGLE04.demo.adapter.in;


import lombok.Getter;

@Getter
public class ApiError {
    private final String message;
    private final int status;
    private final String code;
    public ApiError(String message, int status, String code) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

    public ApiError(String message, int status) {
        this.message = message;
        this.status = status;
        this.code = null;
    }
}
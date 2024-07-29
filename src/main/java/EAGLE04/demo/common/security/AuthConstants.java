package EAGLE04.demo.common.security;

public enum AuthConstants {
    AUTH_HEADER("Authorization"),
    TOKEN_TYPE("Bearer ");

    private final String value;

    AuthConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

package EAGLE04.demo.application.domain;

public enum MemberRole {
    MEMBER("MEMBER"),
    ADMIN("ADMIN");

    private final String role;

    MemberRole(String role) {
        this.role = role;
    }
}

package EAGLE04.demo.common.exception.member;

import EAGLE04.demo.common.exception.BaseError;
import EAGLE04.demo.common.exception.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberError implements BaseError {
    MEMBER_NOT_FOUND(400, "MEMBER_400_1", "존재하지 않는 회원입니다."),
    ;
    private final Integer status;
    private final String code;
    private final String reason;

    @Override
    public Error getError() {
        return Error.builder().reason(reason).code(code).status(status).build();
    }
}


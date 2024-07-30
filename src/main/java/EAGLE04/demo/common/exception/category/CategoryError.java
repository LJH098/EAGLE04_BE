package EAGLE04.demo.common.exception.category;

import EAGLE04.demo.common.exception.BaseError;
import EAGLE04.demo.common.exception.Error;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryError implements BaseError {
    CATEGORY_NOT_FOUND(400, "CATEGORY_400_1", "존재하지 않는 카테고리입니다."),
    ;
    private final Integer status;
    private final String code;
    private final String reason;

    @Override
    public Error getError() {
        return Error.builder().reason(reason).code(code).status(status).build();
    }
}


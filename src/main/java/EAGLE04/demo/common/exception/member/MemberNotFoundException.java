package EAGLE04.demo.common.exception.member;

import EAGLE04.demo.common.exception.EagleException;
import lombok.Getter;

@Getter
public class MemberNotFoundException extends EagleException {
    public static EagleException EXECPTION = new MemberNotFoundException();

    private MemberNotFoundException() {
        super(MemberError.MEMBER_NOT_FOUND);
    }
}

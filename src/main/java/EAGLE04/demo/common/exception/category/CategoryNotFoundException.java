package EAGLE04.demo.common.exception.category;

import EAGLE04.demo.common.exception.EagleException;
import lombok.Getter;

@Getter
public class CategoryNotFoundException extends EagleException {
    public static EagleException EXECPTION = new CategoryNotFoundException();

    private CategoryNotFoundException() {
        super(CategoryError.CATEGORY_NOT_FOUND);
    }
}

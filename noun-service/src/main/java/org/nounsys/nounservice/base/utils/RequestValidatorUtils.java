package org.nounsys.nounservice.base.utils;

import org.nounsys.nounservice.base.exception.ServiceException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Tom Li
 * @date : Created on 2017/9/28.
 */
public class RequestValidatorUtils {

    private final static String APP_ID = "noun-service";

    public static void checkHasError(BindingResult br) {
        if (br.hasFieldErrors()) {
            List<FieldError> fieldErrorList = br.getFieldErrors();
            List<String> errors = new ArrayList<>(fieldErrorList.size());
            for (FieldError error : fieldErrorList) {
                errors.add(error.getField() + ":" + error.getDefaultMessage());
            }
            throw new ServiceException(APP_ID + "_" + "600", errors.toString());
        }
    }
}

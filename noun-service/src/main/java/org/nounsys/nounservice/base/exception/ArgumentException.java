package org.nounsys.nounservice.base.exception;

/**
 * 描述: 参数异常
 *
 * @author danny
 * @date 2018/10/22 上午11:13
 */
public class ArgumentException extends ServiceException {
    private final static String APP_ID = "noun-service";
    private ErrorCodeEnum errorCode;

    public ArgumentException(ErrorCodeEnum errorCode) {
        super(APP_ID + "_" + errorCode.getErrorCode(), errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public ArgumentException(ErrorCodeEnum errorCode, Throwable cause) {
        super(APP_ID + "_" + errorCode.getErrorCode(), errorCode.getErrorMessage(), cause);
        this.errorCode = errorCode;
    }
}

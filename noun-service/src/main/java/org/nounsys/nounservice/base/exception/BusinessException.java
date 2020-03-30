package org.nounsys.nounservice.base.exception;

/**
 * 描述: 业务异常
 *
 * @author gaoxu
 * @date 2018/10/22 上午11:27
 */
public class BusinessException extends ServiceException {

    private final static String APP_ID = "noun-service";
    private ErrorCodeEnum errorCode;

    public BusinessException(ErrorCodeEnum errorCode) {
        super(APP_ID + "_" + errorCode.getErrorCode(), errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(ErrorCodeEnum errorCode, Throwable cause) {
        super(APP_ID + "_" + errorCode.getErrorCode(), errorCode.getErrorMessage(), cause);
        this.errorCode = errorCode;
    }
}

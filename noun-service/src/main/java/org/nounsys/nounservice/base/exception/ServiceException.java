package org.nounsys.nounservice.base.exception;

/**
 * @author : gaoxu
 * @date : Created on 2020/3/16
 */

public class ServiceException extends RuntimeException {

    private String errCode;
    private String errMsg;

    /**
     * Constructs a new service exception with the specified error code and error message.
     */
    public ServiceException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    /**
     * Constructs a new service exception with the specified error code, error message and cause.
     *
     * <p>NOTE: the exception cause is normally not needed unless you want to suppress some system
     * exception and rethrow it as a new service exception.
     */
    public ServiceException(String errCode, String errMsg, Throwable cause) {
        super(errMsg, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }
}

package com.elitebutler.exception;

import lombok.Data;

/**
 * 自定义异常类
 */
@Data
public class EliteButlerException extends RuntimeException {

    private String errMessage;

    public EliteButlerException() {
        super();
    }

    public EliteButlerException(String errMessage) {
        super(errMessage);
        this.errMessage = errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public static void cast(CommonError commonError){
        throw new EliteButlerException(commonError.getErrMessage());
    }
    public static void cast(String errMessage){
        throw new EliteButlerException(errMessage);
    }

}

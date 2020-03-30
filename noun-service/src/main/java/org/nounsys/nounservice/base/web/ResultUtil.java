package org.nounsys.nounservice.base.web;

import org.nounsys.nounservice.base.constant.ComErrorCodeConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:gaoxu
 * @create:2020-03-23 10:32
 **/
public class ResultUtil {
    public ResultUtil() {
    }

    public static Map<String, Object> creObjSucResult(Object obj) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.SYSTEM_SUCCESS.getErrorCode());
        resultMap.put("obj", obj);
        return resultMap;
    }

    public static Map<String, Object> creComSucResult() {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.SYSTEM_SUCCESS.getErrorCode());
        return resultMap;
    }

    public static Map<String, Object> creListSucResult(List list) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.SYSTEM_SUCCESS.getErrorCode());
        Map<String, Object> listMap = new HashMap();
        listMap.put("list", list);
        resultMap.put("obj", listMap);
        return resultMap;
    }

    public static Map<String, Object> creComErrorResult(String message) {
        if (message != null && !message.equals("")) {
            Map<String, Object> resultMap = new HashMap();
            resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.DATA_EMPTY_ERROR.getErrorCode());
            resultMap.put("msg", message);
            return resultMap;
        } else {
            return creComErrorResult();
        }
    }

    public static Map<String, Object> creComEmptyResult() {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.DATA_EMPTY_ERROR.getErrorCode());
        resultMap.put("msg", ComErrorCodeConstants.ErrorCode.DATA_EMPTY_ERROR.getMemo());
        return resultMap;
    }

    public static Map<String, Object> creComErrorResult(String errorCode, String message) {
        if (message != null && !message.equals("")) {
            Map<String, Object> resultMap = new HashMap();
            resultMap.put("resCode", errorCode);
            resultMap.put("msg", message);
            return resultMap;
        } else {
            return creComErrorResult();
        }
    }

    public static Map<String, Object> creComErrorResult() {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.DATA_EMPTY_ERROR.getErrorCode());
        resultMap.put("msg", ComErrorCodeConstants.ErrorCode.DATA_EMPTY_ERROR.getMemo());
        return resultMap;
    }

    public static <T> Map<String, Object> creListErrorResult(List<T> list) {
        Map<String, Object> resultMap = new HashMap();
        resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.APPLICATION_OPER_ERROR.getErrorCode());
        Map<String, Object> listMap = new HashMap();
        listMap.put("list", list);
        resultMap.put("obj", listMap);
        return resultMap;
    }

    public static Map<String, Object> creComSucResult(boolean flag) {
        Map<String, Object> resultMap = new HashMap();
        if (flag) {
            resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.SYSTEM_SUCCESS.getErrorCode());
        } else {
            resultMap.put("resCode", ComErrorCodeConstants.ErrorCode.UPDATE_STATUS_ERROR.getErrorCode());
        }

        return resultMap;
    }
}

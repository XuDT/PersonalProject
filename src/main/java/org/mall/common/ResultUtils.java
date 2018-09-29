package org.mall.common;

import com.alibaba.fastjson.JSON;

/*
* 结果类
* */
public class ResultUtils {
    //返回结果true：成功，false：失败
    private boolean success = true;
    //返回信息
    private String msg;
    //返回结果集
    private Object result;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ResultUtils() {
    }

    public ResultUtils(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public ResultUtils(boolean success, String msg, Object result) {
        this.success = success;
        this.msg = msg;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }
    /*
     * 返回成功结果
     * */
    public Object successResult(){
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setSuccess(true);
        resultUtils.setMsg("success");
        resultUtils.setResult(null);
        return JSON.toJSON(resultUtils);
    }
    /*
     * 返回成功结果
     * */
    public Object successResult(Object obj){
        //判断参数obj是否是String类型
        if (obj instanceof String){
            return successResult(null, (String) obj);
        }else{
            return successResult(obj, "error");
        }
    }

    /*
     * 返回成功结果
     * */
    public Object successResult(Object obj, String msg){
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setSuccess(true);
        resultUtils.setMsg(msg);
        resultUtils.setResult(obj);
        return JSON.toJSON(resultUtils);
    }
    /*
     * 返回错误结果
     * */
    public Object errorResult(){
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setSuccess(false);
        resultUtils.setMsg("error");
        resultUtils.setResult(null);
        return JSON.toJSON(resultUtils);
    }
    /*
     * 返回错误结果
     * */
    public Object errorResult(Object obj){
        if (obj instanceof String){
            return renderJsonError(null, (String) obj);
        }else{
            return renderJsonError(obj, "error");
        }
    }
    /*
     * 返回错误结果
     * */
    public Object renderJsonError(Object obj, String msg){
        ResultUtils resultUtils = new ResultUtils();
        resultUtils.setSuccess(false);
        resultUtils.setMsg(msg);
        resultUtils.setResult(obj);
        return JSON.toJSON(resultUtils);
    }
}

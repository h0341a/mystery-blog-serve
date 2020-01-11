package personal.msbs.response;

import java.io.Serializable;

/**
 * @author ling
 */
public class Result implements Serializable {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 服务器当前timestamp
     */
    private Long ts = System.currentTimeMillis();
    /**
     * 成功时返回的数据
     */
    private Object data;
    /**
     *失败时返回的错误码
     */
    private String code;
    /**
     * 错误信息
     */
    private String msg;

    public static Result ofSuccess(Object data){
        Result result = new Result();
        result.success = true;
        result.data = data;
        return result;
    }

    public static Result ofFail(ErrorCodeEnum errorCode){
        Result result = new Result();
        result.success = false;
        result.code = errorCode.getCode();
        result.msg = errorCode.getMsg();
        return result;
    }

}

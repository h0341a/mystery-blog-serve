package personal.msbs.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author ling
 */
@Getter
@Setter
public class Result implements Serializable {

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 服务器当前timestamp
     */
    private Long timestamp = System.currentTimeMillis();
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
        return ofFail(errorCode, errorCode.getMsg());
    }

    /**
     * 符合该错误码的错误提供可自定义的提示信息
     * @param errorCode 错误码
     * @param customHint 提示信息
     * @return 错误结果
     */
    public static Result ofFail(ErrorCodeEnum errorCode, String customHint){
        Result result = new Result();
        result.setCode(errorCode.getCode());
        result.setMsg(errorCode.getMsg());
        return result;
    }

}

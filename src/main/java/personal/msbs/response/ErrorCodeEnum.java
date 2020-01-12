package personal.msbs.response;

import lombok.Getter;

/**
 * @author ling
 *400为客户端相关的错误信息
 */
@Getter
public enum  ErrorCodeEnum {
    /**
     * 400 客户端发出的请求出错
     */
    PARAMETER_NOT_NULL("401", "参数不能为空"),
    USER_CHECKING_FAIL("402", "账号或密码错误")
    ;
    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

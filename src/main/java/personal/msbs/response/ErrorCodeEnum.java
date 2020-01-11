package personal.msbs.response;

import lombok.Getter;

/**
 * @author ling
 */
@Getter
public enum  ErrorCodeEnum {
    /**
     * 404 服务器找不到客户机器所发出的请求.
     */
    NOT_FOUND("404", "API接口不存在"),
    ;
    private String code;
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

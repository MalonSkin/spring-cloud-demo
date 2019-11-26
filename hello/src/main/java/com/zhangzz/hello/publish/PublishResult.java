package com.zhangzz.hello.publish;

/**
 * 推送到光栅使用的返回结果实体类
 */
public class PublishResult {

    public static final String SUCCESS_CODE = "0";

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PublishResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

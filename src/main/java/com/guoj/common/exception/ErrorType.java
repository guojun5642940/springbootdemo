package com.guoj.common.exception;

import lombok.Getter;

@Getter
public enum ErrorType {

    SYSTEM_ERROR("-1", "系统异常"),

    SYSTEM_BUSY("000001", "系统繁忙,请稍候再试"),
    SYSTEM_NO_PERMISSION("000002", "无权限"),

    GATEWAY_NOT_FOUND_SERVICE("010404", "服务未找到"),
    GATEWAY_ERROR("010500", "网关异常"),
    GATEWAY_CONNECT_TIME_OUT("010002", "网关超时"),

    ARGUMENT_NOT_VALID("020000", "请求参数校验不通过"),
    UPLOAD_FILE_SIZE_LIMIT("020001", "上传文件大小超过限制"),
    ACCOUNT_EXCEPTION("030001", "账号或密码错误"),
    DISABLED_ACCOUNT_EXCEPTION("030002","账号不可用"),
    UNEXPIRED_CREDENTIALS_EXCEPTION("030003", "您的账号未到有效期"),
    EXPIRED_CREDENTIALS_EXCEPTION("030004", "您的账号已过期"),
    INCORRECT_CREDENTIALS_EXCEPTION("030005","密码错误"),
    LOGINNAME_HAS_BEEN_REGISTERED("030006","该用户名已被注册"),
    LOCKED_ACCOUNT_EXCEPTION("030007","账号已被锁定，请30分钟后重试"),
    PLEASE_LOGIN("030008", "未登录或登录已过期，请登录"),
    PASSWORD_IS_NOT_BE_BLANK("030009", "用户密码不能为空，或长度不小于6个字符"),
    ACCOUNT_IS_NOT_EXIST("030010","账号不可用"),
    TOKEN_CHECK_ERROR("030011","token检查错误"),
    NO_USER_ERROR("030012","用户不存在");


    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    ErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

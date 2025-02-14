package com.linyi.entity;

import lombok.Data;

/**
 * @Author: linyi
 * @Date: 2025/2/14
 * @ClassName: Result
 * @Version: 1.0
 * @Description: 全局统一返回结果类
 */
@Data
public class Result<T> {
    // 返回码
    private Integer code;

    // 返回消息
    private String message;

    // 返回数据
    private T data;

    // 私有构造函数，防止外部直接实例化
    private Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 成功时的静态方法
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "Success", data);
    }

    // 成功时的静态方法，无数据
    public static <T> Result<T> success() {
        return new Result<>(200, "Success", null);
    }

    // 失败时的静态方法
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }
}

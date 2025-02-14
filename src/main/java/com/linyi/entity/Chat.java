package com.linyi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: linyi
 * @Date: 2025/2/14
 * @ClassName: Char
 * @Version: 1.0
 * @Description: 对话
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "对话")
public class Chat implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //输入信息
    private String senderMessage;

    //输出信息
    private String receiverMessage;

    //状态 true：成功 false：失败
    private boolean status;

    //耗时
    private String cost;

    //模型
    private String model;

}


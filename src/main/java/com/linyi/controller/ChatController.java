package com.linyi.controller;

import com.linyi.config.OllamaConfig;
import com.linyi.entity.Chat;
import com.linyi.entity.Result;
import com.linyi.utils.MdUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: linyi
 * @Date: 2025/2/14
 * @ClassName: ChatController
 * @Version: 1.0
 * @Description:
 */
@Tag(name = "ChatController", description = "调用 Ollama 模型")
@Slf4j
@RestController
@SuppressWarnings({"unchecked", "rawtypes"})
public class ChatController {
    @Resource
    private OllamaConfig ollamaConfig;

    @Value("${ai.ollama.chat.options.model}")
    private String defaultChatOptionsModel;

    /**
     * 处理聊天请求的控制器方法
     *
     * @param msg 用户输入的聊天消息，不能为空
     * @return 返回聊天机器人的回复结果
     */
    @Operation(summary = "对话")
    @GetMapping("/chat")
    public Result<Chat> chat(String msg) {
        // 记录接收到的问题消息
        log.info("问题是:{}", msg);
        // 初始化结果字符串
        String result = "";

        // 检查消息是否为空，如果为空则返回错误提示
        if (StringUtils.isBlank(msg)) {
            return Result.error(400, "请输入chat内容");
        }

        // 创建Prompt对象，包含聊天消息和配置选项
        Prompt prompt = new Prompt(
                msg,
                OllamaOptions.builder()
                        .withModel(defaultChatOptionsModel)
                        .withTemperature(0.4)
                        .build()
        );

        // 记录开始时间
        long startTime = System.nanoTime();

        // 调用聊天模型并获取响应
        ChatResponse response = ollamaConfig.getOllamaChatModel().call(prompt);

        // 记录结束时间
        long endTime = System.nanoTime();

        // 计算并打印耗时
        String formattedTimeTaken = String.format("%.2f", (endTime - startTime) / 1e9);
        log.info("耗时: " + formattedTimeTaken + " 秒");

        // 提取并记录聊天机器人的回复内容
        result = response.getResult().getOutput().getContent();
        log.info("回答:{}", result);

        // 返回成功结果，包含聊天机器人的回复
        Chat chat = new Chat(msg, result, true, formattedTimeTaken, defaultChatOptionsModel);
        return Result.success(chat);
    }

    /**
     * 回答写入.md文件
     * 此方法接收用户消息，调用聊天模型生成回复，并将回复内容写入markdown文件中
     * 主要用于演示如何将聊天内容转换为文档保存
     *
     * @param msg 用户输入的消息，用于生成聊天回复
     * @return 聊天模型生成的回复内容
     */
    @Operation(summary = "回答写入.md文件")
    @GetMapping("/chatToMd")
    public Result<Chat> chatToMd(String msg) {
        // 记录用户提问内容
        log.info("问题是:{}", msg);
        // 初始化结果变量
        String result = "";
        // 验证输入内容是否为空
        if (StringUtils.isBlank(msg)) {
            return Result.error(400, "请输入chat内容");
        }

        // 构建聊天模型的提示信息，包括模型参数配置
        Prompt prompt = new Prompt(
                msg,
                OllamaOptions.builder()
                        .withModel(defaultChatOptionsModel)
                        .withTemperature(0.4)
                        .build()
        );
        // 记录开始时间
        long startTime = System.nanoTime();

        // 调用聊天模型生成回复
        ChatResponse response = ollamaConfig.getOllamaChatModel().call(prompt);

        // 记录结束时间
        long endTime = System.nanoTime();

        // 计算并打印耗时
        String formattedTimeTaken = String.format("%.2f", (endTime - startTime) / 1e9);
        log.info("耗时: " + formattedTimeTaken + " 秒");

        // 提取回复内容
        result = response.getResult().getOutput().getContent();

        // 记录回答内容
        log.info("回答:{}", result);

        // 回答写入.md文件
        long l = System.currentTimeMillis();
        MdUtil.createAndWriteMarkdownFile(result, l + ".md");

        // 返回成功结果
        Chat chat = new Chat(msg, result, true, formattedTimeTaken, defaultChatOptionsModel);
        return Result.success(chat);
    }


}


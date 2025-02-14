package com.linyi.config;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: linyi
 * @Date: 2025/2/14
 * @ClassName: OllamaConfig
 * @Version: 1.0
 * @Description: Ollama 配置类
 */
@Configuration
public class OllamaConfig {

    @Value("${ai.ollama.url}")
    private String url;

    /**
     * 创建并返回一个 OllamaChatModel 实例
     * 该实例使用配置文件中定义的 ollama 服务 URL 进行初始化
     *
     * @return 初始化后的 OllamaChatModel 实例
     */
    @Bean
    public OllamaChatModel getOllamaChatModel() {
        return new OllamaChatModel(new OllamaApi(url));
    }
}

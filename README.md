# DeepSeek-Ollama

## 项目介绍

DeepSeek-Ollama项目是一个结合了DeepSeek大语言模型和Ollama运行框架的项目。

**技术选项**

| 名称       | 版本     | 说明                           |
| ---------- | -------- | ------------------------------ |
| Java       | 17       | 编程语言                       |
| SpringBoot | 3.3.5    | 基于Spring框架的开源Java框架   |
| Spring AI  | 1.0.0-M3 | 人工智能集成到Spring应用程序中 |
| Ollama     | 1.0.0-M3 | 与Spring AI相关的项目或库      |
| Knife4j    | 4.4.0    | Swagger UI在中国的增强版       |



## DeepSeek介绍

[DeepSeek](https://www.deepseek.com/)是一家专注于人工智能领域的创新型科技公司，致力于开发先进的大型语言模型。其发布的多个模型，如DeepSeek LLM、DeepSeek-Coder、DeepSeek Math等，在各自领域取得了显著成果。特别是DeepSeek-R1模型，其性能对标OpenAI的o1正式版，在数学、代码、自然语言推理等任务上表现出色。



## Ollama介绍

[Ollama](https://ollama.com/)是一个基于Go语言的本地大语言模型运行框架，类似于Docker产品，保留了Docker的操作习惯，并支持上传大语言模型仓库。Ollama支持多种大型语言模型，如Llama 2、Code Llama、Mistral等，并允许用户根据特定需求定制和创建自己的模型。



**树型结构图：**

```bash
├── deepseek-ollama
│   ├── src  # 源代码文件夹
│   │   ├── main  # 主要源代码目录
│   │   │   ├── java  # Java 源代码文件夹
│   │   │   │   └── com.linyi  # 包名
│   │   │   │       ├── config  # 配置类文件夹
│   │   │   │       │   ├── OllamaConfig.java  # Ollama 配置类
│   │   │   │       │   └── WebConfig.java  # Web 配置类
│   │   │   │       ├── controller  # 控制器文件夹
│   │   │   │       │   └── ChatController.java  # 聊天控制器类
│   │   │   │       └── DeekSeepollamaApplication.java  # 主应用程序启动类
│   │   │   ├── entity  # 实体类文件夹
│   │   │   │   ├── Chat.java  # 聊天实体类
│   │   │   │   └── Result.java  # 结果实体类
│   │   │   └── utils  # 工具类文件夹
│   │   │       └── MdUtil.java  # MarkDown 工具类
│   │   ├── resources  # 配置资源文件夹
│   │   │   ├── application.yml  # 应用配置文件
│   │   │   └── banner.txt  # 启动欢迎信息文本
│   └── test  # 测试代码目录
│       └── java  # Java 测试源代码文件夹
```










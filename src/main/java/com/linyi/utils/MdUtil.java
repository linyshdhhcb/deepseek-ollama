package com.linyi.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author: linyi
 * @Date: 2025/2/14
 * @ClassName: MdUtil
 * @Version: 1.0
 * @Description: Markdown文件操作工具类
 */

public class MdUtil {

    /**
     * 创建并写入Markdown文件
     *
     * @param content 文件内容，即要写入的Markdown格式文本
     * @param fileName 要创建的文件名，包括路径和扩展名
     *
     * 此方法尝试创建一个指定名称的Markdown文件，并将给定的内容写入其中
     * 使用try-with-resources语句确保文件写入操作后资源能自动关闭
     */
    public static void createAndWriteMarkdownFile(String content, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("创建成功: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("创建文件失败: " + fileName, e);
        }
    }
}

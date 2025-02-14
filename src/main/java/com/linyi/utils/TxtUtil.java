package com.linyi.utils;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class TxtUtil {

    /**
     * 读取指定文件的内容并返回为字符串。
     *
     * @param file 要读取的文件对象
     * @return 文件内容的字符串表示
     * @throws IOException 如果读取文件时发生错误
     */
    public static String readTxt(File file) throws IOException {
        // 创建StringBuilder对象以高效地构建文件内容的字符串表示
        StringBuilder content = new StringBuilder();
        // 使用try-with-resources语句自动管理资源，确保文件读取后正确关闭资源
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(file), "UTF-8");
             BufferedReader br = new BufferedReader(in)) {
            String line;
            // 循环读取文件中的每一行，直到文件结束
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        }
        // 返回构建好的文件内容字符串
        return content.toString();
    }

    /**
     * 读取本地路径下的txt文件
     * @param localPath 本地路径
     * @return 本地文件内容
     * @throws IOException 文件读取错误
     */
    public static String readLocalPathTxt(String localPath) {
        try {
            // 读取本地文件
            String localString = TxtUtil.readTxt(new File(localPath));
            log.info(localString);
            return localString;
        } catch (IOException e) {
            log.error("读取文件错误：{}" ,e);
            throw new RuntimeException("读取文件错误：" + e.getMessage());
        }
    }


    /**
     * 读取类路径下的txt文件
     * @param classPath
     * @return
     */
    public static String readClassPathTxt(String classPath) {
        try {
            // 读取类路径下的文件
            String classString = TxtUtil.readTxt(ResourceUtils.getFile(classPath));
            log.info(classString);
            return classString;
        } catch (IOException e) {
            log.error("读取文件错误：{}" ,e);
            throw new RuntimeException("读取文件错误：" + e.getMessage());
        }
    }

}

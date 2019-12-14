package com.cigt.my_util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 上传文件的工具
 */
@Component
public class FileUtils {
    /**
     * 获取文件后缀
     * @param fileName
     * @return
     */
    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成新的文件名
     * @param fileOriginName 源文件名
     * @return
     */
    public String getFileName(String fileOriginName){
        return getUUID() + getSuffix(fileOriginName);
    }

    /**
     * 生成文件名
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}

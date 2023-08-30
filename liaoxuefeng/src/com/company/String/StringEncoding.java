package com.company.String;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Created by Enzo Cotter on 2023/1/30.
 */
public class StringEncoding {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // ANSI指定了 ASCII 编码, 0-127
        // GB2312, Shift_JIS, EUC_KR
        // Unicode 编码, 0-65535
        // UTF-8 编码, 0-1114111; 1-4个字节变长编码; 容错能力强, 通过高位确定字符长度, 中间某字符出错不影响后续
        // Java的String和char在内存中总是以Unicode编码表示
        // Windows系统使用的是GBK编码，Linux系统使用的是UTF-8编码

        byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
        byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
        byte[] b3 = "Hello".getBytes("GBK"); // 按GBK编码转换
        byte[] b4 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换

        // byte -> string
        String s1 = new String(b1); // 按系统默认编码转换，不推荐
        String s2 = new String(b2, "UTF-8"); // 按UTF-8编码转换
        String s3 = new String(b3, "GBK"); // 按GBK编码转换
        String s4 = new String(b4, StandardCharsets.UTF_8); // 按UTF-8编码转换


    }
}

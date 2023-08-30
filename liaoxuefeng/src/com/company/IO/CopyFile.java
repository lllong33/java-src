package com.company.IO;
import java.io.*;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class CopyFile {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("Usage:\n  java CopyFile.java <source> <target>");
			System.exit(1);
		}
		copy(args[0], args[1]);
	}

	static void copy(String source, String target) throws IOException {
		// 友情提示：测试时请使用无关紧要的文件
		// TODO: 路径检测是否有效策略暂不考虑
        // read
        InputStream input = new FileInputStream(source);
        byte[] all_bytes = input.readAllBytes();
        // write
        OutputStream output = new FileOutputStream(target);
        output.write(all_bytes);
	}
}

package com.company.IO;

import java.io.*;

public class CountFileInputStream {
    public static void main(String[] args) throws IOException {
        byte[] data = "hello, world!".getBytes("UTF-8");
        try(CountInputSteam input = new CountInputSteam(new ByteArrayInputStream(data))){
            int n;
            while ((n = input.read()) != -1){
                System.out.println((char)n);
            }
            // TODO 为什么 read 无法遍历读取，输出字符串
            // 参考之前，read只能获取byte类型，只能遍历byte转char
            while ((n = input.read(new byte[1000])) != -1){
                System.out.println("read byte[]");
                System.out.println(n);
            }
            System.out.println("Total read" + input.getByteRead() + "bytes");
        }
    }
}

class CountInputSteam extends FilterInputStream{
    private int count = 0;
    CountInputSteam(InputStream in){
        super(in);
    }

    public int getByteRead(){
        return this.count;
    }

    public int read() throws IOException {
        int n = in.read(); //TODO in 哪里获取?
        if (n != -1){
            this.count ++;
        }
        return n;
    }

    public int read(byte[] b, int off, int len) throws IOException{
        int n = in.read(b, off, len);
        if (n != -1){
            this.count += n;
        }
        return n;
    }


}

package com.company.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class ListFileDemoV2 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\lllong33\\[100]Usual_software_link");
        File[] fs1 = f.listFiles(); // 列出所有文件和子目录
        printFiles(fs1);
    }

    static void printFiles(File[] files) throws IOException {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()){
                    printFiles(f.listFiles());
                }
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }
}

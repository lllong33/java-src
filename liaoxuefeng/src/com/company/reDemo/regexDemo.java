package com.company.reDemo;

import java.util.List;

//请编写一个正则表达式匹配国内的电话号码规则：3~4位区号加7~8位电话，中间用-连接，例如：010-12345678。
public class regexDemo {
    public static void main(String[] args) throws Exception {
        String re = "\\d{3,4}-\\d{7,8}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");

        regexDemo.mainV2();
    }

    //进阶：国内区号必须以0开头，而电话号码不能以0开头，试修改正则表达式，使之能更精确地匹配。
    public static void mainV2() {
        String re = "0\\d{2,3}-[1-9]\\d{7,8}";
        for (String s: List.of("110-12345678", "010-02345678", "010-12345678")){
            System.out.println(s + "; result: " + s.matches(re));
        }
    }

}

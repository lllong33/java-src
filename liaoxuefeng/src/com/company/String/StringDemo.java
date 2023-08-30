package com.company.String;

import java.util.Arrays;

/**
 * Created by Enzo Cotter on 2023/1/30.
 */
public class StringDemo {
    public static void main(String[] args) {
        createMethod();
        compact();

        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }

    static void createMethod(){
        String s1 = "hello";
        String s3 = new String("hello");
        System.out.println(s1);
        System.out.println(s3);
    }

    public static void compact(){
        // == 与 equals() 的区别 ：前者对比的是对象的引用，后者对比的是对象的内容
        String s1 = "hello";
        String s2 = "HELLO".toLowerCase();
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    // 提取子串、查找、替换、大小写转换等
    void stringOperateMethod(){
        "Hello".contains("ll"); // true
        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4); // "ll"

        //去除首尾空白字符
        " \tHello\r\n ".trim(); // "Hello", return new string
        "\u3000Hello\u3000".strip(); // "Hello", \u3000中文空格符 return new string
        "\u3000Hello\u3000".stripLeading(); // "Hello "
        "\u3000Hello\u3000".stripTrailing(); // " Hello"

        // 判断是否空或者空白字符串
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        //替换字符
        String s = "hello";
        s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"

        s = "A,,B;C ,D";
        s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"

        // 分割字符串
        s = "A,B,C,D";
        s.split(","); // ["A", "B", "C", "D"]

        // 拼接字符串
        String[] arr = {"A", "B", "C", "D"};
        String.join(",", arr); // "A,B,C,D"

        // 格式化字符串 format()
        // %s表示字符串，%d表示整数，%f表示浮点数，%x表示十六进制整数, %.2f表示显示两位小数
        // %s可以显示任何数据类型，它会自动调用数据类型的toString()方法
        s = "Hi %s, your score is %d!";
        String.format(s, "小明", 59); // "Hi 小明, your score is 59!"

        // 类型转换
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        Integer.parseInt("123"); // 123
        Integer.parseInt("ff", 16); // 255，第二个参数表示进制

        Boolean.parseBoolean("true"); // true

        Integer.getInteger("java.version"); // 版本号，11

        char[] cs = "Hello".toCharArray(); // String -> char[]
        s = new String(cs); // char[] -> String, 这里会创建一个新的对象; 修改char[]不影响String s

    }
}


class Score {
    private int[] scores;
    public Score(int[] scores) {
        // 深拷贝, 解决引用传递的问题
        this.scores = Arrays.copyOf(scores, scores.length);
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
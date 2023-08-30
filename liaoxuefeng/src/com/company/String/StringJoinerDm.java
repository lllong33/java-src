package com.company.String;

import java.util.StringJoiner;

/**
 * Created by Enzo Cotter on 2023/1/30.
 */
public class StringJoinerDm {
    public static void main(String[] args) {
        // StringJoiner
        //  sj = new StringJoiner(", ", "[", "]");
        // sj.add("Bob").add("Alice").add("Grace");
        // System.out.println(sj.toString()); // [Bob, Alice, Grace]

        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());

        // 解决需要在开头结尾添加字符的问题
        String[] names2 = {"Hello", "Bob", "Alice", "Grace", "!"};
        var s = String.join(", ", names2);
        System.out.println(s);

        ex1();
    }

    private static void ex1() {
        String[] fields = { "name", "position", "salary" };
        String table = "employee";
        String select = buildSelectSql(table, fields);
        String select2 = buildSelectSql2(table, fields);
        System.out.println(select);
        System.out.println(select2);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
        System.out.println("SELECT name, position, salary FROM employee".equals(select2) ? "测试成功" : "测试失败");
    }

    private static String buildSelectSql2(String table, String[] fields) {
        // String.join
        return "SELECT " + String.join(", ", fields) + " FROM " + table;
    }

    private static String buildSelectSql(String table, String[] fields) {
        // StringJoiner
        var sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String field : fields) {
            sj.add(field);
        }
        return sj.toString();
    }
}

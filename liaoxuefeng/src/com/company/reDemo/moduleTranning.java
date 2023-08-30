package com.company.reDemo;

import java.util.HashMap;
import java.util.Map;

public class moduleTranning{
    public static void main(String[] args) {
        String s = "Hello, ${name}! You are learning ${lang}!";
        Map<String, String> map = new HashMap<>();
        map.put("name","Bob");
        map.put("lang","Java");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString());
            String key = entry.getKey().toString();
            String re = "\\$\\{"+key+"\\}";
            System.out.println(re);
            s = s.replaceAll(re, entry.getValue());
        }
        System.out.println(s);
    }
}

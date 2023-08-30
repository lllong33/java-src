package com.company;

import java.util.HashMap;
import java.util.Map;

public class MapEntrySetDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 123);
        map.put("bear", 456);
        map.put("banana", 789);
        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println(k + "=" + v);
        }
    }
}

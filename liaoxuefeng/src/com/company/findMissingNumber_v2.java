package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class findMissingNumber_v2 {

    public static void main(String[] args) {
	// write your code here
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i=start; i < end; i++){
            list.add(i);
        }
        // shuffle random change list and delete one
        Collections.shuffle(list);
        int removed = list.remove((int)(Math.random()*list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number " + found);
        System.out.println(removed == found ? "test success" : "test failed");


    }

    static int findMissingNumber(int start, int end, List<Integer> list){
        // for each list judge missing_number
        for (int i=start; i<end; i++){
            Boolean flag;
            flag=list.contains(i);
            System.out.println(flag);
            if (! flag) {
                return i;
            }
        }
        return 0;
    }
}

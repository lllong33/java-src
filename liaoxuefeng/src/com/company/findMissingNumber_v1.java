package com.company;
import java.util.*;

public class findMissingNumber_v1 {

    public static void main(String[] args) {
	// write your code here
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i=start; i < end; i++){
            list.add(i);
        }
        // random delete List one_
        int removed = list.remove((int)(Math.random()*list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number " + found);
        System.out.println(removed == found ? "test success" : "test failed");


    }

    static int findMissingNumber(int start, int end, List<Integer> list){
        // for each list judge missing_number
        while (list.contains(start)) {
            start ++;
        }
        return start;
    }
}

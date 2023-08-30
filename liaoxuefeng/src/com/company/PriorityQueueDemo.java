package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
//        q.offer(new User("ps1", "B2"));
//        q.offer(new User("ps2", "C4"));
        q.offer(new User("ps3", "A15"));
        q.offer(new User("ps4", "A3"));
        q.offer(new User("boss1", "V1"));
        q.offer(new User("boss2", "V8"));
        System.out.println("start poll ..");
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2){
//        System.out.println("[INFO]" + u1.toString() + " compare " + u2.toString());
        // 相同类型时，比较数字
        if (u1.number.charAt(0) == u2.number.charAt(0)){
            //1.取数字转int类型比较
            //2.长度相等直接比较，不相等时比较长度
            if (u1.number.length() == u2.number.length()){
                return u1.number.compareTo(u2.number);
            } else {
              return u1.number.length() - u2.number.length();
            }
        }else if (u1.number.charAt(0) == 'V'){
            return -1;
        }else if (u2.number.charAt(0) == 'V'){
            return 1;
        }else{
            // 未实现按字母排序
            return u1.number.compareTo(u1.number);
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number){
        this.name = name;
        this.number = number;
    }

    public String toString(){
        return name + "/" + number;
    }
}
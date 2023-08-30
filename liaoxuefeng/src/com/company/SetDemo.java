package com.company;

import java.nio.MappedByteBuffer;
import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        List<Message> received = List.of(
                new Message(1, "Hello"),
                new Message(3, "Where to eat?"),
                new Message(3, "Where to eat?"),
                new Message(2, "Have you got paid yet"),
                new Message(2, "Have you got paid yet"),
                new Message(4, "Bye")
        );
        // remove duplication
//        List<Message> displayMessage = process(received);
        List<Message> displayMessage = processV2(received);
        // print
        for(Message message: displayMessage){
            System.out.println(message.text);
        }
    }
    static List<Message> process(List<Message> received){
        // TODO: remove sequence
        HashSet<String> set = new HashSet<>();
        List<Message> rst = new ArrayList<>();
        for (Message i: received){
            if (set.add(i.text)){
                rst.add(i);
            }
        }
        return rst;
    }
    static List<Message> processV2(List<Message> received){
        TreeSet<Message> set = new TreeSet<>(received);
        return new ArrayList<Message>(set);
    }
}

class Message implements Comparable<Object>{
    public final int sequence;
    public final String text;
    public Message(int sequence, String text){
        this.sequence = sequence;
        this.text = text;
    }

    @Override
    public int compareTo(Object o){
        Message m = (Message) o;
        if (this.sequence == m.sequence){
            return 0;
        }
        return this.sequence>m.sequence? -1:1;
    }
//    @Override
//	public int compareTo(Object o) {
//		Message m = (Message) o;
//		if (this.sequence==m.sequence) {
//			return 0;
//		}
//		return this.sequence>m.sequence? 1: -1;
//	}

}
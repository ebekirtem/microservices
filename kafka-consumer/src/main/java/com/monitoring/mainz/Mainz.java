package com.monitoring.mainz;

import com.monitoring.tutuorial.hmap.ProtectedClass;

import java.util.*;

public class Mainz {
    public static void main(String[] args) {

        System.out.println(reverse("Ebubekir"));

    String s="What";
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String sKey=new String(charArray);
        Map<String, List<String>> map=new HashMap<>();
        map.computeIfAbsent(sKey,v->new ArrayList<String>()).add(s);


        Map<String, Integer> myMap=new HashMap<>();

        myMap.put("eb",1);

        myMap.computeIfPresent("eb",(s1, integer) -> integer+6);

        System.out.println(myMap);

   MyThread m=new MyThread();
   m.start();

   Runnable task=new Runnable() {
       @Override
       public void run() {
           System.out.println("Task");
       }
   };

     Thread t=new Thread(task);
     t.start();



    }

    public static  String reverse(String s){

        int length = s.length();

        StringBuilder reverse=new StringBuilder();
        for (int i = length-1; i >=0 ; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
//        int i=0;
//
//        while(i<length){
//            char c = s.charAt(i);
//            char c1 = s.charAt(length - i);
//        }

    }
}

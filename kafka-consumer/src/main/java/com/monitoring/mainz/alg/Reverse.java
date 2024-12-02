package com.monitoring.mainz.alg;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(""));
    }

    public static String reverse(String s){
        //abc
        if(s==null || s.length()<=1){
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}


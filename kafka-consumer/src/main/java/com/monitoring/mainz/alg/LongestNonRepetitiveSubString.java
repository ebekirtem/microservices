package com.monitoring.mainz.alg;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepetitiveSubString {

    public static void main(String[] args) {
        String str="abcdeghafaef";
        System.out.println(longNonRepetitiveSubStrLength(str));
        System.out.println(longNonRepetitiveSubStr(str));
    }

    static int longNonRepetitiveSubStrLength(String str){

        Set<Character> set=new HashSet<>();
        int maxLength=0, left=0;

        for (int right = 0; right <str.length() ; right++) {
            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));



            maxLength= Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }



    static String longNonRepetitiveSubStr(String str){

        Set<Character> set=new HashSet<>();
        int maxLength=0, left=0,start=0;

        for (int right = 0; right <str.length() ; right++) {
            while(set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
            }

            set.add(str.charAt(right));

            if(right-left+1>maxLength){
                start=left;
                maxLength=right-left+1;
            }


        }
        return str.substring(start,start+maxLength);
    }
}

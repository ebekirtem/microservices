package com.monitoring.mainz.alg;

 public class Fibonacci {

    public static void main(String[] args) {
        int fibon = fibon2(7);
        System.out.println(fibon);
    }

    public static int fibon(int n){
        //0 1 1 2 3 5 8 13 21 ...
//        0->0
//        1->1
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        return fibon(n-1)+fibon(n-2);
    }

    protected static int fibon2(int n){
        //0 1 1 2 3 5 8 13 21 ...
//        0->0
//        1->1
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        int [] arr=new int[n+1];

        arr[0]=0;
        arr[1]=1;

        for (int i = 2; i <= n; i++) {
            arr[i]=arr[i-1]+arr[i-2];

        }
        return arr[n];
    }
}



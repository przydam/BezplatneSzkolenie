package com.company;

public class Exercise6 {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 1001; i++) {


            if (i % 6 == 0) {
                sum += i;
            }


        }
        System.out.println(sum);
    }

}

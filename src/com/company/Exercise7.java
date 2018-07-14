package com.company;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {

        System.out.println("Please enter number of numbers : ");
        Scanner scanner = new Scanner(System.in);
        int numberOfNumbers = scanner.nextInt();
        int highestNumber = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            System.out.println("Please enter " + (i + 1) + " number 1 :");

            int number = scanner.nextInt();
            if(number> highestNumber){
                highestNumber = number;
            }

        }
        System.out.println("The highest number : " + highestNumber);

    }
}

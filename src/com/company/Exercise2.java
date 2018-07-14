package com.company;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            System.out.println("Enter first number: ");
            int number1 = scanner.nextInt();

            System.out.println("Enter second number: ");
            int number2 = scanner.nextInt();

            int suma = number1 + number2;
            System.out.println("Suma = "+ suma);
        }
    }


}

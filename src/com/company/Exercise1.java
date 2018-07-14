package com.company;


import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println("Exercise1");

        int liczba1 = 10;
        int liczba2 = 20;
        int liczba3 = 5;
        int suma1 = liczba1 + liczba2 + liczba3;

        System.out.println("suma1 = " + suma1);

        int suma2 = liczba1 + liczba2 - liczba3;

        System.out.println("suma2 = " + suma2);

        int suma3 = liczba1 + liczba2 * liczba3;

        System.out.println("suma3 = " + suma3);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int number1 = scanner.nextInt();



        System.out.println("Enter second number: ");
        int number2 = scanner.nextInt();
        int suma4 = number1 + number2;
        System.out.println("Suma = "+ suma4);





    }


}

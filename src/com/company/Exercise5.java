package com.company;

import java.util.Scanner;

public class Exercise5 {


    public static void main(String[] args) {
        /*
        System.out.println("Please enter a number ! ");
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        // && - operator i
        // || - operator lub
        if(number%11==0 && number>100){
            System.out.println("Number is divided by 11 and is greater than 100");
        } else if(number%11 ==0){
            System.out.println("Number is divided by 11 and is less than 100");
        } else if(number>100){
            System.out.println("Number is not divided by 11 and is greater than 100");
        } else{
            System.out.println("Number is not divided by 11 and is less than 100");
        }

*/
        System.out.println("Please enter a temperature ! ");
        Scanner scanner = new Scanner(System.in);
        int temperature = scanner.nextInt();

        if(temperature>30){
            System.out.println("Jest bardzo goroąco");
        } else if (temperature<=30 && temperature>15){
            System.out.println("Jest umiarkowanie");
        } else if (temperature<=15 && temperature>=0){
            System.out.println("Jest chłodno");
        } else{
            System.out.println("Jest zimno");
        }




    }



}

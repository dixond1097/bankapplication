package com.myBank;

import java.util.Scanner;

public class inputMenu {
    public static Scanner in = new Scanner(System.in);

    public static void intitalMenu(){
        System.out.println("1: Register Account");
        System.out.println("2: Login");
         int option = in.nextInt();

        switch(option){
            case 1 : 
                prompts.registerMenu();
                break;
            case 2: 
                prompts.login();
                break;
        }
    }
    public static void customerAccount(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("1: Withdraw");
        System.out.println("2: Deposit");
        System.out.println("3: Transfer");
        prompts.displayInfo();
        int option = in.nextInt();

            switch(option){
                case 1:
                    prompts.withdraw();
                    break;
                case 2:
                    prompts.deposit();
                    break;
                case 3:
                    prompts.transfer();
                    break;
            }
    }
     
    public static void employee(){

    }
}

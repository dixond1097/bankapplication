package com.myBank;

import java.util.Scanner;

public class prompts {
    static Scanner in = new Scanner(System.in);
    public static bankSystem bs = new bankSystem();

    public static void intitalMenu(){
        System.out.println("Select a option");
        System.out.println("1. Register");
    }
    public static void registerMenu(){
        System.out.println(bs.accountList.get(0).amount);
        System.out.println("Please enter your username");
        String username = in.nextLine();
        System.out.println("Please enter your email address");
        String email = in.nextLine();
        System.out.println("Please enter your password");
        String password = in.nextLine();
        System.out.println("Please enter the unique accountName");
        String accountName = in.nextLine();
        System.out.println("Please enter the starting amount");
        int amount = in.nextInt();
        bankSystem.registerAccount(username, password,accountName);
        inputMenu.intitalMenu();
    }
    public static void login() {
        System.out.println("Enter Account Name");
        String accountName = in.nextLine();
        if(!bs.getAccount(accountName).equals(null)){
            System.out.println(bs.getAccount(accountName));
            System.out.println("Please enter username");
            String password = in.nextLine();
            System.out.println("Please enter password");
            String username = in.nextLine();
            bankSystem.loginAccount(password, username, accountName);
            inputMenu.customerAccount();
        }

    }
    public static void withdraw(){
        System.out.println("Please enter the amount used like to withdraw");
        int amount = in.nextInt();
        bankSystem.withdraw(amount);
        inputMenu.customerAccount();
    }
    public static void deposit(){
        System.out.println("Please enter the amount used like to deposit");
        int amount = in.nextInt();
        bankSystem.deposit(amount);
        inputMenu.customerAccount();

    }
    public static void transfer(){
        System.out.println("Please enter the unique account name to transfer to");
        String accountName = in.nextLine();
        System.out.println("Please enter the amount");
        int amount = in.nextInt();
        bankSystem.transfer(amount,accountName);
        inputMenu.customerAccount();


    }
    public static void displayInfo(){
        System.out.println("Current Amount: " + bs.currentAccount.amount);
        System.out.println("Account Name: " + bs.currentAccount.accountName);
    }
}

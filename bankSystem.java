package com.myBank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.myBank.*;
public class bankSystem {
    public static ArrayList<Account> accountList;
    public static User currentUser = null;
    public static Account currentAccount = null;
    static Scanner in = new Scanner(System.in);
    public final static String PATH= "C:\\Users\\ddixo\\eclipse-workspace\\BankingProject\\src\\com\\myBank\\";
    public bankSystem(){
        this.accountList = new ArrayList<Account>();
        try{
            FileInputStream readData = new FileInputStream(PATH + "accountsdata.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);

            @SuppressWarnings("unchecked")
            ArrayList<Account> accountsData = (ArrayList<Account>) readStream.readObject();
            readStream.close();
            System.out.println("Loading accounts...\n");
            this.accountList = accountsData;
            System.out.println(accountList);
        }catch(Exception e){e.printStackTrace();}
    }
    public static void saveFile(){
        try {
            FileOutputStream fout=new FileOutputStream(PATH +"accountsdata.ser");//saving state of an object
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(accountList);
            out.flush();
            out.close();
            System.out.println("Success");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void registerAccount(String username, String password,String accountName){
//        User user = new User(name,username, password);
        Account account = new Account(username,password,accountName);
        account.amount = 40;
        Account account2 = new Account("bob","123","notMine");
        accountList.add(account);
        saveFile();


		

    }   

    public static void approveAccount(String accountName){
        
    }
    public static Account getAccount(String accountName){
        for(int i=0; i<accountList.size(); i++){
            if(accountList.get(i).accountName.compareTo(accountName)==0){
                return accountList.get(i);
            }
        }
        return null;
    }
    public static void loginAccount(String username,String password,String accountName){
          
        Account profile = getAccount(accountName);
            System.out.println(profile);
            if(profile.password.equals(password) && profile.user.equals(username)) {
            	currentAccount = profile;
            	System.out.println("Logined successfully");
            }
            else{
                System.out.println("Please try again");
            }
            
    }
    public static void withdraw(int amount){
        Account account  = currentAccount;
        System.out.println(account.password);
        System.out.println(accountList.get(0).accountName);
        currentAccount.amount-=amount;
        // accountList.set(,currentAccount);
        saveFile();

    }
    public static void deposit(int amount){
        Account account  = currentAccount;
        System.out.println(account.password);
        System.out.println(accountList.get(0).accountName);
        currentAccount.amount+=amount;
        // accountList.set(,currentAccount);
        saveFile();
    }
    public static void transfer(double amount,String accountName){
        Account account = getAccount(accountName);
        Account profile = currentAccount;
        profile.amount-=amount;
        account.amount+=amount;
        saveFile();
    }
    public void applyJointAccount(String primary, String secondary, String contactEmail){}
    public void cancelAccount(String accountName){}
    public void editAccount(String accessAccount){
        if(currentAccount.role=="ADMIN"){
            
        }
    }
    public static void main(String[] args){
       
        inputMenu.intitalMenu();
    //     approveAccount("notMine");
    //     loginAccount("don","123","myAccount");
    //     transfer(10,"notMine");
    }

}

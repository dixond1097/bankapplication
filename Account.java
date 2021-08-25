package com.myBank;

import java.io.Serializable;

public class Account implements Serializable {
    public String accountName;
    public String role;
    public String user;
    public String password;
    public double amount;
    public boolean approved;
    Account( String user, String password, String accountName){
        this.role = "Customer";
        this.accountName = accountName;
        this.password = password;
        this.user = user;
        this.approved= false;
    }
    public void login(String username,String password){

    }


    public String toString() {
        return  accountName;
    }
}
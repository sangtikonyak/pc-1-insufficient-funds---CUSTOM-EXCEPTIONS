package com.jap.customexception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {

    private int accountBalance;

    public Account(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    //create getter and setter
   public void setAccountBalance(int accountBalance)
   {
       this.accountBalance=accountBalance;
   }
   public int getAccountBalance()
   {
       return accountBalance;
   }




    /**
     * This method returns the new balance deducting the withdraw amount from the balance
     * Throws InsufficientFundException when amount to withdraw is greater than the balance
     *
     * @param amount
     * @return
     * @throws InsufficientFundException
     *
     */
    public int  withdraw(int  amount) throws InsufficientFundException{

        if(amount>accountBalance)
        {
            throw new InsufficientFundException("Amount is higher than your actual balance");
        }

        return getAccountBalance()-amount;
    }

    public static void main(String[] args) {
        Account account=new Account(10000);
        Scanner sc=new Scanner(System.in);
        System.out.println("enter an amount to Invest");
        int num=sc.nextInt();
        try{
            System.out.println("account.withdraw(num) = " + account.withdraw(num));
        }catch(InsufficientFundException | InputMismatchException e)
        {
            System.out.println(e);
        }
    }

}

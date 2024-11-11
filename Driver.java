/* File: Driver.java
 * Author: Keegan Carter
 * Purpose:
 */

import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

        // Variables for deposit and withdrawal. They're up here so they can be reused
        String name;
        boolean proceed = false;
        int selectedAccount;

        TheArray accountList = new TheArray();

        Account stuChe1 = new Account("C", 1, "Washington");
        Account stuChe2 = new Account("C", 1, "Adams");
        Account stuSav1 = new Account("S", 1, "Jefferson");
        Account facChe1 = new Account("C", 2, "Madison");
        Account facSav1 = new Account("S", 2, "Monroe");
        Account facSav2 = new Account("S", 2, "Jackson");
        Account staChe1 = new Account("C", 3, "Van Buren");
        Account staChe2 = new Account("C", 3, "Harrison");
        Account staChe3 = new Account("C", 3, "Tyler");
        Account facMor1 = new Account("M", 2, 13000, "Y", "Polk");

        accountList.addAccount(stuChe1);
        accountList.addAccount(stuChe2);
        accountList.addAccount(stuSav1);
        accountList.addAccount(facChe1);
        accountList.addAccount(facSav1);
        accountList.addAccount(facSav2);
        accountList.addAccount(staChe1);
        accountList.addAccount(staChe2);
        accountList.addAccount(staChe3);
        accountList.addAccount(facMor1);



        boolean go = true;

        while (go){
            System.out.println(
                    "Menu: " +
                            "\n Display all accounts (1) " +
                            "\n Deposit to an account (2) " +
                            "\n Withdrawal from an account (3) " +
                            "\n Add interest to all accounts (4)" +
                            "\n Total number of accounts (5)" +
                            "\n Exit (6)" +
                            "\n Enter selection here: "
            );
            Scanner cin = new Scanner(System.in);
            int selection = cin.nextInt();
            cin.nextLine();
            switch (selection){
                case 1:
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        System.out.println("Name: " + accountList.getAccount(i).getFirstName() + " "+ accountList.getAccount(i).getLastName());
                        System.out.println("Balance: $" + accountList.getAccount(i).getBalance());
                        System.out.println("Account Type (C=Checking S=Savings): " + accountList.getAccount(i).getAccountType());
                        System.out.println("Account Number: " + accountList.getAccount(i).getAccountNum() + "\n");
                    }
                    break;
                case 2:
                    // require input of account holder's last name
                    // that account.deposit
                    System.out.println("Input last name: ");
                    name = cin.nextLine();
                    proceed = false;
                    selectedAccount = 0;
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        if(name.equals(accountList.getAccount(i).getLastName())){
                            proceed = true;
                            selectedAccount = i;
                        }
                    }
                    if(proceed){
                        System.out.println("Input deposit amount: ");
                        double amt = cin.nextDouble();
                        accountList.getAccount(selectedAccount).deposit(amt);
                        System.out.println("Balance: " + accountList.getAccount(selectedAccount).getBalance());
                    }
                    else{
                        System.out.println("We don't have an account in that name");
                    }
                    break;
                case 3:
                    // require input of account holder's last name
                    // that account.withdrawal
                    // needs a method to notify user if their balance is insufficient
                    // ' "Sorry, your balance is less " + balance. '
                    System.out.println("Input last name: ");
                    name = cin.nextLine();
                    proceed = false;
                    selectedAccount = 0;
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        String lastName = accountList.getAccount(i).getLastName();
                        if(name.equals(lastName)){
                            proceed = true;
                            selectedAccount = i;
                        }
                    }
                    if(proceed){
                        System.out.println("Input withdrawal amount: ");
                        double amt = cin.nextDouble();
                        if (accountList.getAccount(selectedAccount).getBalance() > amt) {
                            accountList.getAccount(selectedAccount).withdrawal(amt);
                            System.out.println("Balance: " + accountList.getAccount(selectedAccount).getBalance());
                        }
                        else{
                            System.out.printf("Sorry, you don't have enough funds. Balance is: %f \n", accountList.getAccount(selectedAccount).getBalance());
                        }
                    }
                    else{
                        System.out.println("We don't have an account in that name");
                    }
                    break;
                case 4:
                    // all accounts.addInterest
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        accountList.getAccount(i).addInterest(0.05);
                    }
                    System.out.println("Interest added to all accounts");
                    break;
                case 5:
                    // print total number of accounts
                    // number of savings accounts
                    // number of checking accounts
                    // number of student accounts
                    // number of employee accounts
                    int numSavings = 0;
                    int numChecking = 0;
                    int numStudent = 0;
                    int numEmployee = 0;
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        String type = accountList.getAccount(i).getAccountType();
                        int person = accountList.getAccount(i).getPerson();
                        if(type.equals("S")){
                            numSavings ++;
                        }
                        else if(type.equals("C")){
                            numChecking ++;
                        }
                        if (person == 1){
                            numStudent ++;
                        }
                        else if (person == 2 || person == 3){
                            numEmployee ++;
                        }
                    }
                    System.out.printf("Savings: %d, Checking: %d, Student: %d, Employee: %d \n", numChecking, numSavings, numStudent, numEmployee);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}

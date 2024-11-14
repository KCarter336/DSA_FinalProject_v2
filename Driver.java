/* File: Driver.java
 * Author: Keegan Carter
 * Purpose:
 */

import java.util.Objects;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

        // Variables for deposit and withdrawal. They're up here so they can be reused
        String name;
        boolean proceed = false;
        int selectedAccount;

        TheArray accountList = new TheArray();

        Account stuChe1 = new Account("C", 1, "George", "Washington");
        Account stuChe2 = new Account("C", 1, "John", "Adams");
        Account stuSav1 = new Account("S", 1, "Thomas", "Jefferson");
        Account facChe1 = new Account("C", 2, "James", "Madison");
        Account facSav1 = new Account("S", 2, "James", "Monroe");
        Account facSav2 = new Account("S", 2, "Andrew", "Jackson");
        Account staChe1 = new Account("C", 3, "Martin", "Van Buren");
        Account staChe2 = new Account("C", 3, "William", "Harrison");
        Account staChe3 = new Account("C", 3, "John", "Tyler");
        Account facMor1 = new Account("M", 2, "James", "Polk");

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
                            "\n Total number of accounts (2) " +
                            "\n Open an account (3) " +
                            "\n Open a mortgage account (4)" +
                            "\n Total number of accounts (5)" +
                            "\n Display students accounts with balance under $100 (6)" +
                            "\n Display employee accounts with balance over $5000 (7)" +
                            "\n Individual account actions (8)" +
                            "\n Display all saving accounts (9)" +
                            "\n Exit  (10)" +
                            "\n Enter selection here: "
            );
            Scanner cin = new Scanner(System.in);
            int selection = cin.nextInt();
            cin.nextLine();
            switch (selection){
                case 1:
                    for(int i = 1; i <= accountList.getNumElements(); i++) {
                        System.out.println("Name: " + accountList.getAccount(i).getFirstName() + " "+ accountList.getAccount(i).getLastName());
                        System.out.println("Balance: $" + accountList.getAccount(i).getBalance());
                        System.out.println("Account Type (C=Checking S=Savings M=Mortgage): " + accountList.getAccount(i).getAccountType());
                        System.out.println("Account Number: " + accountList.getAccount(i).getAccountNum() + "\n");
                    }
                    break;
                case 2:
                    // counting how many of each account type
                    int numSavings = 0;
                    int numChecking = 0;
                    int numMortgage = 0;
                    int numStudent = 0;
                    int numEmployee = 0;
                    for(int i = 1; i <= accountList.getNumElements(); i++) {
                        String type = accountList.getAccount(i).getAccountType();
                        int person = accountList.getAccount(i).getPerson();
                        if(type.equals("S")){
                            numSavings ++;
                        }
                        else if(type.equals("C")){
                            numChecking ++;
                        }
                        else if(type.equals("M")){
                            numMortgage ++;
                        }
                        if (person == 1){
                            numStudent ++;
                        }
                        else if (person == 2 || person == 3){
                            numEmployee ++;
                        }
                    }
                    // opening submenu to choose which type of account to learn about
                    System.out.println(
                            "   Submenu: " +
                                    "\n     Total number of accounts (1) " +
                                    "\n     Number of savings accounts (2) " +
                                    "\n     Number of checking accounts (3) " +
                                    "\n     Number of mortgage accounts (4)" +
                                    "\n     Number of student accounts (5)" +
                                    "\n     Number of employee accounts (6)" +
                                    "\n     Back to main menu (7)" +
                                    "\n     Enter selection here: "
                    );
                    // making the selection and determining what to do with it
                    int submenuSelection = cin.nextInt();
                    switch (submenuSelection){
                        case 1:
                            System.out.println(numEmployee + numStudent);
                            break;
                        case 2:
                            System.out.println(numSavings);
                            break;
                        case 3:
                            System.out.println(numChecking);
                            break;
                        case 4:
                            System.out.println(numMortgage);
                            break;
                        case 5:
                            System.out.println(numStudent);
                            break;
                        case 6:
                            System.out.println(numEmployee);
                            break;
                        case 7:
                            break;
                    }
                    break;
                case 3:
                    double years = 0;
                    double down;
                    System.out.println("Please enter a first name: ");
                    String first = cin.nextLine();
                    System.out.println("Please enter a last name: ");
                    String last = cin.nextLine();
                    System.out.println("Student (1), staff (2), or faculty(3)?");
                    int person = cin.nextInt();
                    cin.nextLine();
                    System.out.println("Please enter an account type (C, S, M): ");
                    String type = cin.nextLine();
                    System.out.println("Please enter an initial balance: ");
                    double balance = cin.nextDouble();
                    cin.nextLine();
                    if(type.equals("M")){
                        System.out.println("Please enter down payment: ");
                        down = cin.nextDouble();
                        System.out.println("Please enter a time scale (years): ");
                        years = cin.nextDouble();
                        balance -= down;
                        double monthlyPayment = balance / (years * 12);
                        System.out.printf("Monthly payment is: $%f \n", monthlyPayment);
                    }
                    Account added1 = new Account(type, person, first, last, balance);
                    accountList.addAccount(added1);
                    break;
                case 4:
                    // Jayden's
                    // open a mortgage account with some down payment
                case 5:
                    // all accounts.addInterest
                    for(int i = 1; i <= accountList.getNumElements(); i++) {
                        if(!Objects.equals(accountList.getAccount(i).getAccountType(), "M")){
                            accountList.getAccount(i).addInterest(0.05);
                        }
                    }
                    System.out.println("Interest added to all accounts");
                    break;
                case 6:
                    for(int i = 0; i < accountList.length; i++) {
                        int person = accountList[i].getPerson();
                        if (person == 1) {
                            if(accountList[i].getBalance() < 100) {
                                System.out.println("Name: " + accountList[i].getFirstName() + " " + accountList[i].getLastName());
                                System.out.println("Balance: $" + accountList[i].getBalance());
                                System.out.println("Account Type (C=Checking S=Savings): " + accountList[i].getAccountType());
                                System.out.println("*Below minimum balance fee added*");
                                accountList[i].withdrawal(5.0);
                            }
                        }
                    }
                    break;
                case 7:
                    for(int i = 0; i < accountList.length; i++) {
                        int person = accountList[i].getPerson();
                        if (person == 2) {
                            if(accountList[i].getBalance() > 5000) {
                                System.out.println("Name: " + accountList[i].getFirstName() + " " + accountList[i].getLastName());
                                System.out.println("Balance: $" + accountList[i].getBalance());
                                System.out.println("Account Type (C=Checking S=Savings): " + accountList[i].getAccountType());
                            }
                        }
                    }
                    break;
                case 8:
                    // linear search for account by last name
                    // open submenu for deposit / withdrawal stuff
                    System.out.println("Enter last name: ");
                    name = cin.nextLine();
                    proceed = false;
                    selectedAccount = 0;
                    for(int i = 1; i <= accountList.getNumElements(); i++) {
                        String lastName = accountList.getAccount(i).getLastName();
                        if(name.equals(lastName)){
                            proceed = true;
                            selectedAccount = i;
                        }
                    }
                    if(proceed){
                        System.out.println(
                                "   Submenu: " +
                                        "\n     Check balance (1) " +
                                        "\n     Make withdrawal (2) " +
                                        "\n     Make deposit (3) " +
                                        "\n     Add interest (4)" +
                                        "\n     Delete the account (5)" +
                                        "\n     Pay mortgage and delete the account (6)" +
                                        "\n     Back to main menu (7)" +
                                        "\n     Enter selection here: "
                        );
                        int submenuChoice = cin.nextInt();
                        switch (submenuChoice){
                            case 1:
                                // checking balance
                                System.out.println(accountList.getAccount(selectedAccount).getBalance());
                                break;
                            case 2:
                                // withdrawal
                                System.out.println("Input withdrawal amount: ");
                                double amt = cin.nextDouble();
                                if (accountList.getAccount(selectedAccount).getBalance() > amt) {
                                    accountList.getAccount(selectedAccount).withdrawal(amt);
                                    System.out.println("Balance: " + accountList.getAccount(selectedAccount).getBalance());
                                }
                                else{
                                    System.out.printf("Sorry, you don't have enough funds. Balance is: %f \n", accountList.getAccount(selectedAccount).getBalance());
                                }
                                break;
                            case 3:
                                // deposit
                                System.out.println("Input deposit amount: ");
                                double amount = cin.nextDouble();
                                accountList.getAccount(selectedAccount).deposit(amount);
                                System.out.println("Balance: " + accountList.getAccount(selectedAccount).getBalance());
                                break;
                            case 4:
                                // add interest
                                accountList.getAccount(selectedAccount).addInterest(0.05);
                                break;
                            case 5:
                                accountList.removeAccount(name);
                                break;
                            case 6:
                                // pay mortgage and delete account
                                if(accountList.getAccount(selectedAccount).getAccountType().equals("M")){
                                    accountList.getAccount(selectedAccount).setBalance(0);
                                    accountList.removeAccount(name);
                                    System.out.println("Mortgage paid and account closed");
                                }
                                else{
                                    System.out.println("This is not a mortgage account. This operation is not applicable");
                                }
                                break;
                            case 7:
                                // exit to main menu
                                break;

                        }
                    }
                    else{
                        System.out.println("We don't have an account in that name");
                    }
                    break;
                case 9:
                    // Jayden's
                    break;
                case 10:
                    System.exit(0);
            }
        }
    }
}

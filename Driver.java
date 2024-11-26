/* File: Driver.java
 * Author: Keegan Carter
 * Purpose:
 */

import java.util.Objects;
import java.util.Scanner;
public class Driver {

    public static void main(String[] args) {

        // Variables for deposit and withdrawal. They're up here so they can be reused
        String name;
        boolean proceed = false;
        int selectedAccount;

        TheArray accountList = new TheArray();

        Account stuChe1 = new Account("C", 1, "George", "Washington", 1);
        Account stuChe2 = new Account("C", 1, "John", "Adams", 59);
        Account stuSav1 = new Account("S", 1, "Thomas", "Jefferson", 125);
        Account facChe1 = new Account("C", 2, "James", "Madison", 250);
        Account facSav1 = new Account("S", 2, "James", "Monroe", 5678);
        Account facSav2 = new Account("S", 2, "Andrew", "Jackson", 20);
        Account staChe1 = new Account("C", 3, "Martin", "Van Buren", 4999);
        Account staChe2 = new Account("C", 3, "William", "Harrison", 5001);
        Account staChe3 = new Account("C", 3, "John", "Tyler", 750);
        Account facMor1 = new Account("M", 2, "James", "Polk", 6000);


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

        while (go) {
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
            switch (selection) {
                case 1:
                    for (int i = 1; i <= accountList.getNumElements(); i++) {
                        System.out.println("Name: " + accountList.getAccount(i).getFirstName() + " " + accountList.getAccount(i).getLastName());
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
                    for (int i = 1; i <= accountList.getNumElements(); i++) {
                        String type = accountList.getAccount(i).getAccountType();
                        int person = accountList.getAccount(i).getPerson();
                        if (type.equals("S")) {
                            numSavings++;
                        } else if (type.equals("C")) {
                            numChecking++;
                        } else if (type.equals("M")) {
                            numMortgage++;
                        }
                        if (person == 1) {
                            numStudent++;
                        } else if (person == 2 || person == 3) {
                            numEmployee++;
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
                    switch (submenuSelection) {
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
                    if (type.equals("M")) {
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
                    double numOfYears;
                    double downPayment;
                    System.out.println("Please enter a first name: ");
                    String firstName = cin.nextLine();
                    System.out.println("Please enter a last name: ");
                    String lastName = cin.nextLine();
                    System.out.println("Student (1), staff (2), or faculty(3)?");
                    int personType = cin.nextInt();
                    System.out.println("Please enter an initial balance: ");
                    double mortgageBalance = cin.nextDouble();
                    System.out.println("Please enter down payment: ");
                    down = cin.nextDouble();
                    System.out.println("Please enter a time scale (years): ");
                    years = cin.nextDouble();
                    mortgageBalance -= down;
                    double monthlyPayment = mortgageBalance / (years * 12);
                    System.out.printf("Monthly payment is: $%f \n", monthlyPayment);
                    Account added2 = new Account(personType, firstName, lastName, mortgageBalance);
                    accountList.addAccount(added2);
                    break;
                case 5:
                    // all accounts.addInterest
                    for (int i = 1; i <= accountList.getNumElements(); i++) {
                        if (!Objects.equals(accountList.getAccount(i).getAccountType(), "M")) {
                            accountList.getAccount(i).addInterest(0.05);
                        }
                    }
                    System.out.println("Interest added to all accounts");
                    break;
                case 6:
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        if (accountList.getAccount(i) != null) {
                            if (accountList.getAccount(i).getPerson() == 1) {
                                if(accountList.getAccount(i).getBalance() < 100) {
                                    System.out.println("Name: " + accountList.getAccount(i).getFirstName() + " " + accountList.getAccount(i).getLastName());
                                    System.out.println("Balance: $" + accountList.getAccount(i).getBalance());
                                    System.out.println("Account Type (C=Checking S=Savings): " + accountList.getAccount(i).getAccountType());
                                    System.out.println("*Below minimum balance fee added*\n");
                                    accountList.getAccount(i).withdrawal(5.0);
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        if (accountList.getAccount(i) != null) {
                            if (accountList.getAccount(i).getPerson() == 2 || accountList.getAccount(i).getPerson() == 3) {
                                if(accountList.getAccount(i).getBalance() > 5000) {
                                    System.out.println("Name: " + accountList.getAccount(i).getFirstName() + " " + accountList.getAccount(i).getLastName());
                                    System.out.println("Balance: $" + accountList.getAccount(i).getBalance());
                                    System.out.println("Account Type (C=Checking S=Savings): " + accountList.getAccount(i).getAccountType() + "\n");
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    // linear search for account by last name
                    // open submenu for deposit / withdrawal stuff
                    long timeBegin = System.nanoTime();
                    System.out.println("Enter last name: ");
                    name = cin.nextLine();
                    proceed = false;
                    selectedAccount = 0;

                    for(int i = 1; i <= accountList.getNumElements(); i++) {
                        lastName = accountList.getAccount(i).getLastName();
                        if(name.equals(lastName)){

                            proceed = true;
                            selectedAccount = i;
                        }
                    }
                    long timeEnd = System.nanoTime();
                    long timeElapsed = (timeEnd - timeBegin);
                    System.out.printf("Search time in nanoseconds: %d \n", timeElapsed);
                    if (proceed) {
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
                        switch (submenuChoice) {
                            case 1:
                                // checking balance
                                System.out.println(accountList.getAccount(selectedAccount).getBalance());
                                break;
                            case 2:
                                // withdrawal
                                System.out.println("Input withdrawal amount: ");
                                double enteredAmt = cin.nextDouble();
                                double amt = enteredAmt + 1;    // $1 withdrawal fee applied
                                if (accountList.getAccount(selectedAccount).getBalance() > amt) {
                                    accountList.getAccount(selectedAccount).withdrawal(amt);
                                    System.out.println("Balance: " + accountList.getAccount(selectedAccount).getBalance());
                                } else {
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
                                if (accountList.getAccount(selectedAccount).getAccountType().equals("M")) {
                                    accountList.getAccount(selectedAccount).setBalance(0);
                                    accountList.removeAccount(name);
                                    System.out.println("Mortgage paid and account closed");
                                } else {
                                    System.out.println("This is not a mortgage account. This operation is not applicable");
                                }
                                break;
                            case 7:
                                // exit to main menu
                                break;

                        }
                    } else {
                        System.out.println("We don't have an account in that name");
                    }
                    break;
                case 9:
                    int count = 0;
                    for(int i = 1; i < accountList.getNumElements(); i++) {
                        type = accountList.getAccount(i).getAccountType();
                        if(type.equals("S")) {
                            count += 1;
                        }
                    }
                    String[] firstNames = new String[count];
                    count = 0;
                    for(int i = 1; i < accountList.getCurrentSize(); i++) {
                        type = accountList.getAccount(i).getAccountType();
                        if(type.equals("S")) {
                            firstNames[count] = accountList.getAccount(i).getFirstName();
                            count += 1;
                        }
                    }
                    long start = System.nanoTime();
                    bubbleSort(firstNames);
                    long stop = System.nanoTime();
                    for(String target : firstNames) {
                        for(int i = 1; i < accountList.getCurrentSize(); i++) {
                            if(accountList.getAccount(i).getFirstName().equals(target)){
                                System.out.println("Name: " + accountList.getAccount(i).getFirstName() + " " + accountList.getAccount(i).getLastName());
                                System.out.println("Balance: $" + accountList.getAccount(i).getBalance() + "\n");
                            }
                        }
                        System.out.printf("Time taken to sort accounts: %d Nano seconds\n", stop - start);
                    }
                    break;
                case 10:
                    // Main menu 10, selection sort all accounts by account num, keep track of how long it takes,
                    // display sorted accounts and timing info
                    long begin10 = System.nanoTime();
                    SearchSortAlgorithms.selectionSort(accountList);
                    System.out.println("Accounts sorted by account number: ");
                    for (int i = 0; i < accountList.getNumElements(); i++) {
                        if (accountList.getAccount(i) != null) {
                            System.out.println(accountList.getAccount(i).getLastName());
                            System.out.println(accountList.getAccount(i).getAccountNum());
                        } else {
                            System.out.println("-----------Null");
                        }
                    }
                    long end10 = System.nanoTime();
                    long elapsed10 = end10 - begin10;
                    System.out.printf("Sort time in nanoseconds: %d \n", elapsed10);
                    break;
                case 11:
                    // Main menu 11, binary search an account by last name
                    // (you should use insertion sort to sort on last name before doing the binary search),
                    // display complete information about the account and print the time taken to do the binary search.
                    // After binary search is complete present the submenu for that account
                    //Submenu:
                    //1. Check balance
                    //2. Withdraw money
                    //3. Deposit money
                    //4. Change last name
                    //5. Change account type (ex. From saving to checking)
                    //6. Close (Delete) the account
                    //7. Pay Mortgage and close (Delete) the account
                    //8. Back to main menu
                    // selection sort
                    SearchSortAlgorithms.insertionSort(accountList);

                    // taking input of name
                    System.out.println("Input lastname: ");
                    String nameSearched = cin.nextLine();

                    // binary search and timing
                    long timeBegin11 = System.nanoTime();
                    int indexOfNameSearched = SearchSortAlgorithms.binarySearch(accountList, nameSearched);
                    long timeEnd11 = System.nanoTime();
                    long timeElapsed11 = (timeEnd11 - timeBegin11);
                    System.out.printf("Search time in nanoseconds: %d \n", timeElapsed11);

                    selectedAccount = indexOfNameSearched;
                    name = nameSearched;

                    // displaying account info
                    System.out.println("Name: " + accountList.getAccount(indexOfNameSearched).getFirstName() + " " + accountList.getAccount(indexOfNameSearched).getLastName());
                    System.out.println("Balance: $" + accountList.getAccount(indexOfNameSearched).getBalance());
                    System.out.println("Account Type (C=Checking S=Savings M=Mortgage): " + accountList.getAccount(indexOfNameSearched).getAccountType());
                    System.out.println("Account Number: " + accountList.getAccount(indexOfNameSearched).getAccountNum() + "\n");
                    // submenu
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
                    switch (submenuChoice) {
                        case 1:
                            // checking balance
                            System.out.println(accountList.getAccount(selectedAccount).getBalance());
                            break;
                        case 2:
                            // withdrawal
                            System.out.println("Input withdrawal amount: ");
                            double enteredAmt = cin.nextDouble();
                            double amt = enteredAmt + 1;    // $1 withdrawal fee applied
                            if (accountList.getAccount(selectedAccount).getBalance() > amt) {
                                accountList.getAccount(selectedAccount).withdrawal(amt);
                                System.out.println("Balance: " + accountList.getAccount(selectedAccount).getBalance());
                            } else {
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
                            if (accountList.getAccount(selectedAccount).getAccountType().equals("M")) {
                                accountList.getAccount(selectedAccount).setBalance(0);
                                accountList.removeAccount(name);
                                System.out.println("Mortgage paid and account closed");
                            } else {
                                System.out.println("This is not a mortgage account. This operation is not applicable");
                            }
                            break;
                        case 7:
                            // exit to main menu
                            break;
                    }
                    break;
                case 12:
                    System.exit(0);
            }

        }
    }

    public static void bubbleSort(String[] list) {
        for (int i = 1; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    String temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }
}
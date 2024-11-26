/* File: Account.java
 * Author: Keegan Carter
 * Purpose:
 */

import java.util.Random;

public class Account {

    private String lastName;
    private String firstName;
    private String sex;
    private int DOB;
    private int SSN;
    private int accountNum;
    private String accountType;
    private int person;
    private double balance;
    private double costOfHouse;
    private int nameAsNum;

    // Random account constructor
    public Account(String accountType, int person, String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.person = person;
        this.accountNum = this.randAccountNum();
        this.SSN = this.randSSN();
        this.nameAsNum = SearchSortAlgorithms.nameToNum(lastName);
    }
    // Specified account constructor
    public Account(String accountType, int person, String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.person = person;
        this.accountNum = this.randAccountNum();
        this.SSN = this.randSSN();
        this.balance = balance;
        this.nameAsNum = SearchSortAlgorithms.nameToNum(lastName);
    }

     // Mortgage account constructor
    public Account(int person, String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.person = person;
        this.balance = balance;
        this.nameAsNum = SearchSortAlgorithms.nameToNum(lastName);
    }

     // Mortgage account constructor
    public Account(int person, String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.person = person;
        this.balance = balance;
    }

    // Loan account constructor
    // commented out because it errors against the specified account constructor. I figured we could keep track of the difference
    // by assigning loan accounts account type "M" for mortgage, and dealing with them differently on that basis

//    public Account(String accountType, int person, String firstName, String lastName, double costOfHouse) {
//        this.accountType = accountType;
//        this.person = person;
//        this.costOfHouse = costOfHouse;
//    }

    // Random number generators for random constructor
    private int randSSN() {
        Random Generator = new Random();
        SSN = Generator.nextInt(100000000, 999999999);
        return SSN;
    }
    private int randAccountNum() {
        Random Generator = new Random();
        accountNum = Generator.nextInt(100000000, 999999999);
        return accountNum;
    }
    // Basic getter methods
    public int getAccountNum(){
        return this.accountNum;
    }
    public String getAccountType(){
        return this.accountType;
    }
    public int getPerson(){
        return this.person;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public double getBalance(){
        return this.balance;
    }
    public int getNameAsNum(){
        return this.nameAsNum;
    }

    // Basic setter methods
    public void deposit(double amt){
        this.balance += amt;
    }
    public void withdrawal(double amt){
        this.balance -= amt;
    }
    public void addInterest(double rate){
        if(!this.accountType.equals("M")){
            this.balance *= (1 + rate);
        }
    }
    // basic setter methods
    public void setBalance(double amt){
        this.balance = amt;
    }

    // Mortgage methods
    public double mortgage(double costOfHouse) {
        double mortgage = (costOfHouse - mortgageDownPayment(costOfHouse)) * 1.06;
        return mortgage;
    }
    public double mortgageDownPayment(double costOfHouse){
        double downPayment = costOfHouse * 0.2;
        return downPayment;
    }
    public double monthlyPayment(double mortgage){
        double monthlyPayment = mortgage / (20 * 12);
        return monthlyPayment;
    }

}

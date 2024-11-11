/* File: TheArray.java
 * Author: Keegan Carter
 * Purpose:
 */

public class TheArray {

    private Account[] accountList;
    private int numElements;


    public TheArray(){
        this.accountList = new Account[11];
    }
    public void countElements(){
        numElements = 0;
        for(int i = 0; i < accountList.length; i ++){
            if(accountList[i] != null){
                numElements ++;
            }
        }
    }
    public void increaseSize(){
        Account[] increaseList = new Account[accountList.length * 2];
        for(int i = 0; i < accountList.length; i ++){
            increaseList[i] = accountList[i];
        }
        accountList = increaseList;
    }
    public void addAccount(Account account){
        this.countElements();
        if(numElements < accountList.length -1 ){
            accountList[numElements + 1] = account;
        }
        else{
            this.increaseSize();
            accountList[numElements + 1] = account;
        }
    }
    // getters
    public int getCurrentSize(){
        return accountList.length;
    }
    public Account getAccount(int index){
        return accountList[index];
    }
}

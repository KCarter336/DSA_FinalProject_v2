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
        Account[] increaseList = new Account[accountList.length + 1];
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
    public void removeAccount(String accountLastName){
        boolean proceed = false;
        int selectedAccount = 0;
        for(int i = 1; i <= this.getNumElements(); i++) {
            String lastName = this.getAccount(i).getLastName();
            if(accountLastName.equals(lastName)){
                proceed = true;
                selectedAccount = i;
            }
        }
        if (proceed){
            for(int i = selectedAccount; i <= this.getNumElements() - 1; i++){
                this.accountList[i] = this.accountList[i + 1];
            }
            numElements --;
        }
    }
    // getters
    public int getCurrentSize(){
        return accountList.length;
    }
    public Account getAccount(int index){
        return accountList[index];
    }
    public int getNumElements(){
        this.countElements();
        return numElements;
    }
}

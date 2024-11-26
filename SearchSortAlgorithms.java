/* File: SearchSortAlgorithms.java
 * Author: Keegan Carter
 * Purpose:
 */

public class SearchSortAlgorithms {

    public static void selectionSort(TheArray accountList){
        int size = accountList.getNumElements();
        int mindex = 0;
        for(int i = 1; i < size - 1; i++){
            if(accountList.getAccount(i) != null) {
                int min = accountList.getAccount(i).getAccountNum();
                mindex = i;
                for (int j = i + 1; j < size; j++) {
                    if (accountList.getAccount(j).getAccountNum() < min) {
                        min = accountList.getAccount(j).getAccountNum();
                        mindex = j;
                    }
                }
            }
            swap(accountList, i, mindex);
        }
    }
    public static void swap(TheArray accountList, int currentPosition, int mindex){
        Account temp = accountList.getAccount(currentPosition);
        accountList.setAccount(currentPosition, accountList.getAccount(mindex));
        accountList.setAccount(mindex, temp);
    }
    public static void insertionSort(TheArray accountList){
        for(int i = 2; i < accountList.getNumElements(); i++){
            if (accountList.getAccount(i) != null){
                Account currentNameAccount = accountList.getAccount(i);
                Integer currentName = nameToNum(accountList.getAccount(i).getLastName());
                int j = i - 1;
                while(j >= 1 && nameToNum(accountList.getAccount(j).getLastName()) > currentName){
                    accountList.setAccount(j + 1, accountList.getAccount(j));
                    j--;
                }
                accountList.setAccount(j + 1, currentNameAccount);
            }
        }
    }
    public static Integer nameToNum(String inputName){
        String name = inputName.toLowerCase();
        int num0 = name.charAt(0);
        String s0 = String.valueOf(num0);
        return Integer.valueOf(s0);
    }
    public static int binarySearch(TheArray accountList, String lastName){
        int low = 1;
        int high = accountList.getNumElements()-1;
        int searchedNameNum = nameToNum(lastName);

        while(low <= high){
            int mid = (low + high) / 2;
            int midAccount = accountList.getAccount(mid).getNameAsNum();

            if(accountList.getAccount(mid).getNameAsNum() == searchedNameNum && accountList.getAccount(mid).getLastName().equals(lastName)){
                return mid;
            }
            if (searchedNameNum < accountList.getAccount(mid).getNameAsNum()){
                high = mid - 1;
            }
            if (searchedNameNum > accountList.getAccount(mid).getNameAsNum()){
                low = mid + 1;
            }
        }
        return -1;
    }
}

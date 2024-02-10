import java.util.List;
import java.util.ArrayList;

public class SavedUser {
    BankAcc bankAccount = new BankAcc();
 
    static List<String> listUserNames = new ArrayList<>();
    static List<String> listPasswords = new ArrayList<>();
    static List<Integer> listAccountNumbers = new ArrayList<>();
    static List<Double> listBalance = new ArrayList<>();

    public void saveUserInfo(){
        
        listUserNames.add(bankAccount.getUsername());
        listPasswords.add(bankAccount.getPassword());
        listAccountNumbers.add(bankAccount.getClientAccNumber());
      //  listBalance.add(bankAccount.getBalance());
    }
    public void saveBalance() {
    	listBalance.add(bankAccount.getBalance());
    	//listBalance.set(index,bankAccount.getBalance());
    }
    public void DisplayUserInfo(){
        System.out.println("-------------All information is added in save info -----------------");
        System.out.println(listUserNames);
        System.out.println(listPasswords);
        System.out.println(listAccountNumbers);
        System.out.println(listBalance);
        System.out.println();
        System.out.println();
        //Currencies
      
    }
    /*public void parseUserInfoOnLogin(int accountNumber){
        bankAccount.setUsername(listUserNames.get(accountNumber));
        bankAccount.setPassword(listPasswords.get(accountNumber));
      
        bankAccount.setClientAccNumber(accountNumber);
        bankAccount.setBalance(listBalance.get(accountNumber));
      } 
    */
    public void deletePreviousUserInfo(){
        bankAccount.setUsername(null);
        bankAccount.setPassword(null);
        bankAccount.setClientFirstName(null);
        bankAccount.setClientLastName(null);
        bankAccount.setClientAccNumber(0);
        //bankAccount.setBalance(0);/////////////////
      
    }
}
import java.util.Locale;
import java.util.Scanner;

public class SignUpLogIn extends BankMain implements LoginSingup {

    static int accountNumberSetter = 5678;
    int inputAcno = 0;

    public void signUpLogIn() {
        SavedUser savedUsers = new SavedUser();
        BankAcc bankAccount = new BankAcc();
        Banking banking = new Banking();
        Scanner sc = new Scanner(System.in);

        String inputPassword = "";
        String name = " ";
        MenuMy m = new MenuMy();
        boolean signInLogInMenuLoop = true;
        System.out.println(LoginSingup.LSGUI);
        String s = sc.nextLine();

        do {
            switch (s.toLowerCase(Locale.ROOT).trim()) {

                case "sign up":
                case "signup":

                    System.out.println("Enter user Name : ");
                    // Scanner ch=new Scanner(System.in);
                    name = sc.nextLine();
                    bankAccount.setUsername(name);

                    System.out.println("Enter Userid :");
                    bankAccount.setUserid(sc.nextInt());

                    // addd adhar card option and validations also

                    System.out.println("Enter Password:");
                    bankAccount.setPassword(sc.next());

                    System.out.println("Your account number is");
                    bankAccount.setClientAccNumber(accountNumberSetter++);
                    System.out.println(bankAccount.getClientAccNumber());
                    System.out.println("Enter amount Balance : ");
                    // Scanner sc=new Scanner(System.in);

                    banking.bal = sc.nextInt();
                    bankAccount.setBalance(banking.bal);
                    savedUsers.saveBalance();
                    System.out.println();

                    System.out.println();

                    System.out.println("----------------- Bank account successfully created!-----------------");
                    savedUsers.saveUserInfo();
                    savedUsers.DisplayUserInfo();
                    m.menue();

                    // return false;

                case "login":
                case "log in":
                    System.out.println("Enter Accno:");
                    inputAcno = sc.nextInt();
                    if (savedUsers.listAccountNumbers.contains(inputAcno)) {
                        System.out.println("Enter Password:");
                        inputPassword = sc.next();
                        if (inputPassword.equals(
                                savedUsers.listPasswords.get(savedUsers.listAccountNumbers.indexOf(inputAcno)))) {
                            System.out.println("Successful login!");
                            // System.out.println("Enter Account umber : ");

                            // int accno=savedUsers.listUserNames.indexOf(inputUserName);
                            // savedUsers.parseUserInfoOnLogin(savedUsers.listPasswords.indexOf(accno));

                            m.menue();
                            // return false;
                        } else {
                            System.out.println("Wrong Password!");
                        }
                    } else {
                        System.out.println("Wrong Username!");
                    }
                case "stop":
                    signInLogInMenuLoop = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
                    signInLogInMenuLoop = false;
                    break;

            }
        } while (signInLogInMenuLoop);
        System.out.println("Exit");

    }
}
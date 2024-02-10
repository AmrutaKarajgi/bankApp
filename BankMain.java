import java.util.Scanner;

class Banking {
	int Accno;
	double bal = 0;

	BankAcc bankAccount = new BankAcc();
	SavedUser s = new SavedUser();

	String name;

	boolean getdata() {

		// int balance= (int)BankAcc.getBalance();
		boolean val = false;
		Scanner ch = new Scanner(System.in);

		System.out.println("Enter user name ");
		String name = ch.next();

		int flag;
		// System.out.println(s.listAccountNumbers);
		// System.out.println(Accno);
		do {

			flag = 0;
			System.out.println("Enter Account Number : ");
			Accno = ch.nextInt();
			if (s.listAccountNumbers.contains(Accno)) {
				System.out.println("Your validation is succss");
				System.out.println("----------------------------");///////////

				System.out.println();
				s.DisplayUserInfo();
				System.out.println();

				int index = s.listAccountNumbers.indexOf(Accno);

				System.out.println("index of accno " + Accno + " is " + index);
				System.out.println(s.listUserNames.get(index) + " s.listUserNames.get(index)");
				System.out.println(name + " name");
				System.out.println(index + " index");

				if (s.listBalance.isEmpty() == false && s.listBalance.get(index) > 0) {//
					// v|| s.listUserNames.get(index).equals(name) login condition after signout {
					// //bal=(int)
					BankAcc.getBalance();
					System.out.println(s.listBalance.get(index));
				} else

				{
					System.out.println("Enter amount Balance : ");
					bal = ch.nextInt();
					bankAccount.setBalance(bal);
					s.saveBalance();
					System.out.println();
					s.DisplayUserInfo();
					System.out.println();

				}
				flag = 0;
				val = true;
			} else {
				System.out.println("-------- invalid---------");
				flag = 1;
			}
		} while (flag == 1);
		return val;
	}

	void disp(int Accno) {
		System.out.println("--------------------------------------------------");
		System.out.println("Hello '" + name + "' Welcome to our Bank");
		System.out.println("---------------------------------------------------");
		System.out.println("\t\tDISPLAY DETAILS");
		System.out.println("---------------------------------------------------");
		System.out.println("\t\tAccount number   : " + Accno);
		System.out.println("\t\tCurrent Balance  : " + s.listBalance.get(s.listAccountNumbers.indexOf(Accno)));
		System.out.println("--------------------------------------------------");
	}

	void dep(int Accno) {
		int dep = 0;

		System.out.println("Enter amount you want to Deposit");
		Scanner ch = new Scanner(System.in);
		dep = ch.nextInt();
		System.out.println("Accno is ----------------> " + Accno);

		bal = s.listBalance.get(s.listAccountNumbers.indexOf(Accno));

		System.out.println();
		System.out.println();
		// Currencies

		bal = bal + dep;
		s.listBalance.set(s.listAccountNumbers.indexOf(Accno), bal);

		System.out.println("--------------------------------------------------");
		System.out.println("\t Your new Balance amnt is: " + bal);
		System.out.println("--------------------------------------------------");
	}

}

abstract class Savingacc extends Banking {
	abstract void withd(int AccNo);
}

class Currentacc extends Savingacc {
	void withd(int Accno) {
		int outmoney;
		System.out.println("Enter amount you want to Withdraw");
		Scanner ch = new Scanner(System.in);
		outmoney = ch.nextInt();

		bal = s.listBalance.get(s.listAccountNumbers.indexOf(Accno));
		bal = bal - outmoney;
		s.listBalance.set(s.listAccountNumbers.indexOf(Accno), bal);
		if (bal >= 500) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Your new Balance amount is : " + bal);
			System.out.println("---------------------------------------------------------------------------");
		} else
			System.out.println("You cannot withdraw money due to low balance ");

	}

	void withdraw(int Accno) {
		int outmoney;
		System.out.println("Enter amnt you want to Withdraw");
		Scanner ch = new Scanner(System.in);
		outmoney = ch.nextInt();
		bal = s.listBalance.get(s.listAccountNumbers.indexOf(Accno));
		bal = bal - outmoney;
		s.listBalance.set((s.listAccountNumbers.indexOf(Accno)), bal);
		if (bal >= 0) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("Your new Balance amnt is: " + bal);
			System.out.println("---------------------------------------------------------------------------");
		} else
			System.out.println("Invalid transaction due to 'zero' Balance");
	}

}

public class BankMain {
	public static boolean innerMenuLoop = true;
	public static boolean outerMenuLoop = true;

	public static void main(String[] args)

	{
		SignUpLogIn sign = new SignUpLogIn();
		sign.signUpLogIn();
		/*
		 * do {
		 * SignUpLogin signUpLogIn = new SignUpLogin();
		 * 
		 * // sign up and log in menu
		 * while (signUpLogIn.signUpLogIn());
		 * 
		 * // Select menu
		 * 
		 * Scanner sc = new Scanner(System.in);
		 * MenuMy m = new MenuMy();
		 * m.menue();
		 * } while (outerMenuLoop);
		 */
		System.out.println("");
		System.out.println("All process completed");
	}
}

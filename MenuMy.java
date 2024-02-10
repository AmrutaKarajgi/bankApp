import java.util.Scanner;

public class MenuMy<SignUpLogin> {

	// ob1.disp();
	// ob1.dep();
	SignUpLogin sign = new SignUpLogin();

	Banking b = new Banking();
	BankMain bankMa = new BankMain();
	BankAcc bankAccount = new BankAcc();
	SavedUser savedUsers = new SavedUser();
	// MenuSelector menue =new MenuSelector();
	// ob1.withd();
	Savingacc ob1 = new Currentacc();
	String passVerificator = "";

	public void subMenue() {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		int flag = 1;
		int outer = 0;
		int accno = 0;
		do {

			System.out.println("------Submenue-----");
			System.out.println("1.deposite\n2.withdraw\n3.check balance\n4.signout \n5 print list ");// \n4.signout\n5.go
																										// to origanl
																										// menue
			ch = sc.nextInt();
			switch (ch) {
				case 1:
					System.out.println("enter account number");
					accno = sc.nextInt();
					if (savedUsers.listAccountNumbers.contains(accno)) {
						System.out.println("You Must Verify Your Password First!");
						passVerificator = sc.next();
						int accIndex = savedUsers.listAccountNumbers.indexOf(accno);
						if (passVerificator.equals(savedUsers.listPasswords.get(accIndex))) {
							System.out.println("Password Is Correct!");
							ob1.dep(accno);
							System.out.println(
									"------------------------------------------------------------------------------------------------");
							System.out.println("");
							System.out.println(
									"         !!!CONGRATULATIONS!!! ALL TRANSACTION FOR 'SAVING ACCOUNT' IS  SUCCESSFULLY DONE       ");
							System.out.println("");
							System.out.println(
									"------------------------------------------------------------------------------------------------");
						} else {
							System.out.println("Password is incorrect!");
						}

					} else {
						System.out.println("Acxount does not exits --- > ");
					}

					System.out.println("Do you want to do any more transaction press 1");
					flag = sc.nextInt();
					// depositSystem.depositSystem();
					break;

				case 2:
					System.out.println("enter account number");
					accno = sc.nextInt();
					if (savedUsers.listAccountNumbers.contains(accno)) {

						System.out.println("You Must Verify Your Password First!");
						passVerificator = sc.next();
						int accIndex = savedUsers.listAccountNumbers.indexOf(accno);
						if (passVerificator.equals(savedUsers.listPasswords.get(accIndex))) {
							System.out.println("Password Is Correct!");
							ob1.withd(accno);

							System.out.println(
									"------------------------------------------------------------------------------------------------");
							System.out.println("");
							System.out.println(
									"        !!!CONGRATULATIONS!!! ALL TRANSACTION FOR 'CURRENT ACCOUNT' IS SUCCESSFULLY DONE");
							System.out.println("");
							System.out.println(
									"------------------------------------------------------------------------------------------------");

						} else {
							System.out.println("Password is incorrect!");
						}
					} else {
						System.out.println("Invalide ACcount no ");

					}
					System.out.println("Do you want to do any more transaction press 1");
					flag = sc.nextInt();
					break;

				case 3:
					// System.out.println(sign.inputAcno+" --- > sign.inputAcno");
					System.out.println("Enter account no : ------- > ");
					accno = sc.nextInt();
					if (savedUsers.listAccountNumbers.contains(accno)) {

						System.out.println("You Must Verify Your Password First!");
						passVerificator = sc.next();

						int accIndex = savedUsers.listAccountNumbers.indexOf(accno);
						if (passVerificator.equals(savedUsers.listPasswords.get(accIndex))) {
							System.out.println("Password Is Correct!");
							ob1.disp(accno);
						} else {
							System.out.println("Incorrect password");
						}
					} else {
						System.out.println("Incorrect acc number");
					}
					System.out.println("Do you want to do any more transaction press 1");
					flag = sc.nextInt();
					// balanceSystem.balanceSystem();
					break;

				case 4:// signout
						// System.out.println("Do you want to sign out press 1");

					// bankMa.outerMenuLoop = true;

					flag = 0;
					break;

				case 5:
					savedUsers.DisplayUserInfo();
					// savedUsers.DisplayUserInfo();
					flag = 0;
					// bankMa.outerMenuLoop = true;
					break;

				default:
					System.out.println("You have entered a wrong value!");
			}
		} while (flag == 1);
		sign.signUpLogIn();

	}

	void menue() {
		System.out.println("  Welcome to our bank");
		System.out.println("  hello user please insure validity");

		System.out.println("  Welcome to our bank");

		System.out.println("1.Saving acc\n2.current acc");
		System.out.println("Enter acc type");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		switch (a) {
			case 1:

				System.out.println("");
				System.out.println("======================= SAVING ACCOUNT====================== ");
				// Savingacc obj1= new Savingacc();
				// we can not create obj of abstract class for calling abstrct methode creat obj
				// of abstrct class pointing to the class where implimentation of abstrct
				// methode written
				// Savingacc ob1=new Currentacc();
				subMenue();
				break;
			case 2:
				System.out.println("======================= ENTER CURRENT ACCOUNT DETAILS ==================== ");
				System.out.println("");

				subMenue();
				System.out.println("-----------!!! THANK YOU MUST VISIT AGAIN !!!-------------");
				break;
			default:
				System.out.println("Invalid");
		}

	}
}

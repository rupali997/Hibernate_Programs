package com.Controller;
// Controller
import java.util.Scanner;


import com.Service.RBI;
import com.Service.SBI;


public class Admin {

	public static void main(String[] args) {

		RBI rbi = new SBI();
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("!!-----Welcome To SBI-----!!");
			System.out.println();
			System.out.println("Select : " + "\n1 : Create Account" + "\n2 : View Account Details"
					+ "\n3 : Withdraw Money" + "\n4 : Deposit Money" + "\n5 : Update Account Details" + "\n6 : MoneyTransfer"
					+"\n7 : Fixied Deposit"+"\n8 : Exit");
			System.out.println();
			System.out.println("Enter your choice : ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				rbi.addAccount();
				break;
			case 2:
				rbi.viewAccountDetails();
				break;
			case 3:
				rbi.withdrawMoney();
				break;
			case 4:
				rbi.depositMoney();
				break;
			case 5:
				rbi.updateAccountDetails();
				break;
			case 6:
				rbi.moneyTransfer();
				break;
			case 7:
				rbi.fixiedDeposit();
				break;
			case 8:
				System.out.println("Thank You!!");
				sc.close();
				System.exit(1);
				break;
			default:
				System.out.println("Wrong choice, Please try again!!!");
				break;
				
			}
		
		}

	}
}

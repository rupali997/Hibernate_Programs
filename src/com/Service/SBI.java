package com.Service;

//import java.util.InputMismatchException;
import java.util.Scanner;

import com.Exception_handling.InValidDigitException;

import com.Exception_handling.InsufficientBalenceException;
import com.Exception_handling.InsufficientFDAmountException;
import com.Model.Account;

public class SBI implements RBI {
	Account a = new Account();
	Scanner sc = new Scanner(System.in);
	boolean b = true;

	@Override
	public void addAccount() {
		while (b) {

			while (b) {
				try {
					System.out.println("Enter account number : ");
					int acno = sc.nextInt();

					// Note : In future we also can do , that user enter some characters in account
					// number so it will throw NumberFormatException
//					String acno = sc.next();
//					int account = Integer.parseInt(acno);

					int account = acno;
					int count = 0;
					int rem;
					for (int i = 0; i < 10; i++) {
						rem = account / 10;
						account = rem;
						count++;

						if (account == 0) {

							break;
						}

					}
					if (count == 5) {
						a.setAccno(acno);
						break;
					}
					if (count < 5 || count > 5) {

						throw new InValidDigitException("account should be of 5 digit");
					}

				}

				catch (InValidDigitException e) {
					System.out.println("Catch Block : " + e.getMessage());
				}
			}
			System.out.println("Enter account holder name :");
			a.setName(sc.next());

			System.out.println("Enter bank address :");
			a.setAddress(sc.next());

			System.out.println("Enter pan number :");
			a.setPan(sc.next());

			System.out.println("Enter adhar number :");
			a.setAdhar(sc.next());

			System.out.println("Enter account balence :");
			a.setBalence(sc.nextDouble());

			System.out.println("Account registers Successfull !!");
			break;
		}
	}

	@Override
	public void viewAccountDetails() {
		System.out.println("Enter account number : ");
		int acno = sc.nextInt();

		if (a.getAccno() == acno && a.getAccno() != 0) {
			System.out.println(a);
		} else {
			System.out.println("Account does not exists, please create account first!!");
		}

	}

	@Override
	public void withdrawMoney() {
		System.out.println("Enter account number : ");
		int acno = sc.nextInt();
		if (a.getAccno() == acno && a.getAccno() != 0) {
			try {
				System.out.println("Please enter the amount which you want to withdraw?");
				double balence = sc.nextDouble();
				if (balence <= a.getBalence()) {
					double Total_balence = a.getBalence() - balence;
					a.setBalence(Total_balence);
					System.out.println("your account is debited for Rs." + balence + "."
							+ " your current account balence is Rs." + Total_balence);

				} else {

					throw new InsufficientBalenceException(
							"Sorry ,You can not able to withdraw money due to Insufficient fund !!");
				}
			} catch (InsufficientBalenceException e) {
				System.out.println("Catch Block : " + e.getMessage());
			}

		} else {
			System.out.println("Account does not exists, please create account first!!");
		}
	}

	@Override
	public void depositMoney() {
		System.out.println("Enter account number : ");
		int acno = sc.nextInt();

		if (a.getAccno() == acno && a.getAccno() != 0) {
			System.out.println("Enter the money you want deposit : ");
			double money = sc.nextDouble();

			double Total_balence = a.getBalence() + money;
			a.setBalence(Total_balence);
			System.out.println("Your account has been credited of Rs." + money + "." + " Your current balence is Rs."
					+ Total_balence);
		}
		System.out.println("Account does not exists, please create account first!!");

	}

	@Override
	public void updateAccountDetails() {

		System.out.println("Enter account number : ");
		int acno = sc.nextInt();

		if (a.getAccno() == acno && a.getAccno() != 0) {
			while (b) {

				System.out.println("Select : ");
				System.out.println();
				System.out.println("1 : Update Name");
				System.out.println("2 : Update Address");
				System.out.println("3 : Update PAN");
				System.out.println("4 : Update ADHAR");
				System.out.println("5 : Exit");
				System.out.println("Enter your choice :");

				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("please enter the name which you want to update : ");
					String name = sc.next();
					name = name + sc.nextLine();
					a.setName(name);
					System.out.println("Name Updated Successfully!!");
					break;

				case 2:
					System.out.println("please enter the pan card number which you want to update : ");
					String p_num = sc.next();
					a.setPan(p_num);
					System.out.println("PAN Updated Successfully!!");
					break;

				case 3:
					System.out.println("please enter the address which you want to update  : ");
					String addr = sc.next();
					a.setAddress(addr);
					System.out.println("Address Updated Successfully!!");
					break;

				case 4:
					System.out.println("please enter the adhar card number which you want to update : ");
					String a_num = sc.next();
					a.setAdhar(a_num);
					System.out.println("ADHAR Updated Successfully!!");
					break;

				case 5:
					b = false;
					System.out.println("Your account has updated successfully!!");
					break;
				}
			}
		} else {
			System.out.println("Account does not exists, please create account first!!");
		}
	}

	public void moneyTransfer() {
		System.out.println("Enter account number : ");
		int acno = sc.nextInt();

		if (a.getAccno() == acno && a.getAccno() != 0) {

			System.out.println("Enter the amount which you want to transfer: ");
			int amount = sc.nextInt();

			try {
				if (amount <= a.getBalence()) {
					System.out.println("Transaction Successful!!");
				} else {
					throw new InsufficientBalenceException(
							"Your money transaction was not successful due Insufficient fund!");
				}
			} catch (InsufficientBalenceException e) {
				System.out.println("Catch Block : " + e.getMessage());
			}
		} else {

			System.out.println("Account does not exists, please create account first!!");

		}
	}

	@Override
	public void fixiedDeposit() {
		System.out.println("Enter account number : ");
		int acno = sc.nextInt();

		if (a.getAccno() == acno && a.getAccno() != 0) {
			System.out.println("Your principle amount should be atleast Rs.1Lakh with Two-year FD");
			System.out.println("Enter the amount for Fixied Deposit: ");
			Double amount = sc.nextDouble();
			try {

				if (amount == 100000) {
					System.out.println("Enter year to widraw FD:");
					int year = sc.nextInt();
					if (year < 2) {
						System.out.println(
								"You have pay 1 per cent penalty of principle amount to bank,because You widraw your FD prematurly!");
					} else {
						System.out.println(
								"After completing two years, you will get 50 per cent benifit on your principle amount");
					}
				}

				else {
					throw new InsufficientFDAmountException("Amount needed for FD is Rs.1Lakh");
				}
			} catch (InsufficientFDAmountException e) {
				System.out.println("Catch Block : " + e.getMessage());
			}
		}

		else {

			System.out.println("Account does not exists, please create account first!!");

		}

	}

}

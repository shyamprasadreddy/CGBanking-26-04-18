package com.cg.banking.main;

import java.util.Scanner;

import com.cg.banking.beans.Address;
import com.cg.banking.beans.Customer;
import com.cg.banking.services.BankingServicesImpl;

public class MainClass {
	public static void main(String[] args) {
		BankingServicesImpl bankServices=new BankingServicesImpl();
		try {
			Scanner in=new Scanner(System.in);
			int k=0;
			while (k!=11) {
				System.out.println("Select the Input\n"+"1)Register Customer\n2)Add Account\n3)Generate Pin\n4)Change Pin\n"
						+"5)Deposit Amount\n6)Withdraw Amount\n7)Fund Transfer\n8)Close Account\n"
						+"9)Remove Customer\n10)Get customer Details\n11)Exit Portal");
				k=in.nextInt();
				switch (k) {
				case 1:System.out.println("Enter customer Details in below order");
				System.out.println("Enter firstName");
				String firstName=in.next();
				System.out.println("Enter lastName");
				String lastName=in.next();
				System.out.println("Enter emailId");
				String emailId=in.next();
				System.out.println("Enter panNo");
				String panCard=in.next();
				System.out.println("Enter local Address city");
				String localAddressCity=in.next();
				System.out.println("Enter local Address state");
				String localAddressState=in.next();
				System.out.println("Enter local Pincode");
				int localAddressPinCode=in.nextInt();
				System.out.println("Enter home Address city");
				String homeAddressCity=in.next();
				System.out.println("Enter home Address state");
				String homeAddressState=in.next();
				System.out.println("Enter home Address Pincode");
				int homeAddressPinCode=in.nextInt();
				int cust=bankServices.acceptCustomerDetails(firstName,lastName,emailId,panCard,localAddressCity,localAddressState,localAddressPinCode,homeAddressCity,homeAddressState,homeAddressPinCode);
				System.out.println("Succesfully created customer with Id \n"+cust);
				System.out.println((bankServices.getCustomerDetails(cust)).toString());
				break;
				case 2:System.out.println("Enter account Details in below order\n");
				System.out.println("Enter Customer id");
				int cus=in.nextInt();
				System.out.println("Enter Account type");
				String acc=in.next();
				System.out.println("Enter Amount deposited");
				float deposit=in.nextFloat();
				long acc1=bankServices.openAccount(cus,acc,deposit);
				System.out.println("successfully added account "+acc1+" for customer of id "+cus+"\n");
				break;
				case 3:System.out.println("Enter the details");
				System.out.println("Enter CustomerId");
				cus=in.nextInt();
				System.out.println("EnterAccountNo");
				long acco=in.nextLong();
				int pin=bankServices.generateNewPin(cus,acco);
				System.out.println("The generated Pin is"+pin);
				break;
				case 4:System.out.println("Enter the details for pin change");
				System.out.println("Enter CustomerId");
				cus=in.nextInt();
				System.out.println("EnterAccountNo");
				long accou=in.nextLong();
				System.out.println("Enter OldPin");
				int oldPin=in.nextInt();
				System.out.println("Enter NewPin");
				int newPin=in.nextInt();
				boolean flag=bankServices.changeAccountPin(cus,accou,oldPin,newPin);
				if(flag==true)
					System.out.println("Successfully pin changed");
				else
					System.out.println("Pin change failed give vaild details");
				break;
				case 5:System.out.println("enter the required details to deposit amount\n");
					System.out.println("Enter CustomerId");	
					cus=in.nextInt();
					System.out.println("EnterAccountNo");
					long accoun=in.nextLong();
					System.out.println("Enter Amount to deposit");
					deposit=in.nextFloat();
					float bal=bankServices.depositAmount(cus,accoun,deposit);
					System.out.println("After Deposit the balance is "+bal);
					break;
				case 6:System.out.println("enter the required details to withdraw cash\n");
					cus=in.nextInt();
					System.out.println("EnterAccountNo");
					long account=in.nextLong();
					System.out.println("Enter Amount to withdraw");
					float withdraw=in.nextFloat();
					System.out.println("Enter Pin");
					pin=in.nextInt();
					float balance=bankServices.withdrawAmount(cus,account, withdraw,pin);
					System.out.println("After Deposit the balance is "+balance);
					break;
				case 7:System.out.println("Enter details for fund transfer");
				fundTransfer(customerIdTo,accountNoTo,customerIdFrom,accountNoFrom,transferAmount,pinNumber) 
				
				default:
					break;
				}
			}

			/*
			int cust=bankServices.acceptCustomerDetails("ravi", "teja", "email", "g55g6", "hyd", "Tg", 500072, "hyd", "Tg", 500072);
			System.out.println(cust);
			long acc=bankServices.openAccount(cust, "savings", 10000);
			//long acc1=bankServices.openAccount(cust, "savings", 300000);
			long acc2=bankServices.openAccount(cust, "savings",4300000);
			System.out.println(acc2);
			int pin=bankServices.generateNewPin(cust, acc);
			float bal=bankServices.depositAmount(cust, acc, 10000);
			float wit=bankServices.withdrawAmount(cust, acc, 15000,pin);
			boolean i=bankServices.changeAccountPin(cust, acc, pin, 1100);
			System.out.println((bankServices.getCustomerDetails(cust)).toString());
			System.out.println("pin"+" "+pin+" "+"Balance "+" "+bal+" "+"balance after withdrawl "+" "+wit+" "+i);*/
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
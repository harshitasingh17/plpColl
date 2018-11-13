package com.cg.dao;

import java.util.ArrayList;
import java.util.Map;

import com.cg.dto.Customer;
import com.cg.exception.WalletException;

public class WalletDAOImpl implements WalletDAO{
	
	Map<String,Customer> custMap;
	
	public WalletDAOImpl(){
		custMap = Collection.createCollection();
	}
	
	@Override
	public void createAccount(Customer customer) {
		// TODO Auto-generated method stub
		custMap.put(customer.getCuMobileNo(),customer);
		
	}

	@Override
	public void deposit(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customer customer = custMap.get(mobileNo);
		if(customer != null){
			double updateAmount = customer.getCuInitBalance();
			updateAmount += amount;
			String name = customer.getCuName();
			String newMobileNo = customer.getCuMobileNo();
			float age = customer.getCuAge();
			
			customer.setCuAge(age);
			customer.setCuInitBalance(updateAmount);
			customer.setCuName(name);
			customer.setCuMobileNo(newMobileNo);
			
			custMap.put(newMobileNo, customer);
			System.out.println("Amount deposited");
		}
		else{
			System.out.println("Mobile number not found");
		}
	}

	@Override
	public void withdraw(String mobileNo, double withdrawAmount) {
		// TODO Auto-generated method stub
		Customer customer = custMap.get(mobileNo);
		if(customer != null){
			double amount = customer.getCuInitBalance();	
			
			String name = customer.getCuName();
			String newMobileNo = customer.getCuMobileNo();
			float age = customer.getCuAge();
			
			if(amount - withdrawAmount > 00)
				amount -= withdrawAmount;
			
			customer.setCuAge(age);
			customer.setCuInitBalance(amount);
			customer.setCuName(name);
			customer.setCuMobileNo(newMobileNo);
			
			custMap.put(newMobileNo, customer);
			System.out.println("Amount withdrawn");
		}
		else{
			System.out.println("Mobile number not found");
		}
		
	}

	@Override
	public double checkBalance(String mobileNo) {
		// TODO Auto-generated method stub
		Customer custCheckBalance = custMap.get(mobileNo);
		double amount = custCheckBalance.getCuInitBalance();
		return amount;
		
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) {
		// TODO Auto-generated method stub
		
		String name, newMobileNo;
		float age;
		double amountFund;
		
		Customer custSender =  custMap.get(sender);
		Customer custReciever = custMap.get(reciever);
		
		double recieverAmount = custReciever.getCuInitBalance();
		double senderAmount = custSender.getCuInitBalance();
		if(senderAmount - amount > 500){
			recieverAmount += amount;
			senderAmount -= amount;
			System.out.println("Fund Transferred");
		}
		name = custSender.getCuName();
		newMobileNo = custSender.getCuMobileNo();
		age = custSender.getCuAge();
		amountFund = senderAmount;
		
		custSender.setCuAge(age);
		custSender.setCuInitBalance(senderAmount);
		custSender.setCuMobileNo(newMobileNo);
		custSender.setCuName(name);
		
		custMap.put(newMobileNo, custSender);
		
		name = custReciever.getCuName();
		newMobileNo = custReciever.getCuMobileNo();
		age = custReciever.getCuAge();
		amountFund = recieverAmount;
		
		custReciever.setCuAge(age);
		custReciever.setCuInitBalance(recieverAmount);
		custReciever.setCuMobileNo(newMobileNo);
		custReciever.setCuName(name);
		
		custMap.put(newMobileNo, custReciever);
		
		
		
	}

	@Override
	public boolean validateAccount(String mobileNo) throws WalletException {
		// TODO Auto-generated method stub
		Customer customer = custMap.get(mobileNo);
		if(customer == null)
			return false;
		return true;
	}

}

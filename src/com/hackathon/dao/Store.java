package com.hackathon.dao;

import java.util.HashSet;

import com.google.gson.Gson;

public class Store {
	
	static int count = 0;
	
	float PurchasedUnits = 0,MemberCount = 0, averageBasketValue = 0, transactionCount = 0, averageSales = 0, averageDiscount = 0;
	
	float sales = 0,discount = 0;
	HashSet<String> members = new HashSet<String>();
	HashSet<String> transactions = new HashSet<String>();
	public HashSet<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {
		this.transactions.add(transactions);
		
	}

	public HashSet<String> getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members.add(members);
	}

	public float getSales() {
		return sales;
	}

	public void setSales(float sales) {
		this.sales = sales;
	}

	public float getPurchasedUnits() {
		return PurchasedUnits;
	}

	public void setPurchasedUnits(float purchasedUnits) {
		PurchasedUnits = purchasedUnits;
	}

	public float getMemberCount() {
		return MemberCount;
	}

	public void setMemberCount() {
		MemberCount = members.size();
		members.clear();
	}

	public float getAverageBasketValue() {
		return averageBasketValue;
	}

	public void setAverageBasketValue() {
		this.averageBasketValue = sales/transactionCount;
	}

	public float getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount() {
		this.transactionCount = transactions.size();
		transactions.clear();
	}

	public float getAverageSales() {
		return averageSales;
	}

	public void setAverageSales() {
		this.averageSales = sales/MemberCount;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount, boolean flag) {
		if(!flag)
			this.discount = discount;
		else
			this.discount = this.discount*100/sales;
	}
	
	@Override
	public String toString() {
		if(!Double.isNaN(this.discount))
				return new Gson().toJson(this);
		return "{}";
		}
}

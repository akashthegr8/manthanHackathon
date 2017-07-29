package com.hackathon.dao;

import java.util.HashSet;

import com.google.gson.Gson;

public class Product {
	float membercount, purchaseunit, transactioncount;

	HashSet<String> members = new HashSet<String>();
	HashSet<String> transactions = new HashSet<String>();

	public HashSet<String> getMembers() {
		return members;
	}

	public void setMembers(String members) {
		this.members.add(members);
	}

	public HashSet<String> getTransactions() {
		return transactions;
	}

	public void setTransactions(String transactions) {
		this.transactions.add(transactions);

	}

	public float getMembercount() {
		return membercount;
	}

	public void setMembercount() {
		
		this.membercount = members.size();
		members.clear();
	}

	public float getPurchaseunit() {
		return purchaseunit;
	}

	public void setPurchaseunit(float purchaseunit) {
		this.purchaseunit = purchaseunit;
	}

	public float getTransactioncount() {
		return transactioncount;
	}

	public void setTransactioncount() {
		this.transactioncount = transactions.size();
		this.transactions.clear();
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}

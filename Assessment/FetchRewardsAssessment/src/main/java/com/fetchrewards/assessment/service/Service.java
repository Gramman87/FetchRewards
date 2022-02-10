package com.fetchrewards.assessment.service;

import java.util.List;

import com.fetchrewards.assessment.entities.Transaction;

public interface Service {
	
	public void addTrans(Transaction points);
	
	public List<Transaction> spend(int quantity);
	
	public List<Transaction> balance();

}

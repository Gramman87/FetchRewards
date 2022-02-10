package com.fetchrewards.assessment.service;

import java.util.ArrayList;
import java.util.List;

import com.fetchrewards.assessment.entities.Transaction;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	private List<Transaction> balanceSheet = new ArrayList<>();

	@Override
	public void addTrans(Transaction point) {
		Transaction newPoints = new Transaction();
		newPoints.setPayer(point.getPayer());
		newPoints.setPoints(point.getPoints());
		this.balanceSheet.add(newPoints);
		sortPoints(this.balanceSheet);
	}

	@Override
	public List<Transaction> spend(int quantity) {
		long spent = 0;
		for (Transaction point : balanceSheet) {
			spent += point.getPoints();
		}
		System.out.println(spent);
		if (quantity > spent) {
			return null;
		} else {
			while (quantity != 0) {
				for (Transaction point : balanceSheet) {
					long credits = point.getPoints();
					if (credits >= quantity) {
						point.setPoints(credits - quantity);
						quantity = 0;
					} else {
						quantity -= credits;
						point.setPoints(0);
					}
				}
			}
		}
		sortPoints(balanceSheet);
		return balanceSheet;
	}

	@Override
	public List<Transaction> balance() {
		return balanceSheet;
	}

	private void sortPoints(List<Transaction> balance) {
		balance.sort((o1, o2) -> o1.getTimeStamp().compareTo(o2.getTimeStamp()));
	}

}

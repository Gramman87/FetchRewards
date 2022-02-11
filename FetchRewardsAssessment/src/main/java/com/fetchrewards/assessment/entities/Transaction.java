package com.fetchrewards.assessment.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Transaction {

	private String payer;

	private long points;

	@JsonIgnore
	private LocalDateTime timeStamp;

	public Transaction() {
		super();
		timeStamp = LocalDateTime.now();
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String name) {
		this.payer = name;
	}

	public long getPoints() {
		return points;
	}

	public void setPoints(long qty) {
		this.points = qty;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timestamp) {
		this.timeStamp = timestamp;
	}

	@Override
	public String toString() {
		return "{ payer: " + payer + ", points: " + points + " }";
	}

}

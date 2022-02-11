package com.fetchrewards.assessment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fetchrewards.assessment.entities.Transaction;
import com.fetchrewards.assessment.service.Service;

@RestController
@RequestMapping("api")
public class Controller {

	@Autowired
	private Service sVc;

	//Route end point "/api/add" adds points to local memory store
	@PostMapping("add")
	public void add(@RequestBody Transaction trans, HttpServletResponse res) {
		try {
			sVc.addTrans(trans);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.print("Error creating transaction!");
			res.setStatus(400);
			trans = null;
		}
	}

	//Route end point "/api/spend/{quantity of spent point}" deducts points from local memory store
	@PutMapping("spend/{qty}")
	public List<Transaction> spend(@RequestBody Transaction trans, @PathVariable Integer qty, HttpServletResponse res) {
		List<Transaction> result = new ArrayList<>();
		try {
			result = sVc.spend(qty);
			res.setStatus(201);
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return result;
	}

	//Route end point "/api/balance" returns totals of local memory store
	@GetMapping("balance")
	public String balance() {
		long total = 0;
		for (Transaction t : sVc.balance()) {
			total += t.getPoints();
		}
		return "Points: " + total;
	}
}

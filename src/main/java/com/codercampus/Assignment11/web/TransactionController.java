package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {
	
	@Autowired
	private TransactionService ttransactionService;
	
	@GetMapping("/transactions")
	public String getTransactions (ModelMap model) {
		List<Transaction> transactions = ttransactionService.findAll();
		
		model.put("transactions", transactions);
		
		return "transactions";
	}
	
	@GetMapping("/transactions/{tId}")
	public String getTransaction (ModelMap model, @PathVariable Long tId) {
		Transaction transactions = ttransactionService.findById(tId);
		model.put("transaction", transactions);
		return "transaction";
	}
}

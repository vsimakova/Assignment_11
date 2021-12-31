package com.codercampus.Assignment11.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository tRepo;
	
	public List<Transaction> findAll () {
		List<Transaction> transactions = tRepo.findAll();
		Collections.sort(transactions, (transactions1, transactions2) -> 
		transactions1.getDate().compareTo(transactions2.getDate())); 
		return transactions;
	}

	public Transaction findById(Long tId) {
		Optional<Transaction> transactionsOpt = tRepo.findAll()
											  .stream()
											  .filter(transactions -> transactions.getId().equals(tId))
											  .findAny();
		return transactionsOpt.orElse(new Transaction());
	}
}

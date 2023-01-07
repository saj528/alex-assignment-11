package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAll() {

        List<Transaction> transactions = transactionRepository.findAll();

        Collections.sort(transactions,(transaction1,transactions2) -> transaction1.getDate().compareTo(transactions2.getDate()));

        return transactions;
    }

    public Transaction findById(Long transactionId) {

        Optional<Transaction> transactionOptional = transactionRepository.findAll()
                .stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .findAny();
        System.out.println(transactionOptional.toString());
        return transactionOptional.orElse(new Transaction());
    }
}

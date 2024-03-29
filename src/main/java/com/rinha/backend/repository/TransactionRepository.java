package com.rinha.backend.repository;

import com.rinha.backend.domain.entities.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  List<Transaction> findTop10ByAccountIdOrderByCompletedAtDesc(Integer accountId);
}

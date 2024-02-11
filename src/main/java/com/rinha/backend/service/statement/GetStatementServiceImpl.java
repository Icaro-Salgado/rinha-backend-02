package com.rinha.backend.service.statement;

import com.rinha.backend.dto.statement.get.StatementBalanceDto;
import com.rinha.backend.dto.statement.get.StatementDto;
import com.rinha.backend.dto.statement.get.StatementTransactionDto;
import com.rinha.backend.entities.Account;
import com.rinha.backend.entities.Transaction;
import com.rinha.backend.repository.AccountRepository;
import com.rinha.backend.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetStatementServiceImpl implements GetStatementService {

  private final AccountRepository accountRepository;
  private final TransactionRepository transactionRepository;

  @Override
  public StatementDto execute(Integer accountId) {

    final var account =
        accountRepository.findById(accountId).orElseThrow(EntityNotFoundException::new);
    final var accountTransactions = transactionRepository.findByAccountId(accountId);

    return StatementDto.builder()
        .balance(buildBalance(account))
        .lastTransactions(accountTransactions.stream().map(this::buildTransaction).toList())
        .build();
  }

  private StatementTransactionDto buildTransaction(Transaction transaction) {
    return StatementTransactionDto.builder()
        .value(transaction.getTransactionValue())
        .transactionType(transaction.getType())
        .description(transaction.getDescription())
        .completedAt(transaction.getCompletedAt())
        .build();
  }

  private StatementBalanceDto buildBalance(Account account) {
    return StatementBalanceDto.builder()
        .total(account.getBalance())
        .referenceDate(Instant.now())
        .accountLimit(account.getAccountLimit())
        .build();
  }
}

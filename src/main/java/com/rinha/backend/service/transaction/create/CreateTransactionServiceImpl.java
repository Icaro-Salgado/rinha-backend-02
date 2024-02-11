package com.rinha.backend.service.transaction.create;

import com.rinha.backend.domain.dto.transaction.create.CreatedTransactionDto;
import com.rinha.backend.domain.entities.Account;
import com.rinha.backend.domain.entities.Transaction;
import com.rinha.backend.domain.schema.transaction.create.CreateTransactionSchema;
import com.rinha.backend.exception.InvalidInputException;
import com.rinha.backend.repository.AccountRepository;
import com.rinha.backend.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateTransactionServiceImpl implements CreateTransactionService {

  private final AccountRepository accountRepository;
  private final TransactionRepository transactionRepository;

  @Override
  @Transactional
  public CreatedTransactionDto execute(CreateTransactionSchema serviceInput) {
    final var account =
        accountRepository
            .findById(serviceInput.accountId())
            .orElseThrow(EntityNotFoundException::new);

    final var balanceAfterOperation = getBalanceAfterOperation(account, serviceInput);

    if (balanceAfterOperation + account.getAccountLimit() < 0) {
      throw new InvalidInputException();
    }

    return createTransaction(account, balanceAfterOperation, serviceInput);
  }

  private Long getBalanceAfterOperation(Account account, CreateTransactionSchema serviceInput) {
    return account.getBalance()
        + (serviceInput.transactionType().TRANSACTION_MULTIPLIER * serviceInput.value());
  }

  private CreatedTransactionDto createTransaction(
      Account account, Long balanceAfterOperation, CreateTransactionSchema serviceInput) {
    final var createdTransaction =
        Transaction.builder()
            .accountId(account.getId())
            .type(serviceInput.transactionType())
            .description(serviceInput.description())
            .transactionValue(serviceInput.value())
            .build();

    account.setBalance(balanceAfterOperation);
    accountRepository.save(account);
    transactionRepository.save(createdTransaction);

    return CreatedTransactionDto.builder()
        .accountBalance(account.getBalance())
        .accountLimit(account.getAccountLimit())
        .build();
  }
}

package com.rinha.backend.controller;

import com.rinha.backend.domain.dto.statement.get.StatementDto;
import com.rinha.backend.domain.dto.transaction.create.CreateTransactionDto;
import com.rinha.backend.domain.dto.transaction.create.CreatedTransactionDto;
import com.rinha.backend.domain.schema.transaction.create.CreateTransactionSchema;
import com.rinha.backend.service.statement.GetStatementServiceImpl;
import com.rinha.backend.service.transaction.create.CreateTransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/clientes")
@RestController
public class AccountController {

  private final CreateTransactionService createTransactionService;
  private final GetStatementServiceImpl getStatementService;

  @PostMapping("/{account_id}/transacoes")
  ResponseEntity<CreatedTransactionDto> createTransaction(
      @PathVariable("account_id") Integer accountId,
      @RequestBody @Valid CreateTransactionDto body) {

    return ResponseEntity.ok(
        createTransactionService.execute(
            CreateTransactionSchema.builder()
                .value(body.getValue())
                .transactionType(body.getType())
                .description(body.getDescription())
                .accountId(accountId)
                .build()));
  }

  @PostMapping("/{account_id}/extrato")
  ResponseEntity<StatementDto> getBalance(@PathVariable("account_id") Integer accountId) {

    return ResponseEntity.ok(getStatementService.execute(accountId));
  }
}

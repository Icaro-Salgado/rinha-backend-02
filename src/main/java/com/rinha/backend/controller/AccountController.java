package com.rinha.backend.controller;

import com.rinha.backend.dto.CreateTransactionDto;
import com.rinha.backend.schema.transaction.create.CreateTransactionSchema;
import com.rinha.backend.service.transaction.create.CreateTransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/clientes")
public class AccountController {

  private final CreateTransactionService createTransactionService;

  @PostMapping("/{account_id}/transacoes")
  ResponseEntity<?> createTransaction(
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
  ResponseEntity<?> getBalance(@PathVariable("account_id") String accountId) {

    return null;
  }
}

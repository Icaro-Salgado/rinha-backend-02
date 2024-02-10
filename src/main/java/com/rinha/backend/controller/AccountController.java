package com.rinha.backend.controller;

import com.rinha.backend.dto.CreateTransactionDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/clientes")
public class AccountController {

  @PostMapping("/{account_id}/transacoes")
  ResponseEntity<?> createTransaction(
      @PathVariable("account_id") String accountId, @RequestBody @Valid CreateTransactionDto body) {

    return null;
  }
}

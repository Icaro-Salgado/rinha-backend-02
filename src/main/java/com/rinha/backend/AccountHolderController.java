package com.rinha.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/clientes")
public class AccountHolderController {

  @PostMapping("/{account_holder_id}/transacoes")
  ResponseEntity<?> createTransaction(
      @PathVariable("account_holder_id") String accountHolderId,
      @RequestBody CreateTransactionDto body) {

    return null;
  }
}

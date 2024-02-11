package com.rinha.backend.domain.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransactionType {
  c(1),
  d(-1);

  public final int TRANSACTION_MULTIPLIER;
}

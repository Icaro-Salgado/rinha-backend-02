package com.rinha.backend.types;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransactionType {
  c(1),
  d(-1);

  public final int TRANSACTION_MULTIPLIER;
}

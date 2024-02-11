package com.rinha.backend.schema.transaction.create;

import com.rinha.backend.types.TransactionType;
import lombok.Builder;

@Builder
public record CreateTransactionSchema(
    Long value, TransactionType transactionType, String description, Integer accountId) {}

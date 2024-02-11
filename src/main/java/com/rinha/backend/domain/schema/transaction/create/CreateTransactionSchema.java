package com.rinha.backend.domain.create;

import com.rinha.backend.domain.types.TransactionType;
import lombok.Builder;

@Builder
public record CreateTransactionSchema(
    Long value, TransactionType transactionType, String description, Integer accountId) {}

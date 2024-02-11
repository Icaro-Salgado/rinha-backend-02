package com.rinha.backend.domain.dto.statement.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rinha.backend.domain.types.TransactionType;
import java.time.Instant;
import lombok.Builder;

@Builder
public record StatementTransactionDto(
    @JsonProperty("valor") Long value,
    @JsonProperty("tipo") TransactionType transactionType,
    @JsonProperty("descricao") String description,
    @JsonProperty("realizada_em") Instant completedAt) {}

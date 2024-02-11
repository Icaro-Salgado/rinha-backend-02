package com.rinha.backend.dto.statement.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rinha.backend.types.TransactionType;
import java.time.Instant;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public record StatementTransactionDto(
    @JsonProperty("valor") Long value,
    @JsonProperty("tipo") TransactionType transactionType,
    @JsonProperty("descricao") String description,
    @JsonProperty("realizada_em") Instant completedAt) {}

package com.rinha.backend.domain.dto.transaction.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class CreatedTransactionDto {
  @JsonProperty("limite")
  private Long accountLimit;

  @JsonProperty("saldo")
  private Long accountBalance;
}

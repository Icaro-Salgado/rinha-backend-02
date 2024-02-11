package com.rinha.backend.domain.dto.statement.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StatementDto {
  @JsonProperty("saldo")
  private StatementBalanceDto balance;

  @JsonProperty("ultimas_transacoes")
  private List<StatementTransactionDto> lastTransactions;
}

package com.rinha.backend.dto.statement.get;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StatementBalanceDto {
  private Long total;

  @JsonProperty("data_extrato")
  private Instant referenceDate;

  @JsonProperty("limite")
  private Long accountLimit;
}

package com.rinha.backend.domain.dto.transaction.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rinha.backend.domain.types.TransactionType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CreateTransactionDto {

  @NotNull
  @Digits(integer = 38, fraction = 0)
  @Min(0)
  @JsonProperty("valor")
  private BigDecimal value;

  @JsonProperty("tipo")
  @NotNull
  private TransactionType type;

  @NotBlank
  @Size(min = 1, max = 10)
  @JsonProperty("descricao")
  private String description;
}

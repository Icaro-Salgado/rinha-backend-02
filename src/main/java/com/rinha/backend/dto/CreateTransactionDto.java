package com.rinha.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rinha.backend.types.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
public class CreateTransactionDto {

  @NotNull
  @Min(0)
  @JsonProperty("valor")
  private Long value;

  @JsonProperty("tipo")
  @NotNull
  private TransactionType type;

  @NotNull
  @Size(min = 1, max = 10)
  @JsonProperty("descricao")
  private String description;
}

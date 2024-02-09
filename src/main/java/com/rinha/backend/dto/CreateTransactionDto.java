package com.rinha.backend.dto;

import com.rinha.backend.types.TransactionType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public class CreateTransactionDto {

  @NotNull
  @Min(0)
  private Long value;

  @NotNull private TransactionType type;

  @NotNull
  @Size(min = 1, max = 10)
  private String description;
}

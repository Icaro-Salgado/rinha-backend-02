package com.rinha.backend.service.transaction.create;

import com.rinha.backend.domain.dto.transaction.create.CreatedTransactionDto;
import com.rinha.backend.domain.schema.transaction.create.CreateTransactionSchema;

public interface CreateTransactionService {
  CreatedTransactionDto execute(CreateTransactionSchema serviceInput);
}

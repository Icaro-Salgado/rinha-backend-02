package com.rinha.backend.service.transaction.create;

import com.rinha.backend.dto.transaction.create.CreatedTransactionDto;
import com.rinha.backend.schema.transaction.create.CreateTransactionSchema;

public interface CreateTransactionService {
  CreatedTransactionDto execute(CreateTransactionSchema serviceInput);
}

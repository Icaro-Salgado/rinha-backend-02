package com.rinha.backend.service.transaction.create;

import com.rinha.backend.domain.create.CreateTransactionSchema;
import com.rinha.backend.domain.dto.transaction.create.CreatedTransactionDto;

public interface CreateTransactionService {
  CreatedTransactionDto execute(CreateTransactionSchema serviceInput);
}

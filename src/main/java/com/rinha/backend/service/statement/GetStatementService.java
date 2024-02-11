package com.rinha.backend.service.statement;

import com.rinha.backend.domain.dto.statement.get.StatementDto;

public interface GetStatementService {
  StatementDto execute(Integer accountId);
}

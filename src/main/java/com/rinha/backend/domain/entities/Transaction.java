package com.rinha.backend.domain.entities;

import com.rinha.backend.domain.types.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "transactions")
@AllArgsConstructor
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "account_id")
  private Integer accountId;

  @Column(name = "completed_at")
  private Instant completedAt;

  @Enumerated(EnumType.STRING)
  @Column(name = "transaction_type", length = 1)
  private TransactionType type;

  @Column(name = "transaction_value")
  private Long transactionValue;

  @Column(name = "description", length = 10)
  private String description;
}

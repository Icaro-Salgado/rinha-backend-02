CREATE TABLE accounts (
    id      INTEGER NOT NULL,
    "limit" BIGINT,
    balance BIGINT,
    CONSTRAINT pk_accounts PRIMARY KEY (id)
);

CREATE TABLE transactions (
    id           UUID NOT NULL,
    account_id   INTEGER,
    completed_at TIMESTAMP WITHOUT TIME ZONE,
    type         VARCHAR(1),
    description  VARCHAR(10),
    CONSTRAINT pk_transactions PRIMARY KEY (id)
);
CREATE TABLE accounts (
    id      INTEGER NOT NULL,
    account_limit BIGINT,
    balance BIGINT,
    CONSTRAINT pk_accounts PRIMARY KEY (id)
);

CREATE TABLE transactions (
    id SERIAL PRIMARY KEY,
    account_id   INTEGER,
    completed_at TIMESTAMP WITHOUT TIME ZONE,
    transaction_type  VARCHAR(1),
    transaction_value BIGINT,
    description  VARCHAR(10)
);

DO $$
BEGIN
    INSERT INTO
        accounts (id, account_limit, balance)
    VALUES
        (1, 100000, 0),
        (2, 80000, 0),
        (3, 1000000, 0),
        (4, 10000000, 0),
        (5, 500000, 0);
END;
$$;
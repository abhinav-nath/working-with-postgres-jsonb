CREATE TABLE test_schema.employees
(
  id  BIGINT GENERATED BY DEFAULT AS IDENTITY,
  bio JSONB,
  PRIMARY KEY (id)
);
DROP TABLE IF EXISTS person;

CREATE TABLE person (
                        id INT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(150),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- init-data
INSERT INTO person (id, name, email) VALUES (1, 'Alice', 'alice@example.com');
INSERT INTO person (id, name, email) VALUES (2, 'Bob',   'bob@example.com');
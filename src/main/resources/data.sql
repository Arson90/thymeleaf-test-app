DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    role VARCHAR(250) NOT NULL
);

INSERT INTO users (id, user_name, password, role) VALUES
    (null, 'jan.kowalski', '123', 'ROLE_ADMINISTRATOR'),
    (null, 'adam.nowak', '456', 'ROLE_CLIENT');
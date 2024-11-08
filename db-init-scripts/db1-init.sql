create SCHEMA IF NOT EXISTS db1;

CREATE TABLE IF NOT EXISTS db1.users (
                                         user_id INT AUTO_INCREMENT PRIMARY KEY,
                                         login VARCHAR(50) NOT NULL,
                                         first_name VARCHAR(50) NOT NULL,
                                         last_name VARCHAR(50) NOT NULL
);
INSERT INTO db1.users(login, first_name, last_name)
VALUES ('Petro1', 'Petrovitch1', 'Ivanets1'),
       ('Igor1', 'Vasya1', 'Borschenko1');
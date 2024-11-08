create SCHEMA IF NOT EXISTS db2;

CREATE TABLE IF NOT EXISTS db2.users (
                                         userId INT AUTO_INCREMENT PRIMARY KEY,
                                         login VARCHAR(50) NOT NULL,
                                         firstName VARCHAR(50) NOT NULL,
                                         lastName VARCHAR(50) NOT NULL
);
INSERT INTO db2.users(login, firstName, lastName)
VALUES ('Petro2', 'petro2', 'Ivanko2'),
       ('Igor2', 'Igor2', 'Petrenko2');
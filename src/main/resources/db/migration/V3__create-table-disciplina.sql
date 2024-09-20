CREATE TABLE disciplinas(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        codigo VARCHAR(20) NOT NULL,
        nome VARCHAR(100) NOT NULL,
        area VARCHAR(20) NOT NULL,
        carga_horaria INT NOT NULL
);
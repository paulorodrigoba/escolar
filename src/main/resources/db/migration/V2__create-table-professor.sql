CREATE TABLE professores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(10),
    telefone VARCHAR(20),
    admissao DATE NOT NULL,
    carga_horaria INT NOT NULL,
    ativo BOOLEAN NOT NULL
);

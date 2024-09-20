CREATE TABLE alunos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(14) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    sexo VARCHAR(10) NOT NULL,
    telefone VARCHAR(15),
    ativo BOOLEAN DEFAULT TRUE,


    -- Campos relacionados ao Endereço (embedded)
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    numero VARCHAR(10),
    complemento VARCHAR(100)
);
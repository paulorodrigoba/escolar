package br.com.cetam.escolar.api.domain.professor;

import br.com.cetam.escolar.api.domain.endereco.DadosEndereco;

import java.time.LocalDate;

public record DadosUpdateProfessor(
        String cpf,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String telefone,
        LocalDate admissao,
        int cargaHoraria,
        DadosEndereco endereco
) {
}

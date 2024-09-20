package br.com.cetam.escolar.api.domain.aluno;

import br.com.cetam.escolar.api.domain.endereco.DadosEndereco;

import java.time.LocalDate;

public record DadosCadastroAluno(
        String cpf,
        String rg,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        String telefone,

        DadosEndereco endereco
) {
}

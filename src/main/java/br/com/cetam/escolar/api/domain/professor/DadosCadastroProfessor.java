package br.com.cetam.escolar.api.domain.professor;

import java.time.LocalDate;

public record DadosCadastroProfessor(
        String cpf,
        String nome,
        LocalDate dataNascimento,
        String sexo,
        LocalDate admissao,
        int cargaHoraria,
        String telefone


) {
}

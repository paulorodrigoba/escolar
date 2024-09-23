package br.com.cetam.escolar.api.domain.professor;

import java.time.LocalDate;

public record DadosListaProfessor(
        Long id,
        String cpf,
        String nome,
        LocalDate admissao,
        int cargaHoraria
) {
    public DadosListaProfessor(Professor professor){
        this(
                professor.getId(),
                professor.getCpf(),
                professor.getNome(),
                professor.getAdmissao(),
                professor.getCargaHoraria()
        );
    }
}

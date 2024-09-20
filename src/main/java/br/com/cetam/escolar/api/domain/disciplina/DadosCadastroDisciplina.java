package br.com.cetam.escolar.api.domain.disciplina;

public record DadosCadastroDisciplina(
        String codigo,

        String nome,

        String area,

        Integer cargaHoraria
) {
}

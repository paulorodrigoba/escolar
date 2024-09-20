package br.com.cetam.escolar.api.domain.aluno;

public record DadosListagemAluno(
        Long id,
        String nome,
        String cpf,
        String telefone
) {
    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getTelefone());
    }
}

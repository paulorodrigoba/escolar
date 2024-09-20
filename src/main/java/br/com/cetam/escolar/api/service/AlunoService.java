package br.com.cetam.escolar.api.service;

import br.com.cetam.escolar.api.domain.aluno.Aluno;
import br.com.cetam.escolar.api.domain.aluno.DadosCadastroAluno;
import br.com.cetam.escolar.api.domain.aluno.DadosListagemAluno;
import br.com.cetam.escolar.api.domain.aluno.DadosUpdateAluno;
import br.com.cetam.escolar.api.domain.endereco.Endereco;
import br.com.cetam.escolar.api.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // Criar aluno
    public Aluno criarAluno(DadosCadastroAluno dados) {
        Aluno aluno = new Aluno(dados);
        return alunoRepository.save(aluno);
    }

    // Listar todos os alunos com DadosListagemAlunos
    public List<DadosListagemAluno> listarAlunos() {
        return alunoRepository.findAll().stream()
                .map(DadosListagemAluno::new)
                .collect(Collectors.toList());
    }

    // Buscar aluno por ID
    public Optional<Aluno> buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id);
    }

    // Atualizar aluno com DadosUpdateAluno
    public Aluno atualizarAluno(Long id, DadosUpdateAluno dados) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        aluno.setCpf(dados.cpf());
        aluno.setRg(dados.rg());
        aluno.setNome(dados.nome());
        aluno.setDataNascimento(dados.dataNascimento());
        aluno.setSexo(dados.sexo());
        aluno.setTelefone(dados.telefone());
        aluno.setEndereco(new Endereco(dados.endereco()));
        aluno.setAtivo(true);

        return alunoRepository.save(aluno);
    }

    // Deletar aluno
    public void deletarAluno(Long id) {
        alunoRepository.deleteById(id);
    }
}

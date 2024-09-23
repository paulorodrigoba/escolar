package br.com.cetam.escolar.api.service;

import br.com.cetam.escolar.api.domain.endereco.Endereco;
import br.com.cetam.escolar.api.domain.professor.DadosCadastroProfessor;
import br.com.cetam.escolar.api.domain.professor.DadosListaProfessor;
import br.com.cetam.escolar.api.domain.professor.DadosUpdateProfessor;
import br.com.cetam.escolar.api.domain.professor.Professor;
import br.com.cetam.escolar.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    // Criar professor
    public Professor cadastrarProfessor(DadosCadastroProfessor dados) {
        Professor professor = new Professor(dados);
        return repository.save(professor);
    }

    // Listar todos os Professores com DadosListaProfessor
    public List<DadosListaProfessor> listarProfessor() {
        return repository.findAll().stream()
                .map(DadosListaProfessor::new)
                .collect(Collectors.toList());
    }
    // Buscar professor por ID
    public Optional<Professor> buscarProfessorPorId(Long id) {
        return repository.findById(id);
    }
    // Atualizar professor com DadosUpdateProfessor
    public Professor atualizarProfessor(Long id, DadosUpdateProfessor dados) {
        Professor professor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        professor.setCpf(dados.cpf());
        professor.setNome(dados.nome());
        professor.setDataNascimento(dados.dataNascimento());
        professor.setSexo(dados.sexo());
        professor.setTelefone(dados.telefone());
        professor.setEndereco(new Endereco(dados.endereco()));
        professor.setAtivo(true);

        return repository.save(professor);
    }
    // Deletar professor
    public void deletarProfessor(Long id) {
        repository.deleteById(id);
    }
}

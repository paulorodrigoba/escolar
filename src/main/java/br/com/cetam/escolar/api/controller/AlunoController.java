package br.com.cetam.escolar.api.controller;

import br.com.cetam.escolar.api.domain.aluno.Aluno;
import br.com.cetam.escolar.api.domain.aluno.DadosCadastroAluno;
import br.com.cetam.escolar.api.domain.aluno.DadosListagemAluno;
import br.com.cetam.escolar.api.domain.aluno.DadosUpdateAluno;
import br.com.cetam.escolar.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ibc/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // Criar aluno
    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody DadosCadastroAluno dados) {
        Aluno novoAluno = alunoService.criarAluno(dados);
        return ResponseEntity.ok(novoAluno);
    }

    // Listar todos os alunos com DadosListagemAlunos
    @GetMapping
    public ResponseEntity<List<DadosListagemAluno>> listarAlunos() {
        List<DadosListagemAluno> alunos = alunoService.listarAlunos();
        return ResponseEntity.ok(alunos);
    }

    // Buscar aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoService.buscarAlunoPorId(id);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar aluno com DadosUpdateAluno
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody DadosUpdateAluno dadosAtualizados) {
        Aluno aluno = alunoService.atualizarAluno(id, dadosAtualizados);
        return ResponseEntity.ok(aluno);
    }

    // Deletar aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }
}

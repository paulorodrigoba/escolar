package br.com.cetam.escolar.api.controller;

import br.com.cetam.escolar.api.domain.professor.DadosCadastroProfessor;
import br.com.cetam.escolar.api.domain.professor.DadosListaProfessor;
import br.com.cetam.escolar.api.domain.professor.DadosUpdateProfessor;
import br.com.cetam.escolar.api.domain.professor.Professor;
import br.com.cetam.escolar.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<Professor> cadastrarProfessor (@RequestBody DadosCadastroProfessor dados){
        Professor novoProfessor = service.cadastrarProfessor(dados);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DadosListaProfessor>> listarProfessor(){
        List<DadosListaProfessor> professores = service.listarProfessor();
        return ResponseEntity.ok(professores);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarProfessorPorId(@PathVariable Long id){
        Optional<Professor> professor = service.buscarProfessorPorId(id);
        return  professor.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable Long id, @RequestBody DadosUpdateProfessor dadosAtualizados) {
        Professor professor = service.atualizarProfessor(id, dadosAtualizados);
        return ResponseEntity.ok(professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id) {
        service.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }


}

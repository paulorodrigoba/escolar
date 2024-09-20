package br.com.cetam.escolar.api.controller;

import br.com.cetam.escolar.api.domain.professor.Professor;
import br.com.cetam.escolar.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    @Autowired
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<Professor> cadastrarProfessor (@RequestBody Professor professor){
        Professor novoProfessor = service.cadastrarProfessor(professor);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessor(){
        List<Professor> professor = service.listarProfessor();
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }
}

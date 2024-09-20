package br.com.cetam.escolar.api.service;

import br.com.cetam.escolar.api.domain.professor.Professor;
import br.com.cetam.escolar.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository repository;

    public Professor cadastrarProfessor (Professor professor){
        return repository.save(professor);
    }

    public List<Professor> listarProfessor(){
        return repository.findAll();
    }
}

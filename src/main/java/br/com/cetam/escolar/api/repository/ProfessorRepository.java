package br.com.cetam.escolar.api.repository;

import br.com.cetam.escolar.api.domain.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}

package br.com.cetam.escolar.api.repository;

import br.com.cetam.escolar.api.domain.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}

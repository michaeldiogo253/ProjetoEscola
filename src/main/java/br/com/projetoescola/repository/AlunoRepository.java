package br.com.projetoescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetoescola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}

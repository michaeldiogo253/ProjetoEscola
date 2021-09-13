package br.com.projetoescola.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.projetoescola.dto.AlunoDto;
import br.com.projetoescola.model.Aluno;
import br.com.projetoescola.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

	public ResponseEntity<List<AlunoDto>> retornaTodosAlunos() {

		List<Aluno> alunos = repository.findAll();
		return ResponseEntity.ok(AlunoDto.converteParaListaDto(alunos));
	}

	public ResponseEntity<?> buscaAlunoPorId(Long id) {
		Optional<Aluno> optional = repository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new AlunoDto(optional.get()));
		}

		Map<String, String> errors = new HashMap<>();
		errors.put("erro", "Aluno não encontrado");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}

}

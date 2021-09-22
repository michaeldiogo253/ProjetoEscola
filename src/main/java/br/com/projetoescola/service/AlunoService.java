package br.com.projetoescola.service;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projetoescola.dto.AlunoDto;
import br.com.projetoescola.dto.FormAluno;
import br.com.projetoescola.dto.RespostaDoMetodoDeletarDto;
import br.com.projetoescola.exception.ExcecaoRecursoNaoEncontrado;
import br.com.projetoescola.model.Aluno;
import br.com.projetoescola.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public ResponseEntity<List<AlunoDto>> retornaTodosAlunos() {

		List<Aluno> alunos = alunoRepository.findAll();
		return ResponseEntity.ok(AlunoDto.converteParaListaDto(alunos));
	}

	public ResponseEntity<?> buscaAlunoPorId(Long id) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new AlunoDto(optional.get()));
		}

		Map<String, String> errors = new HashMap<>();
		errors.put("erro", "Aluno não encontrado");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}

	public ResponseEntity<AlunoDto> cadastrarAluno(@Valid FormAluno form, UriComponentsBuilder uriBuilder) {

		Aluno aluno = form.converterFormParaAluno(form);
		alunoRepository.save(aluno);

		URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();

		return ResponseEntity.created(uri).body(new AlunoDto(aluno));

	}

	public ResponseEntity<?> atualizarAluno(Long id, @Valid FormAluno form) {
		Optional<Aluno> optional = alunoRepository.findById(id);

		if (optional.isPresent()) {
			Aluno aluno = form.atualizar(id, alunoRepository);
			return ResponseEntity.ok(new AlunoDto(aluno));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ExcecaoRecursoNaoEncontrado("Aluno não encontrado!"));
	}

	public ResponseEntity<?> deletarAlunoPorID(Long id) {
		Optional<Aluno> optional = alunoRepository.findById(id);
		if (optional.isPresent()) {
			alunoRepository.deleteById(id);
			return ResponseEntity.ok(new RespostaDoMetodoDeletarDto("Aluno deletado com sucesso!"));
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new RespostaDoMetodoDeletarDto("Aluno não encontrado!"));

	}

}

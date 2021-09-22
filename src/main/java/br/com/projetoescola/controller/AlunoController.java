package br.com.projetoescola.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.projetoescola.dto.AlunoDto;
import br.com.projetoescola.dto.FormAluno;
import br.com.projetoescola.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping()
	@Transactional
	public ResponseEntity<List<AlunoDto>> listarTodosAlunosBranchParaApagar() {
		return alunoService.retornaTodosAlunos();

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> buscaAlunoEspecifico(@PathVariable Long id) {
		return alunoService.buscaAlunoPorId(id);

	}

	@PostMapping()
	@Transactional
	public ResponseEntity<AlunoDto> cadastrarAluno(@RequestBody @Valid FormAluno form,
			UriComponentsBuilder uriBuilder) {

		return alunoService.cadastrarAluno(form, uriBuilder);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> atualizarAluno(@PathVariable Long id, @RequestBody @Valid FormAluno form) {

		return alunoService.atualizarAluno(id, form);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletarAluno(@PathVariable Long id) {

		return alunoService.deletarAlunoPorID(id);
	}

}

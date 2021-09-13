package br.com.projetoescola.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoescola.dto.AlunoDto;
import br.com.projetoescola.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping()
	@Transactional
	public ResponseEntity<List<AlunoDto>> listarTodosAlunos() {
		return alunoService.retornaTodosAlunos();

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> buscaAlunoEspecifico(@PathVariable Long id) {
		return alunoService.buscaAlunoPorId(id);

	}

}

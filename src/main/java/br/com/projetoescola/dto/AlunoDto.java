package br.com.projetoescola.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.projetoescola.model.Aluno;

public class AlunoDto {

	private Long id;
	private String nome;
	private int idade;
	private String cpf;

	public AlunoDto(Long id, String nome, int idade, String cpf) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
	}

	public AlunoDto(Aluno aluno) {
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.idade = aluno.getIdade();
		this.cpf = aluno.getCpf();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public static List<AlunoDto> converteParaListaDto(List<Aluno> alunos) {
		List<AlunoDto> listaConvertida = new ArrayList<AlunoDto>();

		alunos.forEach((Aluno a) -> {
			listaConvertida.add(new AlunoDto(a.getId(), a.getNome(), a.getIdade(), a.getCpf()));
		});

		return listaConvertida;

	}

}

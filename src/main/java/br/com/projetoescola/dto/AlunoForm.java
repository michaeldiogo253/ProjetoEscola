package br.com.projetoescola.dto;

import javax.validation.constraints.NotBlank;

public class AlunoForm {

	@NotBlank
	private String nome;
	@NotBlank
	private int idade;

	public AlunoForm(String nome, int idade) {

		this.nome = nome;
		this.idade = idade;
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

}

package br.com.projetoescola.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import br.com.projetoescola.model.Aluno;
import br.com.projetoescola.repository.AlunoRepository;

public class FormAluno {

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull

	private int idade;

	@NotNull
	@NotEmpty
	private String cpf;

	public FormAluno(@NotBlank String nome, @NotBlank int idade, @NotBlank String cpf) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
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

	public Aluno converterFormParaAluno(FormAluno form) {

		Aluno aluno = new Aluno();
		aluno.setIdade(form.idade);
		aluno.setNome(form.nome);
		aluno.setCpf(form.cpf);

		return aluno;

	}

	public Aluno atualizar(Long id, AlunoRepository alunoRepository) {

		Aluno aluno = alunoRepository.findById(id).get();
		aluno.setNome(this.nome);
		aluno.setIdade(this.idade);
		aluno.setCpf(this.cpf);

		return aluno;
	}

}

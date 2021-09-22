package br.com.projetoescola.exception;

public class ExcecaoRecursoNaoEncontrado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExcecaoRecursoNaoEncontrado(String mensagem) {
		super(mensagem);
	}

}

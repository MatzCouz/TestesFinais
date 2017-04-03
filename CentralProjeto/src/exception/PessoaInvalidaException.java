package exception;

/**
 * PessoaInvalidaException.
 * Classe que recupera excecao do tipo Pessoa invalida.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo          
 */

public class PessoaInvalidaException extends Exception {
	public PessoaInvalidaException(){
		super("Pessoa invalida");
	}
	public PessoaInvalidaException(String messagem){
		super(messagem);
	}
}

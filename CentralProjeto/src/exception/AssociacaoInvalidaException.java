package exception;

/**
 * AssociacaoInvalidaException.
 * Classe que recupera excecao do tipo associacao invalida.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo          
 */

public class AssociacaoInvalidaException extends Exception {
	public AssociacaoInvalidaException(){
		super("Associacao inválida");
	}
	
	public AssociacaoInvalidaException(String msg){
		super(msg);
	}
}

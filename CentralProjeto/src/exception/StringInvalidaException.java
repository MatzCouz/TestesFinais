package exception;

/**
 * StringInvalidaException.
 * Classe que recupera excecao do tipo String invalida.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo          
 */

public class StringInvalidaException extends Exception{
	public StringInvalidaException(){
		super("String invalida");
	}
	
	public StringInvalidaException(String messagem){
		super(messagem);
	}
}

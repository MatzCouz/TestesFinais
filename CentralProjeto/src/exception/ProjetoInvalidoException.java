package exception;

/**
 * ProjetoInvalidoException.
 * Classe que recupera excecao do tipo Projeto invalido.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo          
 */

public class ProjetoInvalidoException extends Exception {
	public ProjetoInvalidoException(){
		super("Projeto invalido");
	}
	public ProjetoInvalidoException(String msg){
		super(msg);
	}
}

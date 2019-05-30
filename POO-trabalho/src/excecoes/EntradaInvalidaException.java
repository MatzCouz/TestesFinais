package excecoes;

public class EntradaInvalidaException extends Exception{
	public EntradaInvalidaException(){
		super("Valor inválido");
	}
	
	public EntradaInvalidaException(String messagem){
		super(messagem);
	}
}
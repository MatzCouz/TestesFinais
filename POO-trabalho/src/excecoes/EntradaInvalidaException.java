package excecoes;

public class EntradaInvalidaException extends Exception{
	public EntradaInvalidaException(){
		super("Valor inv�lido");
	}
	
	public EntradaInvalidaException(String messagem){
		super(messagem);
	}
}
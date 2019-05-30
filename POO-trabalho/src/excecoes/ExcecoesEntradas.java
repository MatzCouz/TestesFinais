package excecoes;

public class ExcecoesEntradas {
	
	
	
	private static final String ERRO_STRING = "Valor inv�lido!";
	private static final String ERRO_ANO = "Ano de fabrica��o inv�lido!";

	public static void validaStrings(String string) throws EntradaInvalidaException {
		if(string.isEmpty() || string == null) {
			throw new EntradaInvalidaException(ERRO_STRING);
		}
	}

	public static void validaAno(int anoFabricacao) throws EntradaInvalidaException {
		if(anoFabricacao < 0) {
			throw new EntradaInvalidaException(ERRO_ANO);
		}
	}
	
	
}

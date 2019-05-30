package montadora;

import java.util.ArrayList;
import java.util.List;

import excecoes.EntradaInvalidaException;
import excecoes.ExcecoesEntradas;
import veiculos.Veiculo;

public class Montadora {
	private String nome;
	private List<Veiculo> veiculos;
	
	public Montadora(String nome) throws EntradaInvalidaException {
		
		ExcecoesEntradas.validaStrings(nome);
		
		this.nome = nome;
		this.veiculos = new ArrayList<>();
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void importarCarrosHibridos() {
		
	}
	
	public void exportarCarrosHibridos() {
		
	}
}

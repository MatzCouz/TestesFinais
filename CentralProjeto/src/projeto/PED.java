package projeto;

import java.io.Serializable;

/**
 * PED
 * Classe que representa o tipo PED que contem uma herança de Projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param categoria
 *           -  modalidades do projeto de P&D.
 * @param prodTecnica
 *           - quantidade de produtividade do tipo tecnica.
 * @param prodAcademica
 *           - quantidade de produtividade do tipo academica.
 * @param patentes
 *           - quantidade de produtividade do tipo patente.
 * @param produtividade
 *           - colecao que armazena as produtividades.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import exception.EntradaInvalidaException;
import exception.StringInvalidaException;
import util.ExcecoesAssociacao;
import util.ExcecoesProjetos;
import util.Util;

public class PED extends Projeto implements Serializable{
	private String categoria;
	private int prodTecnica;
	private int prodAcademica;
	private int patentes;
	private HashMap<String, Integer> produtividade;
	
	public PED(int cod, String nome, String categoria, int prodTecnica, int prodAcademica, int patentes, String objetivo, Date data, int duracao) throws EntradaInvalidaException, StringInvalidaException{
		super(cod, nome, objetivo, data, duracao);

		ExcecoesProjetos.validaProducoesAcademicas(prodAcademica);
		ExcecoesProjetos.validaPatentes(patentes);
		ExcecoesProjetos.validaProducoesTecnicas(prodTecnica);

		this.categoria = categoria;
		this.patentes = patentes;
		this.prodAcademica = prodAcademica;
		this.prodTecnica = prodTecnica;
		produtividade = new HashMap<>();
	}

	public HashMap<String, Integer> getProdutividade() {
		return produtividade;
	}

	public void setProdutividade(HashMap<String, Integer> produtividade) {
		this.produtividade = produtividade;
	}



	public int getProdTecnica() {
		return prodTecnica;
	}

	public void setProdTecnica(int prodTecnica) {
		this.prodTecnica = prodTecnica;
	}

	public int getProdAcademica() {
		return prodAcademica;
	}

	public void setProdAcademica(int prodAcademica) {
		this.prodAcademica = prodAcademica;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getPatentes() {
		return patentes;
	}

	public void setPatentes(int patentes) {
		this.patentes = patentes;
	}
	
	
}

package projeto;

import java.io.Serializable;

/**
 * PET
 * Classe que representa o tipo PET que contem uma herança de Projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param impacto
 *           - impacto social.
 * @param rendimento
 *           - expectativa de aprovação.
 * @param prodAcademica
 *           - quantidade de produtividade do tipo academica.
 * @param patentes
 *           - quantidade de produtividade do tipo patente.
 * @param prodTecnica
 *           - quantidade de produtividade do tipo tecnica.
 * @param produtividade
 *           - coleção que armazena as produtividades.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import exception.EntradaInvalidaException;
import exception.StringInvalidaException;
import util.ExcecoesProjetos;
import util.Util;

public class PET extends Projeto implements Serializable{
	
	private int impacto;
	private int rendimento;
	private int prodAcademica;
	private int prodTecnica;
	private int patentes;
	
	private HashMap<String, Integer> produtividade;
	
	public PET(int cod, String nome, String objetivo, int impacto, int rendimento, int prodTecnica, int prodAcademica, int patentes, Date data, int duracao) throws EntradaInvalidaException, StringInvalidaException{
		super(cod, nome, objetivo, data, duracao);
			
		ExcecoesProjetos.validaProducoesAcademicas(prodAcademica);
		ExcecoesProjetos.validaPatentes(patentes);
		ExcecoesProjetos.validaProducoesTecnicas(prodTecnica);
		ExcecoesProjetos.validaRendimento(rendimento);
		ExcecoesProjetos.validaImpacto(impacto);
		
		this.impacto = impacto;
		this.rendimento = rendimento;
		this.prodAcademica = prodAcademica;
		this.prodTecnica = prodTecnica;
		this.patentes = patentes;

		produtividade = new HashMap<>();
	}

	public int getImpacto() {
		return impacto;
	}

	public void setImpacto(int impacto) {
		this.impacto = impacto;
	}

	public int getRendimento() {
		return rendimento;
	}

	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}

	public int getProdAcademica() {
		return prodAcademica;
	}

	public void setProdAcademica(int prodAcademica) {
		this.prodAcademica = prodAcademica;
	}

	public int getProdTecnica() {
		return prodTecnica;
	}

	public void setProdTecnica(int prodTecnica) {
		this.prodTecnica = prodTecnica;
	}

	public int getPatentes() {
		return patentes;
	}

	public void setPatentes(int patentes) {
		this.patentes = patentes;
	}


	public HashMap<String, Integer> getProdutividade() {
		return produtividade;
	}

	public void setProdutividade(HashMap<String, Integer> produtividade) {
		this.produtividade = produtividade;
	}
	
	
	
}

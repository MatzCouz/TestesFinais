package projeto;

import java.io.Serializable;

/**
 * Monitoria
 * Classe que representa o tipo Monitoria que contem uma herança de Projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param discEspec
 *           - disciplina especifica a que esta direcionado.
 * @param periodoLetivo
 *           - periodo letivo em que ocorreu.
 * @param rendimento
 *           - expectativa de aprovacao na disciplina.
 */

import java.util.Calendar;
import java.util.Date;

import exception.EntradaInvalidaException;
import exception.StringInvalidaException;
import util.ExcecoesProjetos;
import util.Util;

public class Monitoria extends Projeto implements Serializable{
	private String discEspec;
	private String periodoLetivo;
	private int rendimento;
	
	public Monitoria(int cod, String nome, String disciplina, int rendimento, String objetivo, String periodoLetivo, Date data, int duracao) throws EntradaInvalidaException, StringInvalidaException{
		super(cod, nome, objetivo, data, duracao);
		
		ExcecoesProjetos.validaDisciplina(disciplina);
		ExcecoesProjetos.validaPeriodo(periodoLetivo);
		
		this.rendimento = rendimento;
		this.discEspec = disciplina;
		this.periodoLetivo = periodoLetivo;
	}

	public String getDiscEspec() {
		return discEspec;
	}

	public void setDiscEspec(String discEspec) {
		this.discEspec = discEspec;
	}

	public String getPeriodoLetivo() {
		return periodoLetivo;
	}

	public void setPeriodoLetivo(String periodoLetivo) {
		this.periodoLetivo = periodoLetivo;
	}

	public int getRendimento() {
		return rendimento;
	}

	public void setRendimento(int rendimento) {
		this.rendimento = rendimento;
	}
	
	
	
}

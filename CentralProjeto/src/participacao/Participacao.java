package participacao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import pessoa.Pessoa;
import projeto.Projeto;
import util.ExcecoesAssociacao;
import util.ExcecoesPessoas;
import util.ExcecoesProjetos;
import util.Util;

/**
 * Participacao
 * Classe que representa uma associação entre uma pessoa e um projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param dataInicio
 *           - data de início da participacao.
 * @param qtdMeses
 *           -  duração em meses da participacao.
 * @param qtdHorasSemanais
 *           -  quantidade de horas semanais a serem dedicadas ao projeto.
 * @param valorHora
 *           - valor da hora para essa participacao.
 * @param cpfpessoa
 *           - cpf unico da pessoa.
 * @param codprojeto
 *           - codigo do projeto.
 */

public abstract class Participacao implements Serializable{

	private Date dataInicio;
	private int qtdMeses;
	private int qtdHorasSemanais;
	private double valorHora;
	private String cpfpessoa;
	private int codprojeto;

	public Participacao(String cpfpessoa, int codprojeto, Date dataInicio, int qtdmeses, int qtdHorasSemanais,
			double valorHora) throws Exception {

		ExcecoesPessoas.validaCpf(cpfpessoa);
		ExcecoesAssociacao.validaQtdMesesHoras(qtdHorasSemanais);
		ExcecoesAssociacao.validaQtdMesesHoras(qtdmeses);
		ExcecoesAssociacao.validaValorHoras(valorHora);

		this.cpfpessoa = cpfpessoa;
		this.codprojeto = codprojeto;
		this.qtdMeses = qtdmeses;
		this.qtdHorasSemanais = qtdHorasSemanais;
		this.valorHora = valorHora;

	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public int getQtdMeses() {
		return qtdMeses;
	}

	public void setQtdMeses(int qtdMeses) {
		this.qtdMeses = qtdMeses;
	}

	public int getQtdHorasSemanais() {
		return qtdHorasSemanais;
	}

	public void setQtdHorasSemanais(int qtdHorasSemanais) {
		this.qtdHorasSemanais = qtdHorasSemanais;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public String getCpfpessoa() {
		return cpfpessoa;
	}

	public void setCpfpessoa(String cpfpessoa) {
		this.cpfpessoa = cpfpessoa;
	}

	public int getCodprojeto() {
		return codprojeto;
	}

	public void setCodprojeto(int codprojeto) {
		this.codprojeto = codprojeto;
	}

}

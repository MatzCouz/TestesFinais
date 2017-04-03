package projeto;

import java.io.Serializable;

/**
 * Projeto.
 * Classe que representa o objeto projeto na central de projetos.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param nome
 *           - nome do projeto.
 * @param objetivo
 *            - objetivo do projeto.
 * @param data
 *            - data de inicio do projeto.
 * @param duracao
 *            - duração do projeto(em meses).   
 * @param colecaoParticipantes
 *            - coleção de pessoas que armazena os participantes do projeto.
 * @param codigo
 *            - codigo do projeto.
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import exception.EntradaInvalidaException;
import exception.StringInvalidaException;
import participacao.Participacao;
import pessoa.Pessoa;
import util.ExcecoesProjetos;
import util.Util;

public abstract class Projeto implements Serializable{
	private String nome;
	private String objetivo;
	private Date data;
	private int duracao;
	private ArrayList<Pessoa> colecaoParticipantes;
	private int codigo;
	private Despesas despesas;
	private String coordenador;

	public Projeto(int codigo, String nome, String objetivo, Date data, int duracao) throws EntradaInvalidaException, StringInvalidaException {

		ExcecoesProjetos.validaNome(nome);
		ExcecoesProjetos.validaDuracao(duracao);
		ExcecoesProjetos.validaObjetivo(objetivo);

		this.nome = nome;
		this.objetivo = objetivo;
		this.data = data;
		this.duracao = duracao;
		this.codigo = codigo;
		colecaoParticipantes = new ArrayList<>();
		this.despesas = new Despesas();
		this.coordenador = "";
	}
	
	public Despesas getDespesas() {
		return despesas;
	}


	public void setDespesas(Despesas despesas) {
		this.despesas = despesas;
	}



	public String getNomesParticipacao() {
		if (colecaoParticipantes.size() == 0) {
			return "";
		}
		Collections.sort(colecaoParticipantes, new Comparator<Pessoa>() {
			public int compare(Pessoa p1, Pessoa p2) {
				return p1.getNome().compareTo(p2.getNome());
			}
		});
		String aux = "";
		for (int i = 0; i < colecaoParticipantes.size(); i++) {
			aux += colecaoParticipantes.get(i).getNome() + ", ";
		}
		return aux.substring(0, aux.length() - 2);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void adicionaParticipante(String cpf, Pessoa participacao) {
		colecaoParticipantes.add(participacao);
	}

	public void removeParticipante(String cpf) {
		for (int i = 0; i < colecaoParticipantes.size(); i++) {
			if (colecaoParticipantes.get(i).getCpf().equals(cpf)) {
				colecaoParticipantes.remove(i);
			}
		}
	}

	public boolean verificaParticipacao(String cpf) {
		for (int i = 0; i < colecaoParticipantes.size(); i++) {
			if (colecaoParticipantes.get(i).getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Pessoa> getColecaoParticipantes() {
		return colecaoParticipantes;
	}
	
	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (duracao != other.duracao)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}

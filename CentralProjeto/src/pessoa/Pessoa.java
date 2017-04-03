package pessoa;

import java.io.Serializable;

/**
 * Pessoa.
 * Classe que representa o objeto pessoa na central de projetos.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param nome
 *           - nome da pessoa.
 * @param cpf
 *            -cpf unico da pessoa
 * @param email
 *            - email da pessoa.
 * @param colecaoParticipacoesProjetos
 *            -  colecao que armazena as participacoes de pessoa.           
 */

import java.util.ArrayList;
import java.util.HashMap;

import exception.CpfInvalidoException;
import exception.EntradaInvalidaException;
import exception.StringInvalidaException;
import participacao.Participacao;
import projeto.Projeto;
import util.ExcecoesAssociacao;
import util.ExcecoesPessoas;
import util.Util;

public class Pessoa implements Serializable{
	private String cpf;
	private String nome;
	private String email;
	private ArrayList<Projeto> colecaoParticipacoesProjetos;
	
	public Pessoa(String cpf, String nome, String email) throws EntradaInvalidaException, CpfInvalidoException, StringInvalidaException{
		
		ExcecoesPessoas.validaCpf(cpf);
		ExcecoesPessoas.validaEmail(email);
		ExcecoesPessoas.validaAtributo(nome);
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		colecaoParticipacoesProjetos = new ArrayList<>();
	}
	
	
	public String getNomesParticipacao(){
		String aux = "";
		if(colecaoParticipacoesProjetos.size() == 0){
			return "";
		}
		for(int i=0; i<colecaoParticipacoesProjetos.size(); i++){
			aux += colecaoParticipacoesProjetos.get(i).getNome()+", ";
		}
		return aux.substring(0, aux.length()-2);
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String pessoa) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void adicionaParticipacao(int codigo, Projeto participacao){
		colecaoParticipacoesProjetos.add(participacao);
	}
	public boolean removeParticipacao(int codigo) throws Exception{
		for(int i=0; i<colecaoParticipacoesProjetos.size(); i++){
			if(colecaoParticipacoesProjetos.get(i).getCodigo() == codigo){
				colecaoParticipacoesProjetos.remove(i);
				return true;
			}
		}
		throw new Exception(ExcecoesAssociacao.ERRO_PARTICIPACAO_PROJETO);
	}
	public ArrayList<Projeto> getColecaoParticipacoes() {
		return colecaoParticipacoesProjetos;
	}

	public void setColecaoParticipacoes(ArrayList<Projeto> colecaoParticipacoes) {
		this.colecaoParticipacoesProjetos = colecaoParticipacoes;
	}

	@Override
	public String toString() {
		return nome;
	}
	
}

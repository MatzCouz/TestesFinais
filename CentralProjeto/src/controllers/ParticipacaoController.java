package controllers;

import java.util.Date;

import entradaEsaida.FileManager;
import entradaEsaida.GerarRelatorio;
import exception.AssociacaoInvalidaException;
import exception.CpfInvalidoException;
import exception.EntradaInvalidaException;
import exception.OpenSystemException;
import factory.FactoryAssociacao;
import participacao.AlunoGraduando;
import participacao.AlunoPosGraduando;
import participacao.Participacao;
import participacao.Professor;
import participacao.Profissional;
import pessoa.Pessoa;
import projeto.Monitoria;
import projeto.PED;
import projeto.Projeto;
import repository.RepositoryAssociacao;
import repository.RepositoryPessoa;
import repository.RepositoryProjeto;
import util.ExcecoesAssociacao;
import util.ExcecoesPessoas;
import util.ExcecoesProjetos;
import util.Util;

/**
 * ParticipacaoController
 * Classe que gerencia todas as operações envolvendo Participacao.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param repositorypessoa
 *           - variavel que representa a classe RepositoryPessoa.
 * @param repositoryprojeto
 *           - variavel que representa a classe RepositoryProjeto.
 * @param repositoryassociacao
 *           - variavel que representa a classe repositoryassociacao.
 * @param factoryassociacao
 *           - variavel que representa a classe factoryassociacao.
 */

public class ParticipacaoController {
	private RepositoryPessoa repositorypessoa;
	private RepositoryProjeto repositoryprojeto;
	private RepositoryAssociacao repositoryassociacao;
	private FactoryAssociacao factoryassociacao;
	private FileManager manager;
	private GerarRelatorio gerar;
	
	public ParticipacaoController(RepositoryPessoa repositorypessoa, RepositoryProjeto repositoryprojeto){
		this.repositorypessoa = repositorypessoa;
		this.repositoryprojeto = repositoryprojeto;
		this.repositoryassociacao = new RepositoryAssociacao();
		this.factoryassociacao = new FactoryAssociacao();
		this.manager = new FileManager();
		this.gerar = new GerarRelatorio();
	}
	
	/**
     * associaProfessor.
     * Metodo que Associa pessoa e projeto em uma associacao do tipo professor ao projeto.
     *
     * @param cpf
     *            - cpf unico do professor.
     * @param codigo
     *            - codigo do projeto.
     * @param coordenador
     *            - Indica se a participacao do professor e como coordenador ou nao.
     * @param valorHora
     *            - valor da hora para essa participacao.
     * @param qtdHoras
     *            - quantidade de horas semanais a serem dedicadas ao projeto.
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public void associaProfessor(String cpf, int codigo, boolean coordenador, double valorHora, int qtdHoras) throws EntradaInvalidaException{
		try{
			verificaCodigoCpf(cpf, codigo);
			Pessoa pessoa = repositorypessoa.getPessoa(cpf);
			Projeto projeto = repositoryprojeto.getProjeto(codigo);
			ExcecoesAssociacao.validaHoras(qtdHoras);
			ExcecoesAssociacao.validaValorHoras(valorHora);
			if(projeto instanceof Monitoria){verificaValorHoraProfessor(projeto, valorHora);}
			else{ExcecoesAssociacao.validaValorHorasSemMonitoria(valorHora);}
			verificaProfessor(codigo, coordenador);
			adicionaParticipantes(projeto, pessoa);
			Participacao part = factoryassociacao.criaParticipacaoProfessor(cpf, codigo, projeto.getData(), projeto.getDuracao(), qtdHoras, valorHora, coordenador);
			repositoryassociacao.adicionaAssociacao(part);	
			if(coordenador){projeto.setCoordenador(pessoa.getNome());}
		}catch(Exception e){
			throw new EntradaInvalidaException(Util.ERRO_ASSOCIACAO + e.getMessage());
		}
	}
	
	/**
     * associaGraduando.
     * Metodo que Associa pessoa e projeto em uma associacao do tipo AlunoGraduando ao projeto.
     *
     * @param cpf
     *            - cpf unico do aluno.
     * @param codigo
     *            - codigo do projeto.
     * @param valorHora
     *            - valor da hora para essa participacao.
     * @param qtdHoras
     *            - quantidade de horas semanais a serem dedicadas ao projeto.
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public void associaGraduando(String cpf, int codigo, double valorHora, int qtdHoras) throws EntradaInvalidaException{
		try{
			verificaCodigoCpf(cpf, codigo);
			verificaGraduando(codigo);
			verificaParticipacao(codigo, cpf);
			Pessoa pessoa = repositorypessoa.getPessoa(cpf);
			Projeto projeto = repositoryprojeto.getProjeto(codigo);
			adicionaParticipantes(projeto, pessoa);
			Participacao part = factoryassociacao.criaParticipacaoGraduando(cpf, codigo, projeto.getData(), projeto.getDuracao(), qtdHoras, valorHora);
			repositoryassociacao.adicionaAssociacao(part);
		}catch(Exception e){
			throw new EntradaInvalidaException(Util.ERRO_ASSOCIACAO + e.getMessage());
		}
	}
	
	/**
     * associaProfissional.
     * Metodo que Associa pessoa e projeto em uma associacao do tipo Profissional ao projeto.
     *
     * @param cpf
     *            - cpf unico do profissional.
     * @param codigo
     *            - codigo do projeto.
     * @param cargo
     *            - Indica o cargo que o profissional ocupa.
     * @param valorHora
     *            - valor da hora para essa participacao.
     * @param quantHoras
     *            - quantidade de horas semanais a serem dedicadas ao projeto.
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public void associaProfissional(String cpf, int codigo, String cargo, double valorHora, int quantHoras) throws EntradaInvalidaException {
		try{
			verificaCodigoCpf(cpf, codigo);
			Pessoa pessoa = repositorypessoa.getPessoa(cpf);
			Projeto projeto = repositoryprojeto.getProjeto(codigo);
			adicionaParticipantes(projeto, pessoa);
			Participacao part = factoryassociacao.criaParticipacaoProfissional(cpf, codigo, projeto.getData(), projeto.getDuracao(), quantHoras, valorHora, cargo);
			repositoryassociacao.adicionaAssociacao(part);
		}catch(Exception e){
			throw new EntradaInvalidaException(Util.ERRO_ASSOCIACAO + e.getMessage());
		}
	}
	
	/**
     * associaPosGraduando.
     * Metodo que Associa pessoa e projeto em uma associacao do tipo AlunoPosGraduando ao projeto.
     *
     * @param cpf
     *            - cpf unico do aluno.
     * @param codigo
     *            - codigo do projeto.
     * @param nivel
     *            - mostra se o aluno esta vinculado a mestrado ou doutorado.
     * @param valorHora
     *            - valor da hora para essa participacao.
     * @param quantHoras
     *            - quantidade de horas semanais a serem dedicadas ao projeto.
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public void associaPosGraduando(String cpf, int codigo, String nivel, double valorHora, int quantHoras) throws EntradaInvalidaException{
		try{
			verificaCodigoCpf(cpf, codigo);
			Pessoa pessoa = repositorypessoa.getPessoa(cpf);
			Projeto projeto = repositoryprojeto.getProjeto(codigo);
			ExcecoesAssociacao.verificaPosGraduando(projeto);
			adicionaParticipantes(projeto, pessoa);
			Participacao part = factoryassociacao.criaParticipacaoPosGraduando(cpf,codigo,nivel,projeto.getData(),projeto.getDuracao(),quantHoras,valorHora);
			repositoryassociacao.adicionaAssociacao(part);
		}catch(Exception e){
			throw new EntradaInvalidaException(Util.ERRO_ASSOCIACAO + e.getMessage());
		}
	}
	
	/**
     * removeParticipacao.
     * Metodo que remove a participacao da pessoa no projeto.
     *
     * @param cpf
     *            - cpf unico do aluno.
     * @param codigo
     *            - codigo do projeto.
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	public void removeParticipacao(String cpf, int codigo) throws EntradaInvalidaException{
		try{
			ExcecoesPessoas.validaCpf(cpf);
			verificaCodigoCpf(cpf, codigo);
			Pessoa pessoa = repositorypessoa.getPessoa(cpf);
			pessoa.removeParticipacao(codigo);
			Projeto projeto = repositoryprojeto.getProjeto(codigo);
			projeto.removeParticipante(cpf);
			repositoryassociacao.removerParticipacoes(codigo, cpf);
		}catch(Exception e){
			throw new EntradaInvalidaException(Util.ERRO_REMOCAO_PARTICIPACAO + e.getMessage());
		}
	}
	
	/**
     * verificaProfessor
     * Metodo que verifica se tem professor no projeto.
     *
     * @param coordenador
     *            - Indica se a participacao do professor e como coordenador ou nao.
     * @param codigo
     *            - codigo do projeto.
     *            
     * @return - boolean indicando se o professor esta no projeto
     * 
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public boolean verificaProfessor(int codigo, boolean coordenador) throws AssociacaoInvalidaException{
		Projeto projeto = repositoryprojeto.getProjeto(codigo);
		boolean verificaProfessor = repositoryassociacao.getPossuiProfessor(codigo);
		return ExcecoesAssociacao.verificaProfessor(projeto, coordenador, verificaProfessor);
	}
	
	/**
     * verificaGraduando
     * Metodo que verifica se tem aluno granduando no projeto.
     *
     * @param codigo
     *            - codigo do projeto.
     *            
     * @return - boolean indicando se o aluno esta no projeto.
     * 
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public boolean verificaGraduando(int codigo) throws AssociacaoInvalidaException{
		Projeto projeto = repositoryprojeto.getProjeto(codigo);
		boolean verificaGraduando = repositoryassociacao.getPossuiGraduando(codigo);
		if(projeto instanceof PED &&((PED) projeto).getCategoria().equals("COOP")){
			verificaGraduando = false;
		}
		return ExcecoesAssociacao.verificaGraduando(projeto, verificaGraduando);
	}
	
	/**
     * verificaParticipacao
     * Metodo que verifica se existe determinada participacao no projeto.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param codigo
     *            - codigo do projeto.
     *            
     * @return - boolean indicando se a participacao existe.
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public boolean verificaParticipacao(int codigo, String cpf) throws AssociacaoInvalidaException{
		Projeto projeto = repositoryprojeto.getProjeto(codigo);
		return ExcecoesAssociacao.verificaParticipacao(cpf, projeto);
	}
	public boolean verificaValorHoraProfessor(Projeto projeto, double valorHora) throws Exception{
		return ExcecoesAssociacao.verificaValorHoraProfessor(projeto, valorHora);
	}
	
	/**
     * getPontuacaoPessoa.
     * Metodo que pega a pontuacao de uma pessoa especifica em suas devidas associacoes.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     *            
     * @return - Pontuacao de uma pessoa especifica.
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public double getPontuacaoPessoa(String cpf){
		double aux = 0; double pontMonitoria = 0; double pontOutros = 0;
		for(int i=0; i<repositoryassociacao.getAssociacoes().size(); i++){
			if(cpf.equals(repositoryassociacao.getAssociacoes().get(i).getCpfpessoa())){
				Participacao part = repositoryassociacao.getAssociacoes().get(i);
				Projeto projeto = repositoryprojeto.getProjeto(part.getCodprojeto());
				if(part instanceof Professor){
					aux += Util.pontuacaoProfessor(projeto, repositoryassociacao.getQuantidadeAlunosProjeto(part.getCodprojeto()));
				}
				if(part instanceof AlunoGraduando){
					if(projeto instanceof Monitoria){
						pontMonitoria += Util.pontuacaoGraduando(projeto);
					}else{
						pontOutros += Util.pontuacaoGraduando(projeto);
					}
				}
				if(part instanceof Profissional){
					aux += Util.pontuacaoProfissional(projeto, ((Profissional) part).getCargo());
				}
			}
		}
		aux += Util.validaPontuacaoAlunoGraduando(pontMonitoria, pontOutros);
		return aux;
	}
	
	/**
     * getValorBolsa.
     * Metodo que pega o valor total da bolsa de uma pessoa.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     *            
     * @return 
     *            - valor total da bolsa de uma pessoa especifica.
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */

	public double getValorBolsa(String cpf){
		double valorTotal = 0;
		for(int i=0; i<repositoryassociacao.getAssociacoes().size();i++){
			if(cpf.equals(repositoryassociacao.getAssociacoes().get(i).getCpfpessoa())){
				Participacao part = repositoryassociacao.getAssociacoes().get(i);
				valorTotal += retornaValorBolsa(part);
			}
		}
		if(valorTotal < 350){valorTotal = 350;}
		return valorTotal;
	}
	
	public double retornaValorBolsa(Participacao part){
		double aux = part.getValorHora()*part.getQtdHorasSemanais();
		if(part instanceof Professor){
			if(((Professor) part).isCoordenador()){
				aux += aux*0.4;
			}
		}
		if(part instanceof AlunoPosGraduando){
			if(((AlunoPosGraduando) part).getNivel().equals("Doutorado")){
				aux += aux/3;
			}
		}
		if(part instanceof Profissional){
			if(((Profissional) part).getCargo().equals("Pesquisador")){
				aux += 100;
			}
			if(((Profissional) part).getCargo().equals("Gerente")){
				int x = repositoryassociacao.getQuantidadeParticipantes(part.getCodprojeto());
				aux += 20*x;
			}
		}
		return aux;
	}
	

	/**
     * verificaCodigoCpf
     * Metodo que verifica se existe projeto e se existe pessoa.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param codigo
     *            - codigo do projeto.
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public void verificaCodigoCpf(String cpf, int codigo) throws EntradaInvalidaException{
		if(!repositoryprojeto.verificaProjetoCadastrado(codigo)) throw new EntradaInvalidaException(ExcecoesProjetos.ERRO_PROJETO_INEXISTENTE);
		if(!repositorypessoa.verificaCpfCadastrado(cpf)) throw new EntradaInvalidaException(ExcecoesPessoas.ERRO_PESSOA_INEXISTENTE);
	}
	
	public void adicionaParticipantes(Projeto projeto, Pessoa pessoa){
		pessoa.adicionaParticipacao(projeto.getCodigo(), projeto);
		projeto.adicionaParticipante(pessoa.getCpf(), pessoa);
	}
	
		
	public void iniciaSistema() throws OpenSystemException{
		RepositoryAssociacao carregarAssociacoes;
		if(manager.existeBackup("Associacoes")){
			try{
				carregarAssociacoes = this.manager.importarAssociacoes();
			}catch(Exception e){
				throw new OpenSystemException(e.getMessage());
			}
			repositoryassociacao = carregarAssociacoes;
		}
	}
	
	public void fechaSistema() throws Exception{
		this.manager.exportarAssociacao(this.repositoryassociacao);
		gerar.getTotalGraduando(repositoryassociacao.getQuantidadeGraduando());
		gerar.getTotalPosGraduando(repositoryassociacao.getQuantidadePosGraduando());
		gerar.getTotalProfissionais(repositoryassociacao.getQuantidadeProfissinal());
	}


}

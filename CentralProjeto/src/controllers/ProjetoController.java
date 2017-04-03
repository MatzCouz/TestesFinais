package controllers;

import java.io.ObjectInputValidation;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import entradaEsaida.FileManager;
import entradaEsaida.GerarRelatorio;
import exception.EntradaInvalidaException;
import exception.OpenSystemException;
import exception.ProjetoInvalidoException;
import exception.StringInvalidaException;
import factory.FactoryProjeto;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import repository.RepositoryPessoa;
import repository.RepositoryProjeto;
import util.ExcecoesProjetos;
import util.Util;

/**
 * ProjetoController. 
 * Classe que gerencia todas as operações envolvendo Projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param repositoryprojeto
 *            - variavel que representa a classe RepositoryProjeto.
 * @param factoryProjeto
 *            - variavel que representa a classe FactoryProjeto.
 */

public class ProjetoController {

	private FactoryProjeto factoryProjeto;
	private RepositoryProjeto repositoryProjeto;
	private double diminuirReceita;
	private GerarRelatorio gerarReceita;
	private ArrayList<Projeto> projetosInseridos;
	private double valorTotalFundos;
	private boolean novoValor;
	private FileManager manager;

	public ProjetoController() {
		this.factoryProjeto = new FactoryProjeto();
		this.repositoryProjeto = new RepositoryProjeto();
		this.diminuirReceita = 0;
		this.gerarReceita = new GerarRelatorio();
		this.projetosInseridos = new ArrayList<>();
		valorTotalFundos = 0;
		novoValor = true;
		this.manager = new FileManager();
	}

	public RepositoryProjeto getRepository() {
		return repositoryProjeto;
	}

	/**
	 * adicionaMonitoria.
	 * Metodo que adiciona um novo projeto do tipo Monitoria.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param disciplina
	 *            - disciplina especifica a que esta direcionado.
	 * @param rendimento
	 *            - expectativa de aprovacao na disciplina.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param periodo
	 *            - periodo letivo em que ocorreu.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return - codigo do projeto de monitoria adicionado
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public int adicionaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo,
			Date data, int duracao) throws ProjetoInvalidoException {
		try {
			Projeto projeto = factoryProjeto.criaMonitoria(nome, disciplina, rendimento, objetivo, periodo, data,
					duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			projetosInseridos.add(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}

	/**
	 * adicionaPET.
	 * Metodo que adiciona um novo projeto do tipo PET.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param impacto
	 *            - impacto social.
	 * @param rendimento
	 *            - expectativa de aprovacao na disciplina.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param prodTecnica
	 *            - quantidade de produtividade do tipo tecnica.
	 * @param prodAcademica
	 *            - quantidade de produtividade do tipo academica.
	 * @param patentes
	 *            - quantidade de produtividade do tipo patente.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return
	 *  		  - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public int adicionaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica,
			int prodAcademica, int patentes, Date data, int duracao) throws ProjetoInvalidoException {
		try {
			Projeto projeto = factoryProjeto.criaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica,
					patentes, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			projetosInseridos.add(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	/**
	 * adicionaPED. 
	 * Metodo que adiciona um novo projeto do tipo PED.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param categoria
	 *            - modalidades do projeto de P&D.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param prodTecnica
	 *            - quantidade de produtividade do tipo tecnica.
	 * @param prodAcademica
	 *            - quantidade de produtividade do tipo academica.
	 * @param patentes
	 *            - quantidade de produtividade do tipo patente.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return
	 *            - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *            - excecao lancada caso ocorra algum erro.
	 */

	public int adicionaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes,
			String objetivo, Date data, int duracao) throws ProjetoInvalidoException {
		try {
			Projeto projeto = factoryProjeto.criaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo,
					data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			projetosInseridos.add(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}

	/**
	 * adicionaExtensao.
	 * Metodo que adiciona um novo projeto do tipo Extensao.
	 *
	 * @param nome
	 *            - nome do projeto.
	 * @param impacto
	 *            - impacto social.
	 * @param objetivo
	 *            - objetivo do projeto.
	 * @param data
	 *            - data de inicio do projeto.
	 * @param duracao
	 *            - duracao do projeto(em meses).
	 *
	 * @return 
	 *            - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, Date data, int duracao)
			throws ProjetoInvalidoException {
		try {
			Projeto projeto = factoryProjeto.criaExtensao(nome, objetivo, impacto, data, duracao);
			repositoryProjeto.adicionarProjeto(projeto);
			projetosInseridos.add(projeto);
			return projeto.getCodigo();
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CADASTRAR_PROJETO + e.getMessage());
		}
	}
	
	/**
     * atualizaProjeto.
     * Metodo que atualiza as informacoes de um Projeto.
     *
     * @param codigo
     *            - codigo do projeto.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public void atualizaProjeto(int codigo, String atributo, String valor) throws EntradaInvalidaException {
		try {
			if (atributo.equals("Data de Inicio")) {
				ExcecoesProjetos.validaDia(valor);
			}
			if (atributo.equals("Objetivo")) {
				ExcecoesProjetos.validaObjetivoAtualizacao(valor);
			}
			ExcecoesProjetos.validaAtualizacao(valor);
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			alteraAtributo(projeto, atributo, valor);
		} catch (Exception e) {
			throw new EntradaInvalidaException(Util.ERRO_ATUALIZAO_PROJETO + e.getMessage());
		}
	}
	
	/**
     * alterarAtributo.
     * Metodo que altera dados de um Projeto.
     *
     * @param projeto
     *            - projeto a ser alterado.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */

	private void alteraAtributo(Projeto projeto, String atributo, String valor) throws StringInvalidaException {

		if (projeto instanceof PET) {
			projeto = (PET) (projeto);
			Util.alteraAtributoPET((PET) projeto, atributo, valor);
		} else if (projeto instanceof Extensao) {
			projeto = (Extensao) (projeto);
			Util.alteraAtributoExtensao((Extensao) projeto, atributo, valor);
		}
		if (projeto instanceof PED) {
			projeto = (PED) (projeto);
			Util.alteraAtributoPED((PED) projeto, atributo, valor);
		} else if (projeto instanceof Monitoria) {
			projeto = (Monitoria) (projeto);
			Util.alteraAtributoMonitoria((Monitoria) projeto, atributo, valor);
		}
	}
	
	/**
     * getInfoProjeto.
     * Metodo que pesquisa uma determinada informacao sobre um projeto.
     *
     * @param codigo
     *            - codigo do projeto.
     * @param atributo
     *            - atributo para atualizar o projeto.
     *
     * @return
     * 			  - informacao que foi pesquisada.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */

	public String getInfoProjeto(int codigo, String atributo) throws ProjetoInvalidoException {
		try {
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			ExcecoesProjetos.validaProjeto(projeto);
			if (Util.checarAtributoProjeto(atributo)) {
				throw new Exception(ExcecoesProjetos.ERRO_ATRIBUTO_INVALIDO);
			}
			if (projeto instanceof Monitoria) {
				projeto = (Monitoria) (projeto);
				return Util.retornaAtributoMonitoria((Monitoria) projeto, atributo);
			}
			if (projeto instanceof Extensao) {
				projeto = (Extensao) (projeto);
				return Util.retornaAtributoExtensao((Extensao) projeto, atributo);
			}
			if (projeto instanceof PED) {
				projeto = (PED) (projeto);
				return Util.retornaAtributoPED((PED) projeto, atributo);
			}
			if (projeto instanceof PET) {
				projeto = (PET) (projeto);
				return Util.retornaAtributoPET((PET) projeto, atributo);
			}
			return "";
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CONSULTA_PROJETO + e.getMessage());
		}

	}
	
	/**
     * getCodigoProjeto.
     * Metodo que pesquisa o codigo de um projeto.
     *
     * @param nome
     *            - nome do projeto.
     *
     * @return
     * 			  - codigo do projeto pesquisado.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */

	public int getCodigoProjeto(String nome) throws EntradaInvalidaException {
		try {
			ExcecoesProjetos.validaNome(nome);
			if (repositoryProjeto.getCodigoProjeto(nome) == -1) {
				throw new Exception(ExcecoesProjetos.ERRO_PROJETO_INEXISTENTE);
			}
			return repositoryProjeto.getCodigoProjeto(nome);
		} catch (Exception e) {
			throw new EntradaInvalidaException(Util.ERRO_OBTENCAO_CODIGO + e.getMessage());
		}
	}

	/**
     * removeProjeto.
     * Metodo que remove um projeto do sitema.
     *
     * @param codigo
     *            - codigo do projeto.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public void removeProjeto(int codigo) throws ProjetoInvalidoException {
		try {
			Projeto projeto = repositoryProjeto.getProjeto(codigo);
			ExcecoesProjetos.validaProjeto(projeto);
			repositoryProjeto.removerProjeto(codigo);
		} catch (Exception e) {
			throw new ProjetoInvalidoException(Util.ERRO_CONSULTA_PROJETO + e.getMessage());
		}
	}
	
	/**
	 * atualizaDespesas.
	 * Metodo que atribui valores para as despesas do projeto.
	 *
	 * @param codigo
	 *            - codigo do projeto do projeto.
	 * @param montanteBolsas
	 *            - Valor referente as Bolsas.
	 * @param montanteCusteio
	 *            - Valor referente ao custeio.
	 * @param montanteCapital
	 *            - Valor Referente ao capital.
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public void atualizaDespesas(String codigo, double montanteBolsas, double montanteCusteio, double montanteCapital) throws ProjetoInvalidoException{
		try{
			ExcecoesProjetos.validaCodigo(codigo);
			Projeto projeto = repositoryProjeto.getProjeto(Integer.parseInt(codigo));
			ExcecoesProjetos.validaProjeto(projeto);
			ExcecoesProjetos.validaValoresMonitoriaPET(projeto, montanteBolsas, montanteCusteio, montanteCapital);
			projeto.getDespesas().setMontanteBolsas(montanteBolsas);
			projeto.getDespesas().setMontanteCapital(montanteCapital);
			projeto.getDespesas().setMontanteCusteio(montanteCusteio);
			novoValor = true;
		}catch(Exception e){
			throw new ProjetoInvalidoException(Util.ERRO_ATUALIZAO_PROJETO + e.getMessage());
		}
	}
	
	/**
	 * calculaColaboracao.
	 * Metodo que calcula a colaboracao do projeto.
	 *
	 * @param codigo
	 *            - codigo do projeto.
	 * @return 
	 *            - Valor da colaboracao.
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public double calculaColaboracao(String codigo) throws ProjetoInvalidoException{
		try{
			ExcecoesProjetos.validaCodigo(codigo);
			Projeto projeto = repositoryProjeto.getProjeto(Integer.parseInt(codigo));
			if((projetoIsento(projeto))){ return 0; }
			double aux = 0.1;
			if(projeto instanceof Extensao){
				aux -= 0.005*((Extensao) projeto).getImpacto();
			}
			if(projeto instanceof PED){
				if(((PED) projeto).getPatentes() > 0){
					aux += 0.03;
				}
				if(((PED) projeto).getProdTecnica() > 0){
					aux += ((PED) projeto).getProdTecnica() * 0.003;
				}
				if(((PED) projeto).getProdAcademica() > 0){
					aux -= ((PED) projeto).getProdAcademica() * 0.002;
				}
				if(projeto.getDespesas().getMontanteCapital() > 100000){
					aux += ((int)(projeto.getDespesas().getMontanteCapital()/100000)) * 0.01;
				}
			}
			return projeto.getDespesas().getValorTotal()*aux;
		}catch(Exception e){
			throw new ProjetoInvalidoException(Util.ERRO_CONSULTA_PROJETO + e.getMessage());
		}
	}
	
	/**
	 * totalValorColaboracao.
	 * Metodo que calcula o valor de todas as colaboracoes.
	 * 
	 * @return 
	 *            - Valor total das colaboracoes.
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */
	
	public double totalValorColaboracao() throws ProjetoInvalidoException{
		double aux = 0;
		for(Projeto projeto : repositoryProjeto.getProjetos().values()){
			String auxCod = String.valueOf(projeto.getCodigo());
			aux += calculaColaboracao(auxCod);
			if(novoValor){
				gerarReceita.getColaboracoes(projeto, calculaColaboracao(auxCod));
			}
		}
		if(novoValor){	
			valorTotalFundos = aux;
			novoValor = false;
		}
		return aux;
	}
	/**
	 * projetoIsento.
	 * Metodo que verifica se o projeto e isento.
	 *
	 * @param projeto
	 *            - projeto a ser verificado.
	 * @return 
	 *            - Indicacao se o projeto e isento ou nao.
	 */
	
	private boolean projetoIsento(Projeto projeto){
		if(projeto.getDespesas().getMontanteCapital() <= 10.000 && projeto.getDespesas().getMontanteCusteio() <= 10000){
			return true;
		}else if(projeto instanceof PET || projeto instanceof Monitoria){
			return true;
		}else{
			return false;
		}
	}
	
	
	public double totalValorCaixa(){
		return valorTotalFundos;
	}	
	
	/**
	 * setDiminuirReceita.
	 * Metodo que retira um determinado valor da receita.
	 *
	 * @param diminuirReceita
	 *            - valor a ser retirado.
	 */
	
	public void setDiminuirReceita(double diminuirReceita) throws EntradaInvalidaException {
		try{
			ExcecoesProjetos.validaValores(diminuirReceita);
			ExcecoesProjetos.validaFundos(valorTotalFundos, diminuirReceita);
			valorTotalFundos -= diminuirReceita;
		}catch(Exception e){
			throw new EntradaInvalidaException(Util.ERRO_ATUALIZACAO_RECEITA + e.getMessage());
		}
	}
	
	public void atualizarCadastrosReceita(){
		gerarReceita.setTotalProjetos(projetosInseridos.size());
		for(int i = 0; i<projetosInseridos.size(); i++){
			Projeto projeto = projetosInseridos.get(i);
			gerarReceita.getAtualizaProjetos(i+1, projeto);
		}
	}	


	public void iniciaSistema() throws OpenSystemException{
		RepositoryProjeto carregarProjetos;
		if(manager.existeBackup("Projeto")){
			try{
				carregarProjetos = this.manager.importarProjetos();
			}catch(Exception e){
				throw new OpenSystemException(e.getMessage());
			}
			repositoryProjeto = carregarProjetos;
		}
	}
	
	public void fechaSistema() throws Exception{
		this.manager.exportarProjeto(this.repositoryProjeto);
	}
	
}

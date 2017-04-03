package util;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import exception.CpfInvalidoException;
import exception.EntradaInvalidaException;
import exception.PessoaInvalidaException;
import exception.StringInvalidaException;
import pessoa.Pessoa;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import repository.RepositoryProjeto;

/**
 * Util.
 * Classe utilitaria e estatica que auxilia os controllers realizando operacoes mais simples.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo          
 */

public class Util {
	public static final String ERRO_NOME_NULO_VAZIO = "Nome nulo ou vazio";
	public static final String ERRO_CADASTRAR_PESSOA = "Erro no cadastro de pessoa: ";
	public static final String ERRO_INT_DOUBLE = "Valor invalido";
	public static final String ERRO_ATUALIZACAO_PESSOA = "Erro na atualizacao de pessoa: ";
	public static final String ERRO_CONSULTA_PESSOA  = "Erro na consulta de pessoa: ";
	public static final String ERRO_CADASTRAR_PROJETO = "Erro no cadastro de projeto: ";
	public static final String ERRO_CONSULTA_PROJETO = "Erro na consulta de projeto: ";
	public static final String ERRO_CADASTRO_PESSOA = "Erro no cadastro de pessoa: ";
	public static final String ERRO_ATUALIZAO_PROJETO = "Erro na atualizacao de projeto: ";
	public static final String ERRO_NAO_PODE_SER = " nao pode ser vazio ou nulo";
	public static final String ERRO_OBTENCAO_CODIGO = "Erro na obtencao de codigo de projeto: ";
	public static final String ERRO_ASSOCIACAO = "Erro na associacao de pessoa a projeto: ";
	public static final String ERRO_REMOCAO_PARTICIPACAO = "Erro na remocao de participacao: ";
	private static final String ERRO_MONITORIA_CONSULTA = "Monitoria nao possui ";
	private static final String ERRO_PED_CONSULTA = "PED nao possui ";
	private static final String ERRO_EXTENSAO_CONSULTA = "Extensao nao possui ";
	private static final String ERRO_PET_CONSULTA = "PET nao possui ";
	public static final String ERRO_ATUALIZACAO_RECEITA = "Erro na atualizacao da receita da unidade: ";

	private Util(){}

	
	public static boolean validaData(Calendar data){
		if(data == null){
			return false;
		}
			return true;
	}
	
	/**
	 * listaAtributosInteiros.
	 * Metodo que possui uma lista de atributos inteiros que 
	 * serão comparados com o atributo passado no método.
	 * 
	 * @return
	 * 		- lista com os atributos
	 */
	
	public static String[] listaAtributosInteiros(){
		String[] listaAtributosInterios = {"Duracao", "Rendimento", "Impacto", "prodTecnica", "prodAcademica","Patentes"};
		return listaAtributosInterios;
	}
	
	/**
	 * listaAtributosProjetos.
	 * Metodo que possui uma Lista de atributos de todos os tipos de projeto
	 * que será utilizada como comparação para validação 
	 * do atributo passado no método de alteração, retorno.
	 * 
	 * @return
	 * 		- lista com os atributos
	 */
	
	public static String[] listaAtributosProjetos(){
		String[] listaAtributosProjetos = {"Nome","Objetivo","Disciplina","Periodo","Participacoes","Duracao","Rendimento",
		"Impacto", "Producao tecnica", "Producao academica", "Patentes", "Data de inicio"};
		return listaAtributosProjetos;
	}
	
	public static boolean checarAtributoProjeto(String atributo){
		for(int i=0; i<listaAtributosProjetos().length; i++){
			if(atributo.equals(listaAtributosProjetos()[i])){
				return false;
			}
		}
				return true;
	}
	
	/**
     * alteraAtributoPED.
     * Metodo que altera o respectivo atributo do projeto PED com o valor passado.
     *
     * @param projeto
     *            - projeto a ser alterado.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     */
	
	public static void alteraAtributoPED(PED projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("prodTecnica")){
			projeto.setProdTecnica(aux);
		}
		if(atributo.equalsIgnoreCase("prodAcademica")){
			projeto.setProdAcademica(aux);
		}
		if(atributo.equalsIgnoreCase("patentes")){
			projeto.setPatentes(aux);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
	}
	
	/**
     * alteraAtributoPET.
     * Metodo que altera o respectivo atributo do projeto PET com o valor passado.
     *
     * @param projeto
     *            - projeto a ser alterado.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     */
	
	public static void alteraAtributoPET(PET projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			projeto.setRendimento(aux);
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			projeto.setImpacto(aux);
		}
		if(atributo.equalsIgnoreCase("prodTecnica")){
			projeto.setProdTecnica(aux);
		}
		if(atributo.equalsIgnoreCase("prodAcademica")){
			projeto.setProdAcademica(aux);
		}
		if(atributo.equalsIgnoreCase("patentes")){
			projeto.setPatentes(aux);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
	}
	
	/**
     * alteraAtributoMonitoria.
     * Metodo que altera o respectivo atributo do projeto Monitoria com o valor passado.
     *
     * @param projeto
     *            - projeto a ser alterado.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     */
	
	public static void alteraAtributoMonitoria(Monitoria projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
		if(atributo.equalsIgnoreCase("Disciplina")){
			projeto.setDiscEspec(valor);
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			projeto.setRendimento(aux);
		}
		if(atributo.equalsIgnoreCase("Periodo")){
			projeto.setPeriodoLetivo(valor);
		}
	}
	
	/**
     * alteraAtributoExtensao.
     * Metodo que altera o respectivo atributo do projeto Extensao com o valor passado.
     *
     * @param projeto
     *            - projeto a ser alterado.
     * @param atributo
     *            - atributo para atualizar o projeto.
     * @param valor
     *            - valor para atualizar o projeto.
     */
	
	public static void alteraAtributoExtensao(Extensao projeto, String atributo, String valor){
		int aux = 0;
		if(checarValorInteiro(atributo)){ aux = Integer.parseInt(valor);}
		if(atributo.equalsIgnoreCase("Nome")){
			projeto.setNome(valor);
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			projeto.setObjetivo(valor);
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			projeto.setImpacto(aux);
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			projeto.setDuracao(aux);
		}
	}
	
	private static boolean checarValorInteiro(String atributo){
		String[] lista = Util.listaAtributosInteiros();
		for(int i = 0; i<lista.length; i++){
			if(atributo.equals(lista[i])){
				return true;
			}
		}
			return false;
	}

	/**
     * retornaAtributoMonitoria.
     * Metodo que retorna o respectivo atributo do projeto Monitoria.
     *
     * @param projeto
     *            - projeto a ser pesquisado.
     * @param atributo
     *            - atributo passado como parametro.
     * @return 
     *            - atributo pesquisado
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.           
     */
	
	public static String retornaAtributoMonitoria(Monitoria projeto, String atributo) throws Exception {
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Disciplina")){
			return projeto.getDiscEspec();
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			return Integer.toString(projeto.getRendimento());
		}
		if(atributo.equalsIgnoreCase("Periodo")){
			return projeto.getPeriodoLetivo();
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_MONITORIA_CONSULTA + atributo);
	}

	/**
     * retornaAtributoExtensao.
     * Metodo que retorna o respectivo atributo do projeto Extensao.
     *
     * @param projeto
     *            - projeto a ser pesquisado.
     * @param atributo
     *            - atributo passado como parametro.
     * @return 
     *            - atributo pesquisado
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.           
     */
	
	public static String retornaAtributoExtensao(Extensao projeto, String atributo) throws Exception{
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			return Integer.toString(projeto.getImpacto());
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_EXTENSAO_CONSULTA + atributo);
	}

	/**
     * retornaAtributoPED.
     * Metodo que retorna o respectivo atributo do projeto PED.
     *
     * @param projeto
     *            - projeto a ser pesquisado.
     * @param atributo
     *            - atributo passado como parametro.
     * @return 
     *            - atributo pesquisado
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.           
     */
	
	public static String retornaAtributoPED(PED projeto, String atributo) throws Exception {
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("prodTecnica") || atributo.equalsIgnoreCase("Producao tecnica")){
			return Integer.toString(projeto.getProdTecnica());
		}
		if(atributo.equalsIgnoreCase("prodAcademica") || atributo.equalsIgnoreCase("Producao academica")){
			return Integer.toString(projeto.getProdAcademica());
		}
		if(atributo.equalsIgnoreCase("patentes")){
			return Integer.toString(projeto.getPatentes());
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_PED_CONSULTA + atributo);
	}

	/**
     * retornaAtributoPET.
     * Metodo que retorna o respectivo atributo do projeto PET.
     *
     * @param projeto
     *            - projeto a ser pesquisado.
     * @param atributo
     *            - atributo passado como parametro.
     * @return 
     *            - atributo pesquisado
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.           
     */
	
	public static String retornaAtributoPET(PET projeto, String atributo) throws Exception {
		if(atributo.equalsIgnoreCase("Nome")){
			return projeto.getNome();
		}
		if(atributo.equalsIgnoreCase("Objetivo")){
			return projeto.getObjetivo();
		}
		if(atributo.equalsIgnoreCase("Rendimento")){
			return Integer.toString(projeto.getRendimento());
		}
		if(atributo.equalsIgnoreCase("Impacto")){
			return Integer.toString(projeto.getImpacto());
		}
		if(atributo.equalsIgnoreCase("prodTecnica") || atributo.equalsIgnoreCase("Producao tecnica")){
			return Integer.toString(projeto.getProdTecnica());
		}
		if(atributo.equalsIgnoreCase("prodAcademica") || atributo.equalsIgnoreCase("Producao academica")){
			return Integer.toString(projeto.getProdAcademica());
		}
		if(atributo.equalsIgnoreCase("patentes")){
			return Integer.toString(projeto.getPatentes());
		}
		if(atributo.equalsIgnoreCase("Duracao")){
			return Integer.toString(projeto.getDuracao());
		}
		if(atributo.equalsIgnoreCase("Data") || atributo.equalsIgnoreCase("Data de inicio")){
			SimpleDateFormat aux = new SimpleDateFormat("dd/MM/yyyy");
			return aux.format(projeto.getData());
		}
		if(atributo.equals("Participacoes")){
			return projeto.getNomesParticipacao();
		}
			throw new Exception(ERRO_PET_CONSULTA + atributo);
	}
	
	public static boolean verificarCategoriasPED(String categoria) throws Exception{
		String[] categorias = {"PIBITI", "PIBIT", "PIVIC", "COOP"};
		for(int i = 0; i<categorias.length; i++){
			if(categoria.equals(categorias[i])){
				return true;
			}
		}
			throw new Exception(ExcecoesProjetos.ERRO_CATEGORIA_INVALIDA);
	}
	
	/**
     * pontuacaoProfessor.
     * Metodo que retorna pontuação da associação de professor.
     *
     * @param projeto
     *            - projeto a ser pontuado.
     * @param quantidade
     *            - pontos a serem adicionados.
     * @return
     *             - pontuacao do professor.           
     */
	
	public static double pontuacaoProfessor(Projeto projeto, int quantidade){
		double aux = 0;
		if(projeto.getDuracao() >= 12){
			aux = 4*((int)(projeto.getDuracao() / 12));
		}
		if(projeto instanceof Monitoria){
			return aux;
		}
		aux += quantidade;
		return aux;
	}
	
	/**
     * pontuacaoProfessor.
     * Metodo que retorna pontuação da associação de aluno graduando.
     *
     * @param projeto
     *            - projeto a ser pontuado.
     * @param quantidade
     *            - pontos a serem adicionados.
     *            
     * @return
     *             - pontuacao do aluno.           
     */
	
	public static double pontuacaoGraduando(Projeto projeto){
		double aux = 0;
		int x = projeto.getDuracao() / 6;
		if(projeto instanceof Monitoria){
			aux += 1.5;
		}else{
			aux += 2.0;
		}
		return aux*x;
	}
	
	/**
     * pontuacaoProfissional.
     * Metodo que retorna pontuação da associação de profissional.
     *
     * @param projeto
     *            - projeto a ser pontuado.
     * @param quantidade
     *            - pontos a serem adicionados.
     *            
     * @return
     *             - pontuacao do profissional.           
     */
	
	public static double pontuacaoProfissional(Projeto projeto, String cargo){
		double aux = 0;
		int x = (int) (projeto.getDuracao()/12);
		if(x==0){
			return 0;
		}
		if(cargo.equalsIgnoreCase("Desenvolvedor")){
			aux += 5;
		}else if(cargo.equalsIgnoreCase("Gerente")){
			aux += 9;
		}else if(cargo.equalsIgnoreCase("Pesquisador")){
			aux += 6;
		}
		return aux*x;
	}


	public static double validaPontuacaoAlunoGraduando(double pontMonitoria, double pontOutros) {
		double aux = 0;
		if(pontMonitoria > 6){
			aux += 6;
		}else{
			aux += pontMonitoria;
		}
		if(pontOutros > 8){
			aux+=8;
		}else{
			aux += pontOutros;
		}	
		return aux;
	}
	
	public static String alteraData(Projeto projeto){
		SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
		String data = dt.format(projeto.getData());
		return data;
	}
	
	public static boolean comparaDatas(Date date, int duracao){
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String mes = sdf.format(date);
		Date dataatual = new Date();
		String mesatual = sdf.format(dataatual);
		if(Integer.parseInt(mes)+duracao <= Integer.parseInt(mesatual)){
			return true;
		}else{
			return false;
		}
	}
	public static String situacaoProjeto(Date date, int duracao){
		if(comparaDatas(date, duracao)){
			return "Finalizado";
		}else{
			return "Em andamento";
		}
	}

	
}

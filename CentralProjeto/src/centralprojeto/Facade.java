package centralprojeto;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import controllers.ParticipacaoController;
import controllers.PessoaController;
import controllers.ProjetoController;
import easyaccept.EasyAccept;
import entradaEsaida.GerarRelatorio;
import exception.EntradaInvalidaException;
import exception.OpenSystemException;
import exception.ProjetoInvalidoException;
import exception.StringInvalidaException;
import projeto.Projeto; // teste
import repository.RepositoryProjeto;

/**
 * Facade.
 * Classe que e a ultima camada entre usuario e sistema, a façade e
 * responsavel pelo acesso as funcionalidades do sistema de forma simplificada,
 * e no sistema em especifico, e utilizado o easyaccept nela.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param controllerPessoa
 *            - variavel que representa a classe PessoaController.
 * @param controllerProjeto
 *            - variavel que representa a classe ProjetoController.
 * @param controllerParticipacao
 *            - variavel que representa a classe ParticipacaoController.
 */

public class Facade {

	private PessoaController controllerPessoa;
	private ProjetoController controllerProjeto;
	private ParticipacaoController controllerParticipacao;
	private GerarRelatorio gerar; 
	
	public void iniciaSistema() throws OpenSystemException {
		controllerProjeto.iniciaSistema();
		controllerParticipacao.iniciaSistema();
		controllerPessoa.iniciaSistema();
	};

	public void fechaSistema() throws Exception {
		controllerProjeto.atualizarCadastrosReceita();
		controllerProjeto.fechaSistema();
		controllerParticipacao.fechaSistema();
		controllerPessoa.fechaSistema();
		gerar.gerarRelatorioProjetos();
		gerar.gerarRelatorioColaboracoes();
	};

	public Facade() {
		controllerPessoa = new PessoaController();
		controllerProjeto = new ProjetoController();
		controllerParticipacao = new ParticipacaoController(controllerPessoa.getRepository(),
		controllerProjeto.getRepository());
		gerar = new GerarRelatorio();
	}

	/**
     * cadastraPessoa
     * Metodo que cadastra uma nova pessoa.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param nome
     *            - nome da pessoa.
     * @param email
     *            - email da pessoa.
     *
     * @return
     * 			- cpf da pessoa cadastrada.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public String cadastraPessoa(String cpf, String nome, String email) throws Exception {
		return controllerPessoa.cadastraPessoa(cpf, nome, email);
	}

	/**
     * editaPessoa.
     * Metodo que atualiza as informacoes de uma pessoa.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param atributo
     *            - atributo para atualizar a pessoa.
     * @param valor
     *            - valor para atualizar a pessoa.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public void editaPessoa(String cpf, String atributo, String valor) throws Exception {
		controllerPessoa.atualizaPessoa(cpf, atributo, valor);
	}

	/**
     * removePessoa.
     * Metodo que remove a pessoa do sitema.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public void removePessoa(String cpf) throws EntradaInvalidaException {
		controllerPessoa.removePessoa(cpf);
	}

	/**
     * getInfoPessoa.
     * Metodo que exibe um determinado atributo passado como parametro.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     * @param atributo
     *            - atributo a ser pesquisado.
     *
     * @return
     * 			  - resultado da pesquisa do atributo.
     *
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public String getInfoPessoa(String cpf, String atributo) throws Exception {
		return controllerPessoa.mostrarAtributoPessoa(cpf, atributo);
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
			Date data, int duracao) throws Exception {
		return controllerProjeto.adicionaMonitoria(nome, disciplina, rendimento, objetivo, periodo, data, duracao);
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
			int prodAcademica, int patentes, Date data, int duracao) throws Exception {
		return controllerProjeto.adicionaPET(nome, objetivo, impacto, rendimento, prodTecnica, prodAcademica, patentes,
				data, duracao);
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
	
	public int adicionaExtensao(String nome, String objetivo, int impacto, Date data, int duracao) throws Exception {
		return controllerProjeto.adicionaExtensao(nome, objetivo, impacto, data, duracao);
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
			String objetivo, Date data, int duracao) throws Exception {
		return controllerProjeto.adicionaPED(nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, data,
				duracao);
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
	
	public String getInfoProjeto(int codigo, String atributo) throws Exception {
		return controllerProjeto.getInfoProjeto(codigo, atributo);
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
	
	public int getCodigoProjeto(String nome) throws Exception {
		return controllerProjeto.getCodigoProjeto(nome);
	}

	/**
     * editaProjeto.
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
	
	public void editaProjeto(int codigo, String atributo, String valor) throws Exception {
		controllerProjeto.atualizaProjeto(codigo, atributo, valor);
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
	
	public void removeProjeto(int codigo) throws Exception {
		controllerProjeto.removeProjeto(codigo);
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
     * @param qntdHoras
     *            - quantidade de horas semanais a serem dedicadas ao projeto.
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro
     */
	
	public void associaProfessor(String cpf, int codigo, boolean coordenador, double valorHora, int qntHoras)
			throws Exception {
		controllerParticipacao.associaProfessor(cpf, codigo, coordenador, valorHora, qntHoras);
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
     * @param qntdHoras
     *            - quantidade de horas semanais a serem dedicadas ao projeto.
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public void associaGraduando(String cpf, int codigo, double valorHora, int qntHoras) throws Exception {
		controllerParticipacao.associaGraduando(cpf, codigo, valorHora, qntHoras);
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
	
	public void associaProfissional(String cpf, int codigo, String cargo, double valorHora, int quantHoras)
			throws Exception {
		controllerParticipacao.associaProfissional(cpf, codigo, cargo, valorHora, quantHoras);
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
	
	public void associaPosGraduando(String cpf, int codigo, String nivel, double valorHora, int quantHoras)
			throws Exception {
		controllerParticipacao.associaPosGraduando(cpf, codigo, nivel, valorHora, quantHoras);
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
	
	public void removeParticipacao(String cpf, int codigo) throws Exception {
		controllerParticipacao.removeParticipacao(cpf, codigo);
	}

	/**
     * calculaPontuacaoPorParticipacao
     * Metodo que pega a pontuacao de uma pessoa especifica em suas devidas associacoes.
     *
     * @param cpf
     *            - cpf unico da pessoa.
     *            
     * @return
     * 			  - Pontuacao de uma pessoa especifica.
     *            
     * @throws Exception
     *             - excecao lancada caso ocorra algum erro.
     */
	
	public double calculaPontuacaoPorParticipacao(String cpf) {
		return controllerParticipacao.getPontuacaoPessoa(cpf);
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
	
	public double getValorBolsa(String cpf) {
		return controllerParticipacao.getValorBolsa(cpf);
	}
	
	public void atualizaDespesasProjeto(String codigo, double montanteBolsas, double montanteCusteio, double montanteCapital) throws ProjetoInvalidoException{
		controllerProjeto.atualizaDespesas(codigo, montanteBolsas, montanteCusteio, montanteCapital);
	}
	
	public double calculaColaboracaoUASC(String codigo) throws ProjetoInvalidoException{
		return controllerProjeto.calculaColaboracao(codigo);
	}
	
	public double calculaColaboracaoTotalUASC() throws ProjetoInvalidoException{
		return controllerProjeto.totalValorColaboracao();
	}
	
	public void diminuiReceita(double valor) throws EntradaInvalidaException{
		controllerProjeto.setDiminuirReceita(valor);
	}
	
	public double calculaTotalEmCaixaUASC() throws ProjetoInvalidoException, EntradaInvalidaException{
		return controllerProjeto.totalValorCaixa();
	}
	
	public static void main(String[] args) {
		args = new String[] { "centralprojeto.Facade", "acceptance_tests/us1_test.txt",
				"acceptance_tests/us1_test_exception.txt", "acceptance_tests/us2_test.txt",
				"acceptance_tests/us2_test_exception.txt", "acceptance_tests/us3_test.txt",
				"acceptance_tests/us3_test_exception.txt", "acceptance_tests/us4_test.txt",
				"acceptance_tests/us5_test.txt", "acceptance_tests/us6_test.txt",
				"acceptance_tests/us6_test_exception.txt"};
		EasyAccept.main(args);
	}
}

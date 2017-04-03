package factory;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;
import util.ExcecoesProjetos;
import util.Util;

/**
 * FactoryProjeto. 
 * Classe que faz a criacao de novos objetos do tipo projeto.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param cod
 *            - codigo dos projetos.
 */

public class FactoryProjeto {
	private static int cod = 0;

	/**
	 * criaMonitoria. Metodo que cria um novo objeto do tipo Monitoria.
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
	 * @return - objeto criado
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public Projeto criaMonitoria(String nome, String disciplina, int rendimento, String objetivo, String periodo,
			Date data, int duracao) throws Exception {
		cod++;
		Projeto projeto = new Monitoria(cod, nome, disciplina, rendimento, objetivo, periodo, data, duracao);
		return projeto;
	}

	/**
	 * criaPET. Metodo que cria um novo objeto do tipo PET.
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
	 * @return - objeto criado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public Projeto criaPET(String nome, String objetivo, int impacto, int rendimento, int prodTecnica,
			int prodAcademica, int patentes, Date data, int duracao) throws Exception {
		cod++;
		Projeto projeto = new PET(cod, nome, objetivo, patentes, impacto, rendimento, prodTecnica, prodAcademica, data,
				duracao);
		return projeto;
	}

	/**
	 * criaExtensao. Metodo que cria um novo objeto do tipo Extensao.
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
	 * @return - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public Projeto criaExtensao(String nome, String objetivo, int impacto, Date data, int duracao) throws Exception {
		cod++;
		Projeto projeto = new Extensao(cod, nome, objetivo, data, impacto, duracao);
		return projeto;
	}

	/**
	 * criaPED. Metodo que cria um novo objeto do tipo PED.
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
	 * @return - codigo do projeto de monitoria adicionado.
	 *
	 * @throws Exception
	 *             - excecao lancada caso ocorra algum erro.
	 */

	public Projeto criaPED(String nome, String categoria, int prodTecnica, int prodAcademica, int patentes,
			String objetivo, Date data, int duracao) throws Exception {
		cod++;
		Util.verificarCategoriasPED(categoria);
		Projeto projeto = new PED(cod, nome, categoria, prodTecnica, prodAcademica, patentes, objetivo, data, duracao);
		return projeto;
	}
}

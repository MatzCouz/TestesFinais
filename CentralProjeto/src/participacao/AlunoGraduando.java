package participacao;

import java.io.Serializable;
import java.util.Date;

import pessoa.Pessoa;
import projeto.Projeto;

/**
 * AlunoGraduando
 * Classe que representa um Aluno Graduando que e um tipo de participacao.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 */

public class AlunoGraduando extends Participacao implements Serializable {

	public AlunoGraduando(String cpfpessoa, int codprojeto, Date dataInicio, int qtdmeses, int qtdHorasSemanais,
			double valorHora) throws Exception {
		super(cpfpessoa, codprojeto, dataInicio, qtdmeses, qtdHorasSemanais, valorHora);
	}

}

package participacao;

import java.io.Serializable;
import java.util.Date;

import pessoa.Pessoa;
import projeto.Projeto;

/**
 * Professor
 * Classe que representa um Professor que e um tipo de participacao.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param coordenador
 *           - Indica se a participacao do professor e como coordenador ou nao.
 */

public class Professor extends Participacao implements Serializable{
	private boolean coordenador;

	public Professor(String cpfpessoa, int codprojeto, Date dataInicio, int qtdmeses, int qtdHorasSemanais,
			double valorHora, boolean coordenador) throws Exception {
		super(cpfpessoa, codprojeto, dataInicio, qtdmeses, qtdHorasSemanais, valorHora);
		this.coordenador = coordenador;
	}

	public boolean isCoordenador() {
		return coordenador;
	}

	public void setCoordenador(boolean coordenador) {
		this.coordenador = coordenador;
	}

}

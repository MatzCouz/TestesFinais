package participacao;

import java.io.Serializable;
import java.util.Date;

import pessoa.Pessoa;
import projeto.Projeto;

/**
 * Profissional
 * Classe que representa um Profissional que e um tipo de participacao.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param cargo
 *           - Indica o cargo que o profissional ocupa.
 */

public class Profissional extends Participacao implements Serializable{
	private String cargo;

	public Profissional(String cpfpessoa, int codprojeto, Date dataInicio, int qtdmeses, int qtdHorasSemanais,
			double valorHora, String cargo) throws Exception {
		super(cpfpessoa, codprojeto, dataInicio, qtdmeses, qtdHorasSemanais, valorHora);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}

package participacao;

import java.io.Serializable;
import java.util.Date;

/**
 * AlunoPosGraduando
 * Classe que representa um Aluno Pos-Graduando que e um tipo de participacao.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 * 
 * @param nivel
 *           - mostra se o aluno esta vinculado a mestrado ou doutorado.
 */

public class AlunoPosGraduando extends Participacao implements Serializable {
	private String nivel;
	
	public AlunoPosGraduando(String cpfpessoa, int codprojeto, String nivel, Date dataInicio, int qtdmeses, int qtdHorasSemanais,
			double valorHora) throws Exception {
		super(cpfpessoa, codprojeto, dataInicio, qtdmeses, qtdHorasSemanais, valorHora);
		this.nivel = nivel;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
	
}

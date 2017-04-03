package factory;

import java.util.Date;

import participacao.AlunoGraduando;
import participacao.AlunoPosGraduando;
import participacao.Participacao;
import participacao.Professor;
import participacao.Profissional;

public class FactoryAssociacao {

	public Participacao criaParticipacaoProfessor(String cpf, int codigo, Date data, int duracao, int qtdHoras,
			double valorHora, boolean coordenador) throws Exception {
		Participacao part = new Professor(cpf, codigo, data, duracao, qtdHoras, valorHora, coordenador);
		return part;
	}

	public Participacao criaParticipacaoGraduando(String cpf, int codigo, Date data, int duracao, int qtdHoras,
			double valorHora) throws Exception {
		Participacao part = new AlunoGraduando(cpf, codigo, data, duracao, qtdHoras, valorHora);
		return part;
	}

	public Participacao criaParticipacaoProfissional(String cpf, int codigo, Date data, int duracao, int quantHoras,
			double valorHora, String cargo) throws Exception {
		Participacao part = new Profissional(cpf, codigo, data, duracao, quantHoras, valorHora, cargo);
		return part;
	}

	public Participacao criaParticipacaoPosGraduando(String cpf, int codigo, String nivel, Date data, int duracao,
			int quantHoras, double valorHora) throws Exception {
		Participacao part = new AlunoPosGraduando(cpf, codigo, nivel, data, duracao, quantHoras, valorHora);
		return part;
	}
	

}

package util;

import exception.AssociacaoInvalidaException;
import exception.EntradaInvalidaException;
import pessoa.Pessoa;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.Projeto;

/**
 * ExcecoesAssociacao.
 * Classe que faz o tratamento de todas as possiveis excecoes referentes ao pacote de associacoes.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo          
 */

public class ExcecoesAssociacao {
	public static final String ERRO_QUANTIDADE_HORAS = "Quantidade de horas invalida";
	public static final String ERRO_VALOR_HORAS_INVALIDO = "Valor da hora invalido";
	public static final String ERRO_TEM_QUE_SER_ZERO = "Valor de um professor de monitoria deve ser zero";
	public static final String ERRO_MONITORIA_PROFESSOR = "Monitoria nao pode ter mais de um professor";
	private static final String ERRO_PED_PROFESSOR = "Projetos P&D nao podem ter mais de um professor";
	private static final String ERRO_COORDENADOR = "Projetos P&D nao podem ter mais de um coordenador";
	private static final String ERRO_PED_GRADUANDO = "Projetos P&D nao podem ter mais de um graduando";
	private static final String ERRO_VALOR_HORA_PROFESSOR_MONITORIA = "Valor da hora de um professor da monitoria deve ser zero";
	public static final String ERRO_PARTICIPACAO_PROJETO = "Pessoa nao possui participacao no projeto indicado";
	private static final String ERRO_ALUNO_CADASTRADO = "Aluno ja esta cadastrado nesse projeto";
	public static final String ERRO_INT_DOUBLE = "Valor invalido";
	private static final String ERRO_ASSOCIACAO_POSGRADUANDO = "Tipo de projeto invalido para pos graduando";


	public static void validaHoras(int horas) throws EntradaInvalidaException{
		if(horas <= 0){
			throw new EntradaInvalidaException(ERRO_QUANTIDADE_HORAS);
		}
	}
	
	public static void validaQtdMesesHoras(int qtd) throws EntradaInvalidaException{
		if(qtd <= 0){
			throw new EntradaInvalidaException(ERRO_INT_DOUBLE);
		}
	}
	public static void validaValorHoras(double horas) throws EntradaInvalidaException{
		if(horas < 0){
			throw new EntradaInvalidaException(ERRO_VALOR_HORAS_INVALIDO);
		}
	}
	
	public static void validaValorHorasSemMonitoria(double valorHora) throws EntradaInvalidaException{
		if(valorHora <= 0){
			throw new EntradaInvalidaException(ERRO_VALOR_HORAS_INVALIDO);
		}
	}
	
	public static void validaValorHoraProfessor(double horas) throws EntradaInvalidaException{
		if(horas != 0){
			throw new EntradaInvalidaException(ERRO_TEM_QUE_SER_ZERO);
		}
	}
	
	public static boolean verificaProfessor(Projeto projeto, boolean coordenador, boolean verifica) throws AssociacaoInvalidaException{
		if(projeto instanceof Monitoria && verifica == true && coordenador == false){
			throw new AssociacaoInvalidaException(ExcecoesAssociacao.ERRO_MONITORIA_PROFESSOR);
		}
		if(projeto instanceof PED && verifica == true){
			if(coordenador == true){
				throw new AssociacaoInvalidaException(ERRO_COORDENADOR);
			}
			throw new AssociacaoInvalidaException(ERRO_PED_PROFESSOR);
		}
			return true;
	}
	
	public static boolean verificaGraduando(Projeto projeto, boolean verifica) throws AssociacaoInvalidaException{
		if(projeto instanceof PED && verifica == true){
			throw new AssociacaoInvalidaException(ERRO_PED_GRADUANDO);
		}
			return true;
	}

	public static boolean verificaValorHoraProfessor(Projeto projeto, double valorHora) throws EntradaInvalidaException {
		if(projeto instanceof Monitoria && valorHora != 0){
			throw new EntradaInvalidaException(ERRO_VALOR_HORA_PROFESSOR_MONITORIA);
		}
		return true;
	}

	public static boolean verificaParticipacao(String cpf, Projeto projeto) throws AssociacaoInvalidaException {
		if(projeto.verificaParticipacao(cpf)){
			throw new AssociacaoInvalidaException(ERRO_ALUNO_CADASTRADO);
		}
		return true;
	}
	
	public static void verificaPosGraduando(Projeto projeto) throws AssociacaoInvalidaException{
		if(!(projeto instanceof Extensao || projeto instanceof PED)){
			throw new AssociacaoInvalidaException(ERRO_ASSOCIACAO_POSGRADUANDO);
		}
	}
}

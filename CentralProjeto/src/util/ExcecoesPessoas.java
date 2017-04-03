package util;

import exception.CpfInvalidoException;
import exception.EntradaInvalidaException;
import exception.PessoaInvalidaException;
import exception.StringInvalidaException;
import pessoa.Pessoa;

/**
* ExcecoesPessoas.
* Classe que faz o tratamento de todas as possiveis excecoes referentes ao pacote de pessoas.
*
* @author Matheus de Souza Coutinho
* @author Matheus Vasconcelos Figueiredo          
*/

public class ExcecoesPessoas {
	public static final String ERRO_PESSOA_NAO_ENCONTRADA = "Pessoa nao encontrada";
	public static final String ERRO_CPF_CADASTRADO = "Pessoa com mesmo CPF ja cadastrada";
	public static final String ERRO_CPF_NULO_VAZIO = "CPF nulo ou vazio";
	public static final String ERRO_CPF_INVALIDO = "CPF invalido";
	public static final String ERRO_EMAIL_NULO_VAZIO = "Email nulo ou vazio";
	public static final String ERRO_EMAIL_INVALIDO = "Email invalido";
	public static final String ERRO_CPF_NAO_ALTERA = "CPF nao pode ser alterado";
	public static final String ERRO_PESSOA_INEXISTENTE = "Pessoa nao encontrada";
	public static final String ERRO_NOME_NULO_VAZIO = "Nome nulo ou vazio";



	public static void procuraPessoa(Pessoa pessoa) throws PessoaInvalidaException{
		if(pessoa==null){
			throw new PessoaInvalidaException(ERRO_PESSOA_NAO_ENCONTRADA);
		}
	}
	
	public static void cpfJaCadastrado(boolean funcao) throws CpfInvalidoException{
		if(funcao){
			throw new CpfInvalidoException(ERRO_CPF_CADASTRADO);
		}
	}
	
	public static void validaCpf(String cpf) throws CpfInvalidoException {
		if(cpf == null || cpf.trim().isEmpty()){
			throw new CpfInvalidoException(ERRO_CPF_NULO_VAZIO);
		}
		String regex = "[0-9][0-9][0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9][0-9]";
		if(!cpf.matches(regex)){
			throw new CpfInvalidoException(ERRO_CPF_INVALIDO);
		}
	}
	
	public static void validaEmail(String email) throws StringInvalidaException{
		if(email == null || email.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_EMAIL_NULO_VAZIO);
		}
		String regex = "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+(.[A-Za-z]+)*";
		if(!email.matches(regex)){
			throw new StringInvalidaException(ERRO_EMAIL_INVALIDO);
		}
	}

	public static void verificaAtributo(String valor) throws EntradaInvalidaException{
		if(valor.equalsIgnoreCase("cpf")){
			throw new EntradaInvalidaException(ERRO_CPF_NAO_ALTERA);
		}
	}

	public static void validaAtributo(String atributo) throws StringInvalidaException {
		if(atributo == null || atributo.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_NOME_NULO_VAZIO);
		}		
	}

	public static void validaValor(String valor) throws StringInvalidaException {
		if(valor == null || valor.trim().isEmpty()){
			throw new StringInvalidaException(ERRO_NOME_NULO_VAZIO);
		}			
	}
}

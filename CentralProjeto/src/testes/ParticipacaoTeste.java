package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import participacao.AlunoGraduando;
import participacao.Participacao;
import pessoa.Pessoa;
import projeto.PED;

public class ParticipacaoTeste {

	private Participacao participacao;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		participacao = new AlunoGraduando ("123.456.789-19",3,date,6,20,10);

	}
	
	@Test
	public void testConstrutor() {
		
		try {

			participacao = new AlunoGraduando ("123.456.789-19",3,date,6,20,10);

		} catch (Exception e) {
			Assert.fail("Não deveria ser lancada exception nesse caso");
		}
		
		try {

			participacao = new AlunoGraduando (null,3,date,6,20,10);
			Assert.fail("Lancamento de exception com cpf nulo");

		} catch (Exception e) {
			Assert.assertEquals("CPF nulo ou vazio", e.getMessage());
		}
		
		try {

			participacao = new AlunoGraduando ("",3,date,6,20,10);
			Assert.fail("Lancamento de exception com cpf vazio");

		} catch (Exception e) {
			Assert.assertEquals("CPF nulo ou vazio", e.getMessage());
		}
		
		try {

			participacao =  new AlunoGraduando ("123.456.789-19",3,date,6,0,10);
			Assert.fail("Lancamento de exception com quantidade de horas semanais nula");

		} catch (Exception e) {
			Assert.assertEquals("Valor invalido", e.getMessage());
		}
		
		try {

			participacao =  new AlunoGraduando ("123.456.789-19",3,date,6,-7,10);
			Assert.fail("Lancamento de exception com quantidade de horas semanais negativa");

		} catch (Exception e) {
			Assert.assertEquals("Valor invalido", e.getMessage());
		}
		try {

			participacao = new AlunoGraduando ("123.456.789-19",3,date,6,20,-9);
			Assert.fail("Lancamento de exception com valor hora negativo");

		} catch (Exception e) {
			Assert.assertEquals("Valor da hora invalido", e.getMessage());
		}
		
		try {

			participacao =  new AlunoGraduando ("123.456.789-19",3,date,0,20,10);
			Assert.fail("Lancamento de exception com quantidade de meses nula");

		} catch (Exception e) {
			Assert.assertEquals("Valor invalido", e.getMessage());
		}
		
		try {

			participacao =  new AlunoGraduando ("123.456.789-19",3,date,-6,20,10);
			Assert.fail("Lancamento de exception com quantidade de meses negativa");

		} catch (Exception e) {
			Assert.assertEquals("Valor invalido", e.getMessage());
		}
		
		
	}

}

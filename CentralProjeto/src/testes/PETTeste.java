package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pessoa.Pessoa;
import projeto.Extensao;
import projeto.PED;
import projeto.PET;

public class PETTeste {

	private PET projeto;
	private PET projeto2;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		projeto = new PET(5,"Guardians","guardar",4,6,1,2,3, date,90);

	}

	@Test
	public void testConstrutor() {

		try {

			projeto2 = new PET(5,"Guardians","guardar",4,6,1,2,3, date,90);

		} catch (Exception e) {
			Assert.fail("Não deveria ser lancada exception nesse caso");
		}

		try {

			projeto2 = new PET(5,"Guardians","guardar",1,2,3,-4,5, date,90);
			Assert.fail("Lancamento de exception com Producao academica negativa");

		} catch (Exception e) {
			Assert.assertEquals("Numero de producoes academicas invalido", e.getMessage());
		}
		
		try {

			 projeto2 = new PET(5,"Guardians","guardar",1,2,-3,4,5, date,90);
			Assert.fail("Lancamento de exception com producao tecnica negativa");

		} catch (Exception e) {
			Assert.assertEquals("Numero de producoes tecnicas invalido", e.getMessage());
		}
		
		try {

			projeto2 = new PET(5,"Guardians","guardar",1,2,3,4,-5, date,90);
			Assert.fail("Lancamento de exception com patente negativa");

		} catch (Exception e) {
			Assert.assertEquals("Numero de patentes invalido", e.getMessage());
		}
		
		try {

			projeto2 = new PET(5,"Guardians","guardar",-1,2,3,4,5, date,90);
			Assert.fail("Lancamento de exception com o impacto negativo");

		} catch (Exception e) {
			Assert.assertEquals("Valor invalido", e.getMessage());
		}

		try {

			projeto2 = new PET(5,"Guardians","guardar",1,-2,3,4,5, date,90);
			Assert.fail("Lancamento de exception com o rendimento negativo");

		} catch (Exception e) {
			Assert.assertEquals("Valor invalido", e.getMessage());
		}

		
	}

}

package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.PED;
import projeto.PET;

public class PEDTeste {

	private PED projeto;
	private PED projeto2;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		projeto = new PED(5,"Guardians","Pesquisa",1,2,3,"guardar",date,90);

	}

	@Test
	public void testConstrutor() {

		try {

			projeto2 = new PED(5,"Guardians","Pesquisa",1,2,3,"guardar",date,90);

		} catch (Exception e) {
			Assert.fail("Não deveria ser lancada exception nesse caso");
		}

		try {

			projeto2 = new PED(5,"Guardians","Pesquisa",1,-2,3,"guardar",date,90);
			Assert.fail("Lancamento de exception com Producao academica negativa");

		} catch (Exception e) {
			Assert.assertEquals("Numero de producoes academicas invalido", e.getMessage());
		}
		
		try {

			projeto2 = new PED(5,"Guardians","Pesquisa",-1,2,3,"guardar",date,90);
			Assert.fail("Lancamento de exception com producao tecnica negativa");

		} catch (Exception e) {
			Assert.assertEquals("Numero de producoes tecnicas invalido", e.getMessage());
		}
		
		try {

			projeto2 = new PED(5,"Guardians","Pesquisa",1,2,-3,"guardar",date,90);
			Assert.fail("Lancamento de exception com patente negativa");

		} catch (Exception e) {
			Assert.assertEquals("Numero de patentes invalido", e.getMessage());
		}
	}

}

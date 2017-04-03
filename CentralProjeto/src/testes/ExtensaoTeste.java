package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.Extensao;
import projeto.Monitoria;

public class ExtensaoTeste {

	private Extensao projeto;
	private Extensao projeto2;
	private Date calendar;

	@Before
	public void setUp() throws Exception {

		calendar = new Date();
		projeto = new Extensao(3, "Guardians", "Guardar", calendar, 4, 60);

	}

	@Test
	public void test() {

		try {

			projeto2 = new Extensao(3, "Guardians", "Guardar", calendar, 4, 60);

		} catch (Exception e) {
			Assert.fail("Não deveria ser lancada exception nesse caso");
		}

		try {

			projeto2 = new Extensao(3, "Guardians", "Guardar", calendar, -3, 60);
			Assert.fail("Lancamento de exception com o impacto negativo");

		} catch (Exception e) {
			Assert.assertEquals("Valor invalido", e.getMessage());
		}

	}

}

package testes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import projeto.Monitoria;
import projeto.PED;

public class MonitoriaTeste {

	private Monitoria projeto;
	private Monitoria projeto2;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		projeto = new Monitoria(1, "MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 90);

	}

	@Test
	public void testConstrutor() {

		try {

			projeto = new Monitoria(1, "MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 6);

		} catch (Exception e) {
			Assert.fail("Não deveria ser lancada exception nesse caso");
		}

		try {

			projeto2 = projeto = new Monitoria(1, "MonitoriaP2", "", 2, "Monitorar", "2016.1", date, 90);
			Assert.fail("Lancamento de exception com nome da disciplina especifica vazio");

		} catch (Exception e) {
			Assert.assertEquals("Disciplina nula ou vazia", e.getMessage());
		}

		try {

			projeto2 = new Monitoria(1, "MonitoriaP2", "P2", 2, "Monitorar", "", date, 90);
			Assert.fail("Lancamento de exception com o periodo vazio");

		} catch (Exception e) {
			Assert.assertEquals("Periodo nulo ou vazio", e.getMessage());
		}

	}

}

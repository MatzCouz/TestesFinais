package testes;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.ProjetoController;
import exception.ProjetoInvalidoException;
import projeto.Monitoria;
import projeto.Projeto;

public class ProjetoControllerTeste {

	private ProjetoController controller;
	private Projeto projeto;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		controller = new ProjetoController();
		projeto = new Monitoria(1, "MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 90);
	}

	@Test
	public void testAdicionaMonitoria() throws ProjetoInvalidoException {

		Assert.assertEquals(4, controller.adicionaMonitoria("MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 90));

	}

	@Test
	public void testAdicionaPET() throws ProjetoInvalidoException {

		Assert.assertEquals(3, controller.adicionaPET("Guardians", "guardar", 4, 6, 1, 2, 3, date, 90));

	}

	@Test
	public void testAdicionaPED() throws Exception {

		Assert.assertEquals(2, controller.adicionaPED("Guardians", "PIBIT", 1, 2, 3, "guardar", date, 90));

	}

	@Test
	public void testAdicionaExtensao() throws Exception {

		Assert.assertEquals(1, controller.adicionaExtensao("Guardians", "Guardar", 4, date, 60));

	}

	@Test
	public void testGetCodigoProjeto() throws Exception {

		controller.adicionaMonitoria("MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 90);
		Assert.assertEquals(5, controller.getCodigoProjeto(projeto.getNome()));

	}

}

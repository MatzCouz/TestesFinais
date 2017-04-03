package testes;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.FactoryProjeto;
import projeto.Extensao;
import projeto.Monitoria;
import projeto.PED;
import projeto.PET;
import projeto.Projeto;

public class FactoryProjetoTeste {

	private FactoryProjeto factory;
	private Projeto projeto;
	private Projeto projeto2;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		factory = new FactoryProjeto();
	}

	@Test
	public void testCriaMonitoria() throws Exception {

		projeto = new Monitoria(0, "MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 90);
		projeto2 = factory.criaMonitoria("MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 90);

		Assert.assertEquals(projeto, projeto2);

	}

	@Test
	public void testCriaPET() throws Exception {

		projeto = new PET(0, "Guardians", "guardar", 4, 6, 1, 2, 3, date, 90);
		projeto2 = factory.criaPET("Guardians", "guardar", 4, 6, 1, 2, 3, date, 90);

		Assert.assertEquals(projeto, projeto2);

	}
	
	@Test
	public void testCriaExtensao() throws Exception {

		projeto = new Extensao(0, "Guardians", "Guardar", date, 4, 60);
		projeto2 = factory.criaExtensao("Guardians", "Guardar", 4, date, 60);

		Assert.assertEquals(projeto, projeto2);

	}
	
	@Test
	public void testCriaPED() throws Exception {

		projeto = new PED(0,"Guardians","PIBIT",1,2,3,"guardar",date,90);
		projeto2 = factory.criaPED("Guardians","PIBIT",1,2,3,"guardar",date,90);

		Assert.assertEquals(projeto, projeto2);

	}

}

package testes;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import repository.RepositoryProjeto;
import projeto.Monitoria;
import projeto.Projeto;

public class RepositoryProjetoTeste {

	private RepositoryProjeto repository;
	private Projeto projeto;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		repository = new RepositoryProjeto();
		projeto = new Monitoria(1, "MonitoriaP2", "P2", 2, "Monitorar", "2016.1", date, 90);
	}

	@Test
	public void testVerificaProjetoCadastrado() {

		repository.adicionarProjeto(projeto);

		Assert.assertTrue(repository.verificaProjetoCadastrado(projeto.getCodigo()));

	}

	@Test
	public void testGetCodigoProjeto() {

		repository.adicionarProjeto(projeto);

		Assert.assertEquals(projeto.getCodigo(), repository.getCodigoProjeto(projeto.getNome()));

	}
	
	@Test
	public void testGetProjeto() {

		repository.adicionarProjeto(projeto);

		Assert.assertEquals(projeto, repository.getProjeto(projeto.getCodigo()));

	}
	
	

}

package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pessoa.Pessoa;
import repository.RepositoryPessoa;

public class RepositoryPessoaTeste {

	private RepositoryPessoa repository;
	private Pessoa pessoa;
	private Pessoa pessoa2;

	@Before
	public void setUp() throws Exception {
		repository = new RepositoryPessoa();
		pessoa = new Pessoa("024.685.014-52", "Dilma", "LulaLindo@gmail.com");
	}

	@Test
	public void testVerificaCpfCadastrado() {
		
		Assert.assertFalse(repository.verificaCpfCadastrado("024.685.014-52"));
		repository.adicionaPessoa(pessoa);
		Assert.assertTrue(repository.verificaCpfCadastrado("024.685.014-52"));
	}

	@Test
	public void testGetPessoa() {

		repository.adicionaPessoa(pessoa);
		pessoa2 = repository.getPessoa("024.685.014-52");
		Assert.assertEquals(pessoa, pessoa2);

	}

}

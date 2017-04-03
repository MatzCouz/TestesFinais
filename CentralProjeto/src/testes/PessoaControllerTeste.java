package testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.PessoaController;
import exception.PessoaInvalidaException;

public class PessoaControllerTeste {
	
	private PessoaController controller;

	@Before
	public void setUp() throws Exception {
		
		controller = new PessoaController();
	}

	@Test
	public void testCadastraPessoa() throws PessoaInvalidaException {
		
		Assert.assertEquals("024.685.014-52", controller.cadastraPessoa("024.685.014-52", "Dilma", "LulaLindo@gmail.com"));
	}
	

}

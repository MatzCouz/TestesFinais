package testes;

import pessoa.Pessoa;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PessoaTeste {

	private Pessoa pessoa;
	private Pessoa pessoa2;

	@Before
	public void setUp() throws Exception {
		pessoa = new Pessoa("123.456.789-19", "Chiquinho", "chiquinho@gmail.com");
	}

	@Test
	public void testConstrutor() {

		try {

			pessoa2 = new Pessoa("123.456.789-19", "Chiquinho", "chiquinho@gmail.com");

		} catch (Exception e) {
			Assert.fail("Não deveria ser lancada exception nesse caso");
		}

		try {

			pessoa2 = new Pessoa("123.456.789-19", null, "chiquinho@gmail.com");
			Assert.fail("Lancamento de exception com nome nulo");

		} catch (Exception e) {
			Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
		}

		try {

			pessoa2 = new Pessoa("123.456.789-19", "", "chiquinho@gmail.com");
			Assert.fail("Lancamento de exception com nome nulo ou vazio");

		} catch (Exception e) {
			Assert.assertEquals("Nome nulo ou vazio", e.getMessage());
		}

		try {

			pessoa2 = new Pessoa(null, "Chiquinho", "chiquinho@gmail.com");
			Assert.fail("Lancamento de exception com cpf nulo ou vazio");

		} catch (Exception e) {
			Assert.assertEquals("CPF nulo ou vazio", e.getMessage());
		}

		try {

			pessoa2 = new Pessoa("", "Chiquinho", "chiquinho@gmail.com");
			Assert.fail("Lancamento de exception com cpf nulo ou vazio");

		} catch (Exception e) {
			Assert.assertEquals("CPF nulo ou vazio", e.getMessage());
		}
		
		try {

			pessoa2 = new Pessoa("123.456.789-19", "Chiquinho", null);
			Assert.fail("Lancamento de exception com email nulo ou vazio");

		} catch (Exception e) {
			Assert.assertEquals("Email nulo ou vazio", e.getMessage());
		}
		
		try {

			pessoa2 = new Pessoa("123.456.789-19", "Chiquinho", "");
			Assert.fail("Lancamento de exception com email nulo ou vazio");

		} catch (Exception e) {
			Assert.assertEquals("Email nulo ou vazio", e.getMessage());
		}
		
		try {

			pessoa2 = new Pessoa("1234", "Chiquinho", "chiquinho@gmail.com");
			Assert.fail("Lancamento de exception com cpf invalido");

		} catch (Exception e) {
			Assert.assertEquals("CPF invalido", e.getMessage());
		}
		
		try {

			pessoa2 = new Pessoa("123.456.789-19", "Chiquinho", "chiquinhoXXX.com");
			Assert.fail("Lancamento de exception com email invalido");

		} catch (Exception e) {
			Assert.assertEquals("Email invalido", e.getMessage());
		}
		

	}

}

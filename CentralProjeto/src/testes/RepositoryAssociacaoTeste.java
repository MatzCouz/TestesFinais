package testes;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import repository.RepositoryAssociacao;
import participacao.AlunoGraduando;
import participacao.Participacao;
import participacao.Professor;

public class RepositoryAssociacaoTeste {

	private RepositoryAssociacao repository;
	private Participacao participacao;
	private Participacao participacao2;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		repository = new RepositoryAssociacao();
		participacao = new AlunoGraduando("123.456.789-19", 3, date, 6, 20, 10);
	}

	@Test
	public void testGetPossuiProfessor() throws Exception {

		repository.adicionaAssociacao(participacao);
		Assert.assertFalse(repository.getPossuiProfessor(participacao.getCodprojeto()));

		participacao2 = new Professor("123.456.789-19", 4, date, 6, 20, 10, false);

		repository.adicionaAssociacao(participacao2);
		Assert.assertTrue(repository.getPossuiProfessor(participacao2.getCodprojeto()));

	}

	@Test
	public void testGetPossuiGraduando() throws Exception {

		participacao2 = new Professor("123.456.789-19", 4, date, 6, 20, 10, false);
		repository.adicionaAssociacao(participacao);
		repository.adicionaAssociacao(participacao2);

		Assert.assertFalse(repository.getPossuiGraduando(participacao2.getCodprojeto()));
		Assert.assertTrue(repository.getPossuiGraduando(participacao.getCodprojeto()));

	}

	@Test
	public void testGetQuantCoordenador() throws Exception {

		participacao2 = new Professor("123.456.789-19", 4, date, 6, 20, 10, true);
		repository.adicionaAssociacao(participacao2);

		Assert.assertEquals(1, repository.getQuantCoordenador(participacao2.getCodprojeto()));

	}
	
	@Test
	public void testGetQuantidadeParticipantes() throws Exception {

		repository.adicionaAssociacao(participacao);

		Assert.assertEquals(1, repository.getQuantidadeParticipantes(participacao.getCodprojeto()));

	}

}

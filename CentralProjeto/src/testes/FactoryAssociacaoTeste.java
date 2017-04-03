package testes;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import factory.FactoryAssociacao;
import participacao.Participacao;
import participacao.AlunoGraduando;
import participacao.AlunoPosGraduando;
import participacao.Professor;
import participacao.Profissional;

public class FactoryAssociacaoTeste {

	private FactoryAssociacao factory;
	private Participacao participacao;
	private Participacao participacao2;
	private Date date;

	@Before
	public void setUp() throws Exception {

		date = new Date();
		factory = new FactoryAssociacao();

	}

	@Test
	public void testCriaParticipacaoProfessor() throws Exception {
		
		participacao = new Professor("123.456.789-19",3,date,6,20,10, false);
		participacao2 = factory.criaParticipacaoProfessor("123.456.789-19",3,date,6,20,10, false);
		
		Assert.assertEquals(participacao, participacao2);
	}
	
	@Test
	public void testCriaParticipacaoGraduando() throws Exception {
		
		participacao = new AlunoGraduando("123.456.789-19",3,date,6,20,10);
		participacao2 = factory.criaParticipacaoGraduando("123.456.789-19",3,date,6,20,10);
		
		Assert.assertEquals(participacao, participacao2);
	}
	
	@Test
	public void testCriaParticipacaoProfissional() throws Exception {
		
		participacao = new Profissional("123.456.789-19",3,date,6,20,10, "Chefe na empresa VASP");
		participacao2 = factory.criaParticipacaoProfissional("123.456.789-19",3,date,6,20,10, "Chefe na empresa VASP");
		
		Assert.assertEquals(participacao, participacao2);
	}
	
	@Test
	public void testCriaParticipacaoPosGraduando() throws Exception {
		
		participacao = new AlunoPosGraduando("123.456.789-19",3,"Doutorado",date,6,20,10);
		participacao2 = factory.criaParticipacaoPosGraduando("123.456.789-19",3,"Doutorado",date,6,20,10);
		
		Assert.assertEquals(participacao, participacao2);
	}

}

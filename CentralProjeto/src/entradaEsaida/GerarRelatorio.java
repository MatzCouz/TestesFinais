package entradaEsaida;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import projeto.Projeto;
import util.Util;

/**
 * GerarRelatorio. 
 * Classe que gera os relatórios do sistema.
 *
 * @author Matheus de Souza Coutinho
 * @author Matheus Vasconcelos Figueiredo
 */

public class GerarRelatorio {
	private static String projetotxt;
	private static String colaboracaotxt;
	private static int totalProjetosConcluidos;
	private static int totalProjetos;
	private static int totalGraduando;
	private static int totalPosGraduando;
	private static int totalProfissional;
	private File systemDir;
	private File cad_projetos;
	private File cad_colaboracoes;
	
	public GerarRelatorio(){
		totalProjetos = 0;
		totalProjetosConcluidos = 0;
		projetotxt = "";
		colaboracaotxt = "";
		totalGraduando = 0;
		totalPosGraduando = 0;
		totalProfissional = 0;
		this.systemDir = new File("arquivos_sistema"+File.separator+"relatorios");
		cad_projetos = new File(this.systemDir+File.separator+"cod_projetos.txt");
		cad_colaboracoes = new File(this.systemDir+File.separator+ "cod_colaboracoes.txt");
	}
	
	public void gerarRelatorioProjetos() throws Exception{
		try{
			if(! systemDir.exists() || !systemDir.isDirectory()){
				systemDir.mkdir();
			}
			FileWriter arquivo = new FileWriter(cad_projetos);
			arquivo.write("Cadastro de Projetos: "+getTotalProjetos()+" projetos cadastrados"+System.lineSeparator());
			arquivo.write(projetotxt);
			arquivo.write("Total de projetos concoluidos: " + totalProjetosConcluidos + System.lineSeparator());
			arquivo.write("Participacao de graduacao: "+totalGraduando+ System.lineSeparator());
			arquivo.write("Participacao de pos-graduacao: "+totalPosGraduando+System.lineSeparator());
			arquivo.write("Participacao de profissionais: "+totalProfissional);
			arquivo.flush();
			arquivo.close();
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		limparAux();
	}
	
	public void getAtualizaProjetos(int num, Projeto projeto){
		projetotxt += "==> Projeto " + num + System.lineSeparator();
		projetotxt += "Nome: " + projeto.getNome() + System.lineSeparator();
		projetotxt += "Data de inicio: " + Util.alteraData(projeto) + System.lineSeparator();
		projetotxt += "Coordenador: " + projeto.getCoordenador() + System.lineSeparator();
		projetotxt += "Situacao: " + Util.situacaoProjeto(projeto.getData(), projeto.getDuracao()) + System.lineSeparator(); 
		projetotxt += System.lineSeparator();
		if(Util.comparaDatas(projeto.getData(), projeto.getDuracao())){totalProjetosConcluidos++;}
	}
	
	public void getTotalGraduando(int valor){
		totalGraduando = valor;
	}
	
	public int getTotalProjetos() {
		return totalProjetos;
	}
	
	public void setTotalProjetos(int totalProjetos) {
		this.totalProjetos = totalProjetos;
	}
	
	public void limparAux(){
		projetotxt = "";
	}

	public void getTotalPosGraduando(int quantidadePosGraduando) {
		totalPosGraduando = quantidadePosGraduando;
	}
	
	public void getTotalProfissionais(int quantidadeProfissinal) {
		totalProfissional = quantidadeProfissinal;
	}
	public void getColaboracoes(Projeto projeto, double calculaColaboracao) {
		colaboracaotxt += "==> Nome: "+projeto.getNome()+" Data de inicio: "+Util.alteraData(projeto)+" Valor colaborado: R$ "+calculaColaboracao+System.lineSeparator();
	}
	public void gerarRelatorioColaboracoes() throws Exception{
		try{
			if(! systemDir.exists() || !systemDir.isDirectory()){
				systemDir.mkdir();
			}
			FileWriter arquivo = new FileWriter(cad_colaboracoes);
			arquivo.write("Historico das colaboracoes: "+System.lineSeparator());
			arquivo.write(colaboracaotxt);
			arquivo.flush();
			arquivo.close();
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	
}

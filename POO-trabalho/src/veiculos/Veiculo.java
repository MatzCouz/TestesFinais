package veiculos;

import excecoes.EntradaInvalidaException;
import excecoes.ExcecoesEntradas;

public abstract class Veiculo {
	
	protected String proprietario;
	protected String nomeVeiculo;
	protected String fabricante;
	protected int anoFabricacao;
	protected String combustivel;
	protected String cor;
	protected String placa;
	protected String identificacao;
	
	protected boolean ligado;
	
	public Veiculo(String proprietario, String nomeVeiculo, String fabricante, int anoFabricacao, String combustivel, String cor, String placa, String identificacao) throws EntradaInvalidaException {
		
		ExcecoesEntradas.validaStrings(proprietario);
		ExcecoesEntradas.validaStrings(nomeVeiculo);
		ExcecoesEntradas.validaStrings(fabricante);
		ExcecoesEntradas.validaStrings(combustivel);
		ExcecoesEntradas.validaStrings(cor);
		ExcecoesEntradas.validaStrings(placa);
		ExcecoesEntradas.validaStrings(identificacao);
		ExcecoesEntradas.validaAno(anoFabricacao);
		
		this.proprietario = proprietario;
		this.nomeVeiculo = nomeVeiculo;
		this.fabricante = fabricante;
		this.anoFabricacao = anoFabricacao;
		this.combustivel = combustivel;
		this.cor = cor;
		this.placa = placa;
		this.identificacao = identificacao;
		this.ligado = false;
		
	}
	
	public Veiculo() {
		
	}
	
	public void ligar() {
		System.out.println("O veiculo " + nomeVeiculo +" está ligado!");
		this.ligado = true;
	}
	
	public void desligar() {
		System.out.println("O veiculo " + nomeVeiculo + " está desligado!");
		this.ligado = false;
	}
	
	public void iniciarMovimento() {
		System.out.println("O veiculo " + nomeVeiculo + " está pronto para ser inicializado!");
		
	}
	
	public void pararMovimento() {
		System.out.println("O veiculo " + nomeVeiculo + " está parado!");
		
	}
	
	public void virarParaDireita() {
		System.out.println("O veiculo " + nomeVeiculo + " está virado para direita!");
	}
	
	public void virarParaEsquerda() {
		System.out.println("O veiculo " + nomeVeiculo + " está virado para esquerda!");
	}
	
	public void mostrarDados() {
		System.out.println("O nome do automóvel: " + this.nomeVeiculo);
		System.out.println("O ano de fabricação: " + this.anoFabricacao);
		System.out.println("O combustíbel: " + this.combustivel);
		System.out.println("A cor: " + this.cor);
		System.out.println("O fabricante: " + this.fabricante);
		System.out.println("A placa: " + this.placa);
		System.out.println("A identificação: " + this.identificacao);
	}
	
	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getNomeVeiculo() {
		return nomeVeiculo;
	}

	public void setNomeVeiculo(String nomeVeiculo) {
		this.nomeVeiculo = nomeVeiculo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public boolean isLigado() {
		return ligado;
	}

	public void setLigado(boolean ligado) {
		this.ligado = ligado;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	
	

}

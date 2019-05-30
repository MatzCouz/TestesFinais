package veiculos;

public class Lancha extends Veiculo{

	private boolean ancoraLancada;
	private boolean carcacaAcionada;
	
	public Lancha(String identificacaoLancha) {
		this.ancoraLancada = false;
		this.carcacaAcionada = false;
	}
	
	public void navegar() {
		if(ancoraLancada) {
			System.out.println("N�o pode navegar! a ancora est� lan�ada!");
		}else if(carcacaAcionada) {
			System.out.println("N�o pode navegar! a carca�a est� acionada!");
		}else if(!ligado) {
			System.out.println("A lancha est� desligada!");
		}else {
			System.out.println("Navegando...");
		}
		
	}
	
	public void lancarAncora() {
		if(!ancoraLancada) {
			System.out.println("A ancora do " + this.nomeVeiculo + " foi lan�ada!");
			this.ancoraLancada = true;
		}else {
			System.out.println("A ancora do " + this.nomeVeiculo + " j� est� lan�ada!");
		}
	}
	
	public void recolherAncora() {
		if(!ancoraLancada) {
			System.out.println("A ancora do " + this.nomeVeiculo + " j� est� recolhida!");
		}else {
			System.out.println("A ancora do " + this.nomeVeiculo + " foi recolhida!");
			this.ancoraLancada = false;
		}
	}
	
	public void trocarMarchaComoLancha() {
		if(this.ligado) {
			System.out.println("A marcha do veiculo " + this.nomeVeiculo + " foi trocada!");
		}else {
			System.out.println("O veiculo " + this.nomeVeiculo + " est� desligado!");
		}
	}
	
	public void acionarCarcaca() {
		if(this.ligado) {
			if(this.carcacaAcionada)
				System.out.println("A carca�a do ve�culo " + this.nomeVeiculo + " j� est� acionada!");
			else {
				System.out.println("A carca�a do ve�culo " + this.nomeVeiculo + " foi acionada!");
				this.carcacaAcionada = true;
			}
		}else {
			System.out.println("O veiculo " + this.nomeVeiculo + " est� desligado!");
		}
	}
	public void recolherCarcara() {
		if(this.ligado) {
			if(this.carcacaAcionada) {
				System.out.println("A carca�a do ve�culo " + this.nomeVeiculo + " foi recolhida!");
				this.carcacaAcionada = false;
			} else {
				System.out.println("A carca�a do ve�culo " + this.nomeVeiculo + " j� est� recolhida!");
			}
		}else {
			System.out.println("O veiculo " + this.nomeVeiculo + " est� desligado!");
		}
	}
	public void andarParaTrasComoLancha() {
		if(this.ligado) {
			System.out.println("A lancha " + this.nomeVeiculo + " est� andando pra tr�s!");
		}else {
			System.out.println("A lancha " + this.nomeVeiculo + " est� desligada!");
		}
	}
	
	public void mostrarDadosLancha() {}
	

	
}

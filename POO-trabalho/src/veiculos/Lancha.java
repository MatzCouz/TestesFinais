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
			System.out.println("Não pode navegar! a ancora está lançada!");
		}else if(carcacaAcionada) {
			System.out.println("Não pode navegar! a carcaça está acionada!");
		}else if(!ligado) {
			System.out.println("A lancha está desligada!");
		}else {
			System.out.println("Navegando...");
		}
		
	}
	
	public void lancarAncora() {
		if(!ancoraLancada) {
			System.out.println("A ancora do " + this.nomeVeiculo + " foi lançada!");
			this.ancoraLancada = true;
		}else {
			System.out.println("A ancora do " + this.nomeVeiculo + " já está lançada!");
		}
	}
	
	public void recolherAncora() {
		if(!ancoraLancada) {
			System.out.println("A ancora do " + this.nomeVeiculo + " já está recolhida!");
		}else {
			System.out.println("A ancora do " + this.nomeVeiculo + " foi recolhida!");
			this.ancoraLancada = false;
		}
	}
	
	public void trocarMarchaComoLancha() {
		if(this.ligado) {
			System.out.println("A marcha do veiculo " + this.nomeVeiculo + " foi trocada!");
		}else {
			System.out.println("O veiculo " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	public void acionarCarcaca() {
		if(this.ligado) {
			if(this.carcacaAcionada)
				System.out.println("A carcaça do veículo " + this.nomeVeiculo + " já está acionada!");
			else {
				System.out.println("A carcaça do veículo " + this.nomeVeiculo + " foi acionada!");
				this.carcacaAcionada = true;
			}
		}else {
			System.out.println("O veiculo " + this.nomeVeiculo + " está desligado!");
		}
	}
	public void recolherCarcara() {
		if(this.ligado) {
			if(this.carcacaAcionada) {
				System.out.println("A carcaça do veículo " + this.nomeVeiculo + " foi recolhida!");
				this.carcacaAcionada = false;
			} else {
				System.out.println("A carcaça do veículo " + this.nomeVeiculo + " já está recolhida!");
			}
		}else {
			System.out.println("O veiculo " + this.nomeVeiculo + " está desligado!");
		}
	}
	public void andarParaTrasComoLancha() {
		if(this.ligado) {
			System.out.println("A lancha " + this.nomeVeiculo + " está andando pra trás!");
		}else {
			System.out.println("A lancha " + this.nomeVeiculo + " está desligada!");
		}
	}
	
	public void mostrarDadosLancha() {}
	

	
}

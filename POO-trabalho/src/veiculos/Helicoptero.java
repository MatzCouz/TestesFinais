package veiculos;

public class Helicoptero extends Veiculo {

	private boolean voando;
	private boolean helicesLigadas;
	
	public Helicoptero() {
		super();
		this.voando = false;
		this.helicesLigadas = false;
	}
	
	public void voarComoHelicoptero() {
		if(this.ligado) {
			if(this.voando)
				System.out.println("O helicoptero " +this.nomeVeiculo+" já está voando!");
			else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" começou a voar!");
				this.voando = true;
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	public void aterrisarComoHelicoptero() {
		if(this.ligado) {
			if(this.voando) {
				System.out.println("O helicoptero " +this.nomeVeiculo+" está em terra!");
				this.voando = false;

			}else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" não está voando!");
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	
	public void trocarMarchaComoHelicoptero() {
		if(this.ligado)
			System.out.println("O helicoptero " +this.nomeVeiculo+" trocou de marcha!");
		else
			System.out.println("O helicoptero " + this.nomeVeiculo + " está desligado!");
	}
	
	
	public void acionarHelices() {
		if(this.ligado) {
			if(this.helicesLigadas)
				System.out.println("O helicoptero " +this.nomeVeiculo+" já está com as hélices ligadas!");
			else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" acionou as hélices!");
				this.helicesLigadas = true;
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	public void recolherHelices() {
		if(this.ligado) {
			if(this.helicesLigadas) {
				System.out.println("O helicoptero "+this.nomeVeiculo+" recolheu as hélices!");
				this.helicesLigadas = false;
			}else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" já está com as hélices recolhidas!");
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	
	public void mostrarDadosHelicop() {}
	
	
	public void decolar() {
		if(this.ligado) {
			System.out.println("O helicóptero "+this.nomeVeiculo+" decolou!");
		}else {
			System.out.println("O helicóptero "+this.nomeVeiculo+" está desligado!");
		}
		
	}
	
}

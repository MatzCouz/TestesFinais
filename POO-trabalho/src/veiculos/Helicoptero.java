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
				System.out.println("O helicoptero " +this.nomeVeiculo+" j� est� voando!");
			else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" come�ou a voar!");
				this.voando = true;
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " est� desligado!");
		}
	}
	
	public void aterrisarComoHelicoptero() {
		if(this.ligado) {
			if(this.voando) {
				System.out.println("O helicoptero " +this.nomeVeiculo+" est� em terra!");
				this.voando = false;

			}else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" n�o est� voando!");
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " est� desligado!");
		}
	}
	
	
	public void trocarMarchaComoHelicoptero() {
		if(this.ligado)
			System.out.println("O helicoptero " +this.nomeVeiculo+" trocou de marcha!");
		else
			System.out.println("O helicoptero " + this.nomeVeiculo + " est� desligado!");
	}
	
	
	public void acionarHelices() {
		if(this.ligado) {
			if(this.helicesLigadas)
				System.out.println("O helicoptero " +this.nomeVeiculo+" j� est� com as h�lices ligadas!");
			else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" acionou as h�lices!");
				this.helicesLigadas = true;
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " est� desligado!");
		}
	}
	
	public void recolherHelices() {
		if(this.ligado) {
			if(this.helicesLigadas) {
				System.out.println("O helicoptero "+this.nomeVeiculo+" recolheu as h�lices!");
				this.helicesLigadas = false;
			}else {
				System.out.println("O helicoptero "+this.nomeVeiculo+" j� est� com as h�lices recolhidas!");
			}
		}else {
			System.out.println("O helicoptero " + this.nomeVeiculo + " est� desligado!");
		}
	}
	
	
	public void mostrarDadosHelicop() {}
	
	
	public void decolar() {
		if(this.ligado) {
			System.out.println("O helic�ptero "+this.nomeVeiculo+" decolou!");
		}else {
			System.out.println("O helic�ptero "+this.nomeVeiculo+" est� desligado!");
		}
		
	}
	
}

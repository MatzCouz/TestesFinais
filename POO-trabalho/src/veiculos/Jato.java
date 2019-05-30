package veiculos;

public class Jato extends Veiculo{
	
	private boolean voando;
	private boolean asasAcionadas;
	
	public Jato() {
		super();
		this.voando = false;
		this.asasAcionadas = false;
	}
	
	public void aterissarComoJato() {
		if(this.ligado) {
			if(this.voando) {
				System.out.println("O jato " + this.nomeVeiculo + " foi aterrissado!");
				this.voando = false;

			} else {
				System.out.println("O jato " + this.nomeVeiculo + " está em terra firme!");
			}
		}else{
			System.out.println("O jato " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	public void voarComoJato() {
		if(this.ligado) {
			System.out.println("O jato está voando!");
			this.voando = true;
		}else {
			System.out.println("O jato já está voando!");
		}
	}
	
	public void trocarMarchaComoJato() {
		if(this.ligado) {
			System.out.println("Troca de marcha feita!");
		}else {
			System.out.println("O jato está desligado!");
		}
	}
	
	public void acionarAsas() {
		if(this.ligado) {
			if(this.asasAcionadas)
				System.out.println("As asas do jato " + this.nomeVeiculo + " já estão acionadas!");
			else {
				System.out.println("As asas do jato " + this.nomeVeiculo + " foram acionadas!");
				this.asasAcionadas = true;
			}
		}else {
			System.out.println("O jato " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	public void recolherAsas() {
		if(this.ligado) {
			if(this.asasAcionadas) {
				if(!this.voando) {
					System.out.println("As asas do jato " + this.nomeVeiculo + " foram recolhidas!");
					this.asasAcionadas = false;
				}else {
					System.out.println("O jato está voando, asas não podem ser recolhidas!");
				}
			} else {
				System.out.println("As asas do jato " + this.nomeVeiculo + " já estão recolhidas!");
			}
		}else {
			System.out.println("O jato " + this.nomeVeiculo + " está desligado!");
		}
	}
	
	public void mostrarDadosJato() {
		
	}
	
	public void decolar() {
		if(this.ligado && this.asasAcionadas && !this.voando) {
			System.out.println("O jato está pronto para ser decolado... decolando!");
		}else if(!this.asasAcionadas) {
			System.out.println("As asas não foram acionadas!");
		}else if(!this.ligado) {
			System.out.println("O jato está desligado!");
		}else if(this.voando) {
			System.out.println("O jato já está voando!");
		}
		
	}
	
	
}	

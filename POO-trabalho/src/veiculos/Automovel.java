package veiculos;

public class Automovel extends Veiculo{
	
	public Automovel() {
		super();
	}
	
	public void trocarPneu() {
		System.out.println("Os pneus foram trocados!");
	}
	
	public void trocarMarchaComoAuto() {
		System.out.println("A marcha foi trocada!");
	}
	
	public void andarParaTrasComoAuto() {
		if(this.ligado) {
			System.out.println("O autom�vel "+this.nomeVeiculo+" est� andando para tr�s!");
		}else {
			System.out.println("O autom�vel "+this.nomeVeiculo+" est� desligado!");
		}
	}
	
	public void mostrarDadosAuto() {
		
	}
	
}

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
			System.out.println("O automóvel "+this.nomeVeiculo+" está andando para trás!");
		}else {
			System.out.println("O automóvel "+this.nomeVeiculo+" está desligado!");
		}
	}
	
	public void mostrarDadosAuto() {
		
	}
	
}

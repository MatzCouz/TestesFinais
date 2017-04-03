package projeto;

import java.io.Serializable;

import exception.EntradaInvalidaException;
import exception.ProjetoInvalidoException;
import util.ExcecoesProjetos;
import util.Util;

public class Despesas implements Serializable {
	private double montanteBolsas;
	private double montanteCusteio;
	private double montanteCapital;

	public Despesas(double montanteBolsas, double montanteCusteio, double montanteCapital)  {
		this.montanteBolsas = montanteBolsas;
		this.montanteCusteio = montanteCusteio;
		this.montanteCapital = montanteCapital;
	}

	public Despesas() {
	}

	public double getMontanteBolsas() {
		return montanteBolsas;
	}

	public void setMontanteBolsas(double montanteBolsas) throws EntradaInvalidaException {
		ExcecoesProjetos.validaValores(montanteBolsas);
		this.montanteBolsas = montanteBolsas;
	}

	public double getMontanteCusteio() {
		return montanteCusteio;
	}

	public void setMontanteCusteio(double montanteCusteio) throws EntradaInvalidaException {
		ExcecoesProjetos.validaValores(montanteCusteio);
		this.montanteCusteio = montanteCusteio;
	}

	public double getMontanteCapital() {
		return montanteCapital;
	}

	public void setMontanteCapital(double montanteCapital) throws EntradaInvalidaException {
		ExcecoesProjetos.validaValores(montanteCapital);
		this.montanteCapital = montanteCapital;
	}

	public double getValorTotal(){
		return this.getMontanteBolsas() + this.getMontanteCapital() + this.getMontanteCusteio();
	}
}

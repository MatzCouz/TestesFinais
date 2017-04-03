package repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import projeto.Projeto;

public class RepositoryProjeto implements Serializable {
	private HashMap<Integer, Projeto> projetos;
	
	public RepositoryProjeto(){
		this.projetos = new HashMap<>();
	}
	
	public void adicionarProjeto(Projeto projeto){
		projetos.put(projeto.getCodigo(), projeto);
	}
	
	public void removerProjeto(int codigo){
		projetos.remove(codigo);
	}
	
	public boolean verificaProjetoCadastrado(int codigo){
		return projetos.containsKey(codigo);
	}
	
	public int getCodigoProjeto(String nome){
		for(Projeto projeto : projetos.values()){
			if(projeto.getNome().equalsIgnoreCase(nome)){
				return projeto.getCodigo();
			}
		}
				return -1;
	}
	public Projeto getProjeto(int codigo){
		return projetos.get(codigo);
	}

	public HashMap<Integer, Projeto> getProjetos() {
		return projetos;
	}
	

}

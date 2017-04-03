package entradaEsaida;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import repository.RepositoryAssociacao;
import repository.RepositoryPessoa;
import repository.RepositoryProjeto;

public class FileManager {
	
	private File pessoasBackup;
	private File associacoesBackup;
	private File projetosBackup;
	private File systemdir;
	
	
	public FileManager(){
		this.systemdir = new File("arquivos_sistema" + File.separator);
		pessoasBackup = new File(systemdir+File.separator+"pessoas.dat");
		associacoesBackup = new File(systemdir+File.separator+"associacoes.dat");
		projetosBackup = new File(systemdir+File.separator+"projetos.dat");
	}
	
	public void exportarPessoas(RepositoryPessoa repositoryPessoa) throws Exception {
		try{
			if(! systemdir.exists() || !systemdir.isDirectory()){
				systemdir.mkdir();
			}
			ObjectOutputStream objBufOut = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream(pessoasBackup)));
			
			objBufOut.writeObject(repositoryPessoa);
			objBufOut.flush();
			objBufOut.close();
		}catch(IOException e){
			throw new Exception(e.getMessage());
		}
	}
	
	public void exportarAssociacao(RepositoryAssociacao repositoryAssociacao) throws Exception{
		try{
			if(! systemdir.exists() || !systemdir.isDirectory()){
				systemdir.mkdir();
			}
			ObjectOutputStream objBufOut = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(associacoesBackup)));
			
				objBufOut.writeObject(repositoryAssociacao);
				objBufOut.flush();
				objBufOut.close();
		}catch(IOException e){
			throw new Exception(e.getMessage());
		}
	}
	
	public void exportarProjeto(RepositoryProjeto repositoryProjeto) throws Exception{
		try{
			if(! systemdir.exists() || !systemdir.isDirectory()){
				systemdir.mkdir();
			}
			ObjectOutputStream objBufOut = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(projetosBackup)));
				objBufOut.writeObject(repositoryProjeto);
				objBufOut.flush();
				objBufOut.close();
		}catch(IOException e){
			throw new Exception(e.getMessage());
		}
	}
	
	public RepositoryPessoa importarPessoas() throws Exception{
		if(! systemdir.exists() || !systemdir.isDirectory()){
			throw new Exception("Diretorio do sistema inexistente.");
		}
		if(!pessoasBackup.exists()){
			throw new Exception("Arquivo nao encontrado");
		}
		ObjectInputStream objIN = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(pessoasBackup)));
		
		RepositoryPessoa doArquivo = (RepositoryPessoa) objIN.readObject();
		objIN.close();
		
		if(doArquivo == null){
			throw new Exception("Falha na leitura do arquivo.");
		
		}
		return doArquivo;
	}
	
	public RepositoryAssociacao importarAssociacoes() throws Exception{
		if(! systemdir.exists() || !systemdir.isDirectory()){
			throw new Exception("Diretorio do sistema inexistente.");
		}
		
		if(!associacoesBackup.exists()){
			throw new Exception("falhou no associacao");
		}
		
		ObjectInputStream objIN = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(associacoesBackup)));
		
		RepositoryAssociacao doArquivo = (RepositoryAssociacao) objIN.readObject();
		objIN.close();
		
		if(doArquivo == null){
			throw new Exception("Falha na leitura do arquivo.");
		}
		
		return doArquivo;
	}
	
	public RepositoryProjeto importarProjetos() throws Exception{
		if(! systemdir.exists() || !systemdir.isDirectory()){
			throw new Exception("Diretorio do sistema inexistente.");
		}
		
		if(!projetosBackup.exists()){
			throw new Exception("Falhou no projetos");
		}
		
		ObjectInputStream objIN = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream(projetosBackup)));
		
		RepositoryProjeto doArquivo = (RepositoryProjeto) objIN.readObject();
		objIN.close();
		
		if(doArquivo == null){
			throw new Exception("Falha na leitura do arquivo.");
		}
		
		return doArquivo;
	}
	
	public boolean existeBackup(String atributo){
		switch(atributo){
		case "Pessoas":
			return pessoasBackup.exists();
		case "Associacoes":
			return associacoesBackup.exists();
		case "Projetos":
			return projetosBackup.exists();
		default:
			return false;
		}
		
	}
}

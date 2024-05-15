package controle;

import java.util.ArrayList;

import modelo.Livro;

public class LivroDAO {
	
	private ArrayList<Livro> acervo;
	
	private int geradorID;
	
	private static LivroDAO Instancia;
	
	
	
	public static LivroDAO getInstancia() {
		
		if(Instancia == null) {
			Instancia = new LivroDAO();
		}
		return Instancia;
	}
	
	private LivroDAO() {
	 this.acervo = new ArrayList<>();
	 this.geradorID=1;
	}
	
	public int cadastrar(Livro livro) {
		
		if(livro!= null) {
			livro.setId(geradorID);
			geradorID++;
			acervo.add(livro);
		}
		
		return livro.getId();
	}
	
	public ArrayList<Livro> listar(){
		return this.acervo;
	}
	
	public Livro Buscarid(int cod) {
		for(Livro livro : acervo ) {
			if((livro.getId()) == cod) {
				return livro;
			}
		}
		return null;
	}
	
	public Livro atualizar(Livro livro) {
		
		acervo.add(livro);
		return livro;
	}
	
	public Livro remover(Livro  livro) {
		
		 acervo.remove(livro);
		 
		return null;
	}
	
	

}

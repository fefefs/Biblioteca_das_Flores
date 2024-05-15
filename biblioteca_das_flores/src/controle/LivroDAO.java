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
	
	public Livro atualiza(int codi) {
		
		for(Livro livro2 : acervo) {
			
		}
		
		return livro;
		
	}
	
	public boolean remover(Livro  livro) {
		boolean verif = acervo.remove(livro);
		return verif;
	}
	
	

}

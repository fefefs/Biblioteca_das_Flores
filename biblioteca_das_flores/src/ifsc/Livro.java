package ifsc;

public class Livro {
	
	//*******//
	private String nomeLivro;
	
	
	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	//*******//
	private Autor nomeAutor;
	public Autor getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(Autor nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	//*******//
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	//*******//
	private int quantPaginas;
	public int getQuantPaginas() {
		return quantPaginas;
	}

	public void setQuantPaginas(int quantPaginas) {
		this.quantPaginas = quantPaginas;
	}

	//*******//
	private boolean disponivel;
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	

	
}

package modelo;

public class Livro {

	// *******//
	private String nomeLivro;

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	// *******//
	private Autor autor;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor nomeAutor) {
		this.autor = nomeAutor;
	}

	// *******//
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// *******//
	private int quantPaginas;

	public int getQuantPaginas() {
		return quantPaginas;
	}

	public void setQuantPaginas(int quantPaginas) {
		this.quantPaginas = quantPaginas;
	}

	// *******//
	private boolean disponivel;

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

}

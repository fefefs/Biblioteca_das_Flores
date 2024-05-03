package ifsc;

import java.util.ArrayList;

public class Autor {

	private String nomedoautor;
	private String biografia;
	
	public String getNomedoautor() {
		return nomedoautor;
	}

	public void setNomedoautor(String nomedoautor) {
		this.nomedoautor = nomedoautor;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public ArrayList<String> getLivros() {
		return livros;
	}

	public void setLivros(ArrayList<String> livros) {
		this.livros = livros;
	}

	private ArrayList<String> livros;
}

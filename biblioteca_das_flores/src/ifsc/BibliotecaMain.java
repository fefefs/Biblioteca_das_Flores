package ifsc;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BibliotecaMain {

	public static void main(String[] args) {
		
		ArrayList<Livro> acervo = new ArrayList<>();
		int r = -1;
		while (r  != 0) {
			String op = JOptionPane.showInputDialog(null, "menu \n 0-Sair \n 1-Cadastro \n 2-Listar \n 3-Buscar \n 4-Atualizar \n 5-Excluir");
			r = Integer.valueOf(op);
			switch (r) {
			
			case 1 :
				String nomeLivro = JOptionPane.showInputDialog("Digite o nome do livro : ");
				String cod = JOptionPane.showInputDialog("Digite o codigo do livro : ");
				long codigo = Long.valueOf(cod);
				String qntPg = JOptionPane.showInputDialog("Digite a quantidade de paginas : ");
				Integer qtPaginas = Integer.valueOf(qntPg);
				String dp = JOptionPane.showInputDialog("Este livro esta disponivel para aluguel : ");
				boolean disp = Boolean.valueOf(dp);
				Autor autor = new Autor();
				String nA = JOptionPane.showInputDialog("Digite o nome do autor : ");
				autor.setNomedoautor(nA);
				
				
				Livro livro = new Livro();
				livro.setNomeLivro(nomeLivro);
				livro.setId(codigo);
				livro.setNomeAutor(autor);
				livro.setDisponivel(disp);
				livro.setQuantPaginas(qtPaginas);
				
				acervo.add(livro);
				
				break;
				
			case 2 :
				
				//mostrar todos os livros
				break;
				
			case 3 :
				//buscar por codigo
				break;
			case 4 :
				//atualizar
				break;
			case 5 :
				//excluir
				break;
			default :
				JOptionPane.showInputDialog("Opcao invalida !!");
				break;
				
	
				
				}
			
		}
		
	}

}

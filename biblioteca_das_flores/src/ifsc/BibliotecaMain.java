package ifsc;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BibliotecaMain {

	public static void main(String[] args) {
		
		ArrayList<Livro> estoque = new ArrayList<>();
		int r = -1;
		while (r  != 0) {
			
			switch (r) {
			
			case 1 :
				
				//cadastro
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

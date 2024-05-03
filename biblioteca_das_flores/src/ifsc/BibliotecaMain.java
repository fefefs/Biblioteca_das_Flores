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
				for (Livro livro2 : acervo) {
					JOptionPane.showMessageDialog(null, "O nome do livro :"+livro2.getNomeLivro());
					JOptionPane.showMessageDialog(null,"O codigo :"+livro2.getId());
					JOptionPane.showMessageDialog(null,"O nome do autor :"+livro2.getNomeAutor());
					JOptionPane.showMessageDialog(null,"A disponibilidade :"+livro2.isDisponivel());
					JOptionPane.showMessageDialog(null,"A quantidade de paginas :"+livro2.getQuantPaginas());
				}
				
				
			
				break;
				
			case 3 :
				int verif = 0;
				String id = JOptionPane.showInputDialog("Insira o codigo ID do livro que deseja procurar : ");
				long idBusca = Long.valueOf(id);
				
				for (Livro livro3 : acervo) {
					if ((livro.getId()) == idBusca) {
						JOptionPane.showMessageDialog(null, "O nome do livro :"+livro3.getNomeLivro());
						JOptionPane.showMessageDialog(null,"O codigo :"+livro3.getId());
						JOptionPane.showMessageDialog(null,"O nome do autor :"+livro3.getNomeAutor());
						JOptionPane.showMessageDialog(null,"A disponibilidade :"+livro3.isDisponivel());
						JOptionPane.showMessageDialog(null,"A quantidade de paginas :"+livro3.getQuantPaginas());
						
						verif = 2;
					} 
					
				}
				if (verif != 2) {
					
					JOptionPane.showMessageDialog(null, "Este codigo ID nao foi encontrado em nosso acervo !");
				}
			
				break;
			case 4 :
				
				String Categoriaalterar = JOptionPane.showInputDialog("O que voce deseja mudar?\n Opçoes:\nNomeLivro\nNomeAutor\nDisponivel\nQuantPaginas");
				
							
				for (Livro livro2 : acervo) {
					
					if (Categoriaalterar.equals (livro2.getNomeLivro())) {
					String novonome = JOptionPane.showInputDialog("Qual o novo nome do livro");
						 livro2.setNomeLivro( novonome); 
						
					}
					
					if (Categoriaalterar.equals (livro2.getNomeAutor())) {
						String novonomeautor = JOptionPane.showInputDialog("Qual o novo nome do autor");
							 livro2.setNomeAutor(novonomeautor); 
							
						}
					
					if (Categoriaalterar.equals (livro2.isDisponivel())) {
						String novaDispo = JOptionPane.showInputDialog("Qual a diponibilidade");
							 livro2.setDisponivel(novaDispo); 
							
						}
					if (Categoriaalterar.equals (livro2.getQuantPaginas())) {
						String nqtp = JOptionPane.showInputDialog("Qual a quantidade de paginas");
						Integer nQuantPg  = Integer.valueOf(nqtp);
							 livro2.setQuantPaginas( nQuantPg); 
							
						}
					if (Categoriaalterar.equals (livro2.getId())) {
						JOptionPane.showMessageDialog(null,"Nao pode alterar");
														
						}
				}

			
				break;
			case 5 :
				int verif2 = 0;
				String idd = JOptionPane.showInputDialog("Insira o codigo ID do livro que deseja excluir : ");
				long idDelete = Long.valueOf(idd);
				
				for (Livro livro3 : acervo) {
					if ((livro.getId()) == idDelete) {
						
						acervo.remove(livro3);
						
						livro.setQuantPaginas(0);
						
						verif2 = 2;
					} 
					
				}
				if (verif2 != 2) {
					
					JOptionPane.showMessageDialog(null, "Este codigo ID nao foi encontrado em nosso acervo !");
				}
				
				
				
				break;
			default :
				JOptionPane.showInputDialog("Opcao invalida !!");
				break;
				
	
				
				}
			
		}
		
	}

}

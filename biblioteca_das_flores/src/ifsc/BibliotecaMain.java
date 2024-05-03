package ifsc;

import java.util.ArrayList;
import java.util.Scanner;


public class BibliotecaMain {
	
	public static void criaAutores() {
		
	}

	public static void main(String[] args) {
		
		criaAutores();
		
		Scanner leitura = new Scanner(System.in);

		ArrayList<Livro> acervo = new ArrayList<>();
		
		int r = -1;
		while (r != 0) {
			
			System.out.println("********MENU******** \n\n 0-Sair \n 1-Cadastro \n 2-Listar \n 3-Buscar \n 4-Atualizar \n 5-Excluir\n\n********************");
			String op = leitura.nextLine();
			r = Integer.valueOf(op);
			
			switch (r) {

			case 1:
				System.out.println("Digite o nome do livro : ");
				String nomeLivro = leitura.nextLine();

				System.out.println("Digite o codigo do livro : ");
				String cod = leitura.nextLine();
				long codigo = Long.valueOf(cod);
				
				System.out.println("Digite a quantidade de paginas : ");
				String qntPg = leitura.nextLine();
				Integer qtPaginas = Integer.valueOf(qntPg);
				while(qtPaginas <= 0) {
					System.out.println("Quantidade de paginas invalida !!\nInsira novamente :");
					 qntPg = leitura.nextLine();
					 qtPaginas = Integer.valueOf(qntPg);
				}

				System.out.println("Este livro esta disponivel para aluguel ?\n1-SIM\n2-NAO\n insira sua resposta : ");
				String dp = leitura.nextLine();
				Integer disp = Integer.valueOf(dp);
				while (disp != 1 && disp != 2) {
					System.out.println("Resposta invalida !!\nInsira novamente :");
					 dp = leitura.nextLine();
					 disp = Integer.valueOf(dp);
				}
				if (disp == 1) {
					boolean disponivel=(true);
				} else if(disp == 2) {
					boolean disponivel=(false);
				} 
				
				Autor autor = new Autor();
				System.out.println("Digite o nome do autor : ");
				String nA = leitura.nextLine();
				autor.setNomedoautor(nA);

				Livro livro = new Livro();
				livro.setNomeLivro(nomeLivro);
				livro.setId(codigo);
				livro.setAutor(autor);
				livro.setDisponivel(disponivel);
				livro.setQuantPaginas(qtPaginas);

				acervo.add(livro);

				break;

			case 2:
				for (Livro livro2 : acervo) {
					System.out.println("O nome do livro :" + livro2.getNomeLivro());
					System.out.println("O codigo :" + livro2.getId());
					System.out.println("O nome do autor :" + livro2.getAutor());
					System.out.println("A disponibilidade :" + livro2.isDisponivel());
					System.out.println("A quantidade de paginas :" + livro2.getQuantPaginas());
				}

				break;

			case 3:
				int verif = 0;
				System.out.println("Insira o codigo ID do livro que deseja procurar : ");
				String id = leitura.nextLine();
				long idBusca = Long.valueOf(id);

				for (Livro livro3 : acervo) {
					if ((livro.getId()) == idBusca) {
						System.out.println("O nome do livro :" + livro3.getNomeLivro());
						System.out.println("O codigo :" + livro3.getId());
						System.out.println("O nome do autor :" + livro3.getAutor());
						System.out.println("A disponibilidade :" + livro3.isDisponivel());
						System.out.println("A quantidade de paginas :" + livro3.getQuantPaginas());

						verif = 2;
					}

				}
				if (verif != 2) {

					System.out.println("Este codigo ID nao foi encontrado em nosso acervo !");
				}

				break;
			case 4:

				System.out
						.println("O que voce deseja mudar?\n Opçoes:\nNomeLivro\nNomeAutor\nDisponivel\nQuantPaginas");
				String Categoriaalterar = leitura.nextLine();

				for (Livro livro2 : acervo) {

					if (Categoriaalterar.equals("NomeLivro")) {
						System.out.println("Qual o novo nome do livro");
						String novonome = leitura.nextLine();
						livro2.setNomeLivro(novonome);

					}

					if (Categoriaalterar.equals("NomeAutor")) {

						System.out.println("Qual o novo nome do autor");
						String novonomeautor = leitura.nextLine();
						livro2.setAutor(novonomeautor); // deve colocar obj autor aqui e nao uma string
 
					}

					if (Categoriaalterar.equals(livro2.isDisponivel())) {

						System.out.println("Qual a diponibilidade");
						String novaDispo = leitura.nextLine();
						if (novaDispo.equals("sim")) {
							livro2.setDisponivel(true);
						} else if(novaDispo.equals("não")) {
							livro2.setDisponivel(false);
						}

					}
					if (Categoriaalterar.equals(livro2.getQuantPaginas())) {

						System.out.println("Qual a quantidade de paginas");
						String nqtp = leitura.nextLine();
						Integer nQuantPg = Integer.valueOf(nqtp);
						livro2.setQuantPaginas(nQuantPg);

					}
					if (Categoriaalterar.equals(livro2.getId())) {
						System.out.println("Nao pode alterar");

					}
				}

				break;
			case 5:
				int verif2 = 0;

				System.out.println("Insira o codigo ID do livro que deseja excluir : ");
				String idd = leitura.nextLine();
				long idDelete = Long.valueOf(idd);

				for (Livro livro3 : acervo) {
					if ((livro.getId()) == idDelete) {

						acervo.remove(livro3);

						livro.setQuantPaginas(0);

						verif2 = 2;
					}

				}
				if (verif2 != 2) {

					System.out.println("Este codigo ID nao foi encontrado em nosso acervo !");
				}

				break;
			default:
				System.out.println("Opcao invalida !!");
				break;

			}

		}

	}

}

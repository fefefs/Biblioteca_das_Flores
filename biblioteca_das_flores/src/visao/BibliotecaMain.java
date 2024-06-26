package visao;

import java.util.ArrayList;
import java.util.Scanner;

import controle.LivroDAO;
import modelo.Autor;
import modelo.Livro;

public class BibliotecaMain {

	
	
	private static ArrayList<Autor> autores = new ArrayList<>();

	public static void criaAutores() {
		
	
	
		Autor vitorMartins = new Autor();
		vitorMartins.setIdAutor(1);
		vitorMartins.setNomedoautor("Vitor Martins");
		autores.add(vitorMartins);
		
		Autor ClariceLispector = new Autor();
		ClariceLispector.setIdAutor(2);
		ClariceLispector.setNomedoautor("Clarice Lispector");
		autores.add(ClariceLispector);
		
		Autor CoraCoralina = new Autor();
		CoraCoralina.setIdAutor(3);
		CoraCoralina.setNomedoautor("Cora Coraline");
		autores.add(CoraCoralina);	
		
		Autor RickRiordan = new Autor();
		RickRiordan.setIdAutor(4);
		RickRiordan.setNomedoautor("Rick Riordan");
		autores.add(RickRiordan);
		
		Autor neilGaiman = new Autor();
		neilGaiman.setIdAutor(5);
		neilGaiman.setNomedoautor("Neil Gainman");
		autores.add(neilGaiman);
		
		Autor elayneBaeta = new Autor();
		elayneBaeta.setIdAutor(6);
		elayneBaeta.setNomedoautor("Elayne Baeta");
		autores.add(elayneBaeta);
		
		Autor stephenKing = new Autor();
		stephenKing.setIdAutor(7);
		stephenKing.setNomedoautor("Stephen King");
		autores.add(stephenKing);
		
		Autor machadoAssis = new Autor();
		machadoAssis.setIdAutor(8);
		machadoAssis.setNomedoautor("Machado de Assis");
		autores.add(machadoAssis);
		
		Autor poe = new Autor();
		poe.setIdAutor(9);
		poe.setNomedoautor("Edgar Alan Poe");
		autores.add(poe);
	}
		

	public static void main(String[] args) {
		
		LivroDAO dao = LivroDAO.getInstancia();
		
		criaAutores();

		Scanner leitura = new Scanner(System.in);
		

		int r = -1;
		while (r != 0) {

			System.out.println(
					"********MENU******** \n\n 0-Sair \n 1-Cadastro \n 2-Listar \n 3-Buscar \n 4-Atualizar \n 5-Excluir\n\n********************");
			System.out.println("Digite uma das opcoes acima :");
			String op = leitura.nextLine();
			r = Integer.valueOf(op);
			if ( r < 0 || r > 5) {
				while (r < 0 || r > 5  ) {
					System.out.println("Resposta invalida !!\nInsira novamente :");
					op = leitura.nextLine();
					r = Integer.valueOf(op);
				}
			}

			switch (r) {

			case 1:
				Livro livro = new Livro();
				
				System.out.println("Digite o nome do livro : ");
				String nomeLivro = leitura.nextLine();
				livro.setNomeLivro(nomeLivro);

				System.out.println("Digite a quantidade de paginas : ");
				String qntPg = leitura.nextLine();
				Integer qtPaginas = Integer.valueOf(qntPg);
				while (qtPaginas <= 0) {
					System.out.println("Quantidade de paginas invalida !!\nInsira novamente :");
					qntPg = leitura.nextLine();
					qtPaginas = Integer.valueOf(qntPg);
				}
				livro.setQuantPaginas(qtPaginas);

				System.out.println("Este livro esta disponivel para aluguel ?\n1-SIM\n2-NAO\n insira sua resposta : ");
				String dp = leitura.nextLine();
				Integer disp = Integer.valueOf(dp);
				while (disp != 1 && disp != 2) {
					System.out.println("Resposta invalida !!\nInsira novamente :");
					dp = leitura.nextLine();
					disp = Integer.valueOf(dp);
				}
				if (disp == 1) {
					livro.setDisponivel(true);
				} else if (disp == 2) {
					livro.setDisponivel(false);
				}

				Autor autor = new Autor();
				String nomeAutor;
				System.out.println("O autor deste livro já está cadastrado em nosso acervo ?");
				for (Autor novoAutor : autores) {
					System.out.println(novoAutor.getIdAutor() + " - " + novoAutor.getNomedoautor());
				}
				
				System.out.println("\n1-SIM\n2-NAO");
				String dp1 = leitura.nextLine();
				Integer disp1 = Integer.valueOf(dp1);
				while (disp1 != 1 && disp1 != 2) {
					System.out.println("Resposta invalida !!\nInsira novamente :");
					dp1 = leitura.nextLine();
					disp1 = Integer.valueOf(dp1);
				}
				
				if (disp1 == 1) {
					System.out.println("Digite o id do autor:");
					String nA = leitura.nextLine();
					int idAutor = Integer.valueOf(nA);
					
					for (Autor autor2 : autores) {
						if (autor2.getIdAutor() == idAutor ) {
							livro.setAutor(autor2);
						}
					}
				} else if (disp1 == 2) {
					System.out.println("***Cadastre o autor(a)***\n\nInsira o nome do autor(a)");
				
					Autor autorr = new Autor();
					
					 nomeAutor = leitura.nextLine();
					autorr.setNomedoautor(nomeAutor);
					
					System.out.println("Insira o id do autor(a) :");
					String idA = leitura.nextLine();
					int idAut = Integer.valueOf(idA);
					autorr.setIdAutor(idAut);
					
					autores.add(autorr);
					livro.setAutor(autorr);
					
					System.out.println("***Autor(a) cadastrado com sucesso !!***");
					
				}
			
				dao.cadastrar(livro);
				
				System.out.println("\nLivro cadastrado com sucesso !!\n");

				break;

			case 2:
				
				for (Livro livro2 : dao.listar()) {
					System.out.println("O nome do livro :" + livro2.getNomeLivro());
					System.out.println("O codigo :" + livro2.getId());
									
					System.out.println("A disponibilidade :" + livro2.isDisponivel());
					System.out.println("A quantidade de paginas :" + livro2.getQuantPaginas());
					System.out.println("O autor :" + livro2.getAutor().getNomedoautor());
						System.out.println("  \n    ");
					
				}

				break;

			case 3:
				
				System.out.println("Insira o codigo ID do livro que deseja procurar : ");
				String id = leitura.nextLine();
			    int idBusca = Integer.valueOf(id);
			
				
				Livro livroE= dao.Buscarid(idBusca);

						System.out.println("O nome do livro :" + livroE.getNomeLivro());
						System.out.println("O codigo :" + livroE.getId());
						System.out.println("O autor :" + livroE.getAutor().getNomedoautor());
						System.out.println("A disponibilidade :" + livroE.isDisponivel());
						System.out.println("A quantidade de paginas :" + livroE.getQuantPaginas());
					

				break;
			case 4:
				
				
				int Categoriaalterar = -1;
				while(Categoriaalterar !=0) {

				System.out.println("\n//////////////\nOpçoes para alterar:\n 0-Sair de alterar\n 1-Nome do livro\n 2-Autor\n 3-Livro disponivel\n 4-Quantidade de paginas\n///////////////\n");
				System.out.println("O que voce deseja mudar? \n");
				String opcao = leitura.nextLine();
				Categoriaalterar = Integer.valueOf(opcao);
				if ( r < 0 || r > 4) {
					while ( r < 0 || r > 4 ) {
						System.out.println("Resposta invalida !!\nInsira novamente :");
						opcao = leitura.nextLine();
						Categoriaalterar = Integer.valueOf(opcao);
					}
				}
				
			if(Categoriaalterar == 0) {
				break;
			}
			

				for (Livro livro2 : dao.listar()) {
					
					System.out.println("Qual o Id do livro?");
					String idtxt = leitura.nextLine();
					int codigover = Integer.valueOf(idtxt);
					
					Livro livroA = dao.Buscarid(codigover);
					

					if (Categoriaalterar == 1) {
						
						System.out.println("Qual o novo nome do livro");
						String novonome = leitura.nextLine();
						livroA.setNomeLivro(novonome);
						System.out.println("Nome do livro atualizado com sucesso!!");
							
							dao.atualizar(livroA);
							break;		
						}
							
					else if (Categoriaalterar == 2) {

						System.out.println("O autor novo deste livro já está cadastrado em nosso acervo ?");
						for (Autor novoAutor : autores) {
							System.out.println(novoAutor.getIdAutor() + " - " + novoAutor.getNomedoautor());
						}
						
						System.out.println("\n1-SIM\n2-NAO");
						String dp2 = leitura.nextLine();
						Integer disp2 = Integer.valueOf(dp2);
						while (disp2 != 1 && disp2 != 2) {
							System.out.println("Resposta invalida !!\nInsira novamente :");
							dp2 = leitura.nextLine();
							disp2 = Integer.valueOf(dp2);
						}
						
						if (disp2 == 1) {
							System.out.println("Digite o id do novo autor:");
							String nA = leitura.nextLine();
							int idAutor = Integer.valueOf(nA);
							
							for (Autor autor2 : autores) {
								if (autor2.getIdAutor() == idAutor ) {
									livroA.setAutor(autor2);
									dao.atualizar(livroA);
								}
							}
						} else if (disp2 == 2) {
							System.out.println("***Cadastre o autor(a)***\n\nInsira o nome do autor(a)");
						
							Autor autor2 = new Autor();
							
							 nomeAutor = leitura.nextLine();
							autor2.setNomedoautor(nomeAutor);
							
							System.out.println("Insira o id do autor(a) :");
							String idA = leitura.nextLine();
							int idAut = Integer.valueOf(idA);
							autor2.setIdAutor(idAut);
							
							autores.add(autor2);
							livroA.setAutor(autor2);
							dao.atualizar(livroA);
							
							System.out.println("***Autor(a) cadastrado com sucesso !!***");
							
						}
					
						System.out.println("Autor atualizado com sucesso !!");
						break;

					}

					else if (Categoriaalterar == 3) {
						
						
						System.out.println("Qual a diponibilidade");
						System.out.println("Digite 1 se esta disponinel e 2 caso esteja alugado");
						String novaDispo = leitura.nextLine();
						int novaDispover =Integer.valueOf(novaDispo);
						if (novaDispover == 1) {
							livroA.setDisponivel(true);
						} else if (novaDispover == 2) {
							livroA.setDisponivel(false);
						}
						dao.atualizar(livroA);
						
						System.out.println("Disponibilidade atualizada com sucesso!!");

					
						break;
					}
					
					else if (Categoriaalterar == 4) {
						
						System.out.println("Qual a nova quantidade de paginas");
						String nqtp = leitura.nextLine();
						Integer nQuantPg = Integer.valueOf(nqtp);
						livroA.setQuantPaginas(nQuantPg);
						dao.atualizar(livroA);
						
						System.out.println("A quantidade de paginas atualizada com sucesso!!");

						break;

					}
					break;
				  }
				
				}
				System.out.println("//////////////Voce saiu da aba de atualizacoes/////////////\n");
			
				break;
				
			case 5:

				System.out.println("Insira o codigo ID do livro que deseja excluir : ");
				String idd = leitura.nextLine();
				int idDelete = Integer.valueOf(idd);
				
				Livro livroEncontrado = dao.Buscarid(idDelete);
				
				dao.remover(livroEncontrado);

				if (livroEncontrado != null) {
					System.out.println("Excluido com sucesso!!");
				} else {
					System.out.println("Livro não encontado no acervo!!");
				}
				
			
				break;

			}
		 
		}
		   System.out.println("Voce saiu do sistema!");
	}
	

}

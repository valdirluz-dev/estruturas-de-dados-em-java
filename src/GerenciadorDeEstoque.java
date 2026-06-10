import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GerenciadorDeEstoque {
    public static void main (String[] args){

        var sc = new Scanner(System.in);
        Map<String, Integer> produtos = new HashMap<>();
        int opcao = 500;

        do {

            String menu =
                    """
                    ================================
                    0 - sair do programa
                    1 - adicionar produtos
                    2 - remover produtos
                    3 - exibir produtos
                    4 - consultar produtos
                           
                    """;

            System.out.print(menu);
            System.out.print("Digite sua opção: ");
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Formato inválido, digite uma entrada válida");
                continue;
            }

            String produto;
            switch (opcao){
                case 0 -> {System.out.println("Encerrando...");}
                case 1 -> {
                    System.out.println("=============================== ");
                    System.out.print("Digite um produto: ");
                    produto = sc.nextLine().toLowerCase().trim();

                    produtos.put(produto, produtos.getOrDefault(produto, 0) + 1);
                    System.out.println("Produto adicionado com sucesso!");
                    System.out.println("Quantidade atual: " + produtos.get(produto));
                }
                case 2 -> {
                    System.out.print("Digite um produto: ");
                    produto = sc.nextLine().toLowerCase().trim();
                    if (!produtos.containsKey(produto)){
                        System.out.println("Produto não encontrado");
                    }
                    else if (produtos.get(produto) != 0){
                        produtos.put(produto, produtos.get(produto) - 1);
                        System.out.println("Produto removido com sucesso");
                        System.out.println("Nova quantidade: " + produtos.get(produto));
                    }
                    else {
                        System.out.println("Estoque de " + produto + " já está vazio!");
                        System.out.println("deseja remover o produto do catálogo [S/N]: ");
                        var remover = sc.nextLine().toLowerCase().trim();
                        if (remover.equals("s")){
                            produtos.remove(produto);
                            System.out.println("Produto removido com sucesso!");

                        }
                        else if (remover.equals("n")){
                            System.out.println("Produto não foi removido");
                        }
                        else{
                            System.out.println("opção inválida!");
                        }
                    }
                }
                case 3 -> {

                    if (produtos.isEmpty()){
                        System.out.println("Estoque vazio!");
                    }

                    for (Map.Entry<String, Integer> product : produtos.entrySet()){
                        System.out.println("produto: " + product.getKey() + " | quantidade: " + product.getValue());
                    }
                }
                case 4 -> {
                    System.out.print("Digite o nome do produto: ");
                    produto = sc.nextLine().toLowerCase().trim();
                    if (!produtos.containsKey(produto)){
                        System.out.println("Produto não cadastrado no estoque \n");
                    }
                    else {
                        System.out.println("Quantidade de " + produto + " : "  + produtos.get(produto) + "\n");
                    }
                }
                default -> System.out.println("Opção inválida, digite novamente \n");
            }

        } while(opcao != 0);

    }
}

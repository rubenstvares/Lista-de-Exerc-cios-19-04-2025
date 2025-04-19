import java.util.*;

class Produto {
    int codigo;
    String nome;
    double valor;
    String unidade;

    public Produto(int codigo, String nome, double valor, String unidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.unidade = unidade;
    }

    public void exibir() {
        System.out.printf("Código: %d | Nome: %s | Preço: R$ %.2f | Unidade: %s\n",
                codigo, nome, valor, unidade);
    }
}

public class LojinhaSrAbu {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, Produto> produtos = new HashMap<>();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n=== Lojinha do Sr. Abu ===");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Alterar produto");
            System.out.println("3. Excluir produto");
            System.out.println("4. Realizar venda");
            System.out.println("5. Listar produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarProduto();
                case 2 -> alterarProduto();
                case 3 -> excluirProduto();
                case 4 -> realizarVenda();
                case 5 -> listarProdutos();
                case 6 -> System.out.println("Encerrando sistema...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    static void cadastrarProduto() {
        System.out.print("Código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        if (produtos.containsKey(codigo)) {
            System.out.println("Código já existente!");
            return;
        }

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Valor unitário: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Tipo de unidade (ex: kg, un, litro): ");
        String unidade = scanner.nextLine();

        produtos.put(codigo, new Produto(codigo, nome, valor, unidade));
        System.out.println("Produto cadastrado com sucesso!");
    }

    static void alterarProduto() {
        System.out.print("Informe o código do produto a ser alterado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Produto p = produtos.get(codigo);
        if (p == null) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.print("Novo nome: ");
        p.nome = scanner.nextLine();
        System.out.print("Novo valor unitário: ");
        p.valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nova unidade: ");
        p.unidade = scanner.nextLine();

        System.out.println("Produto atualizado com sucesso!");
    }

    static void excluirProduto() {
        System.out.print("Informe o código do produto a ser excluído: ");
        int codigo = scanner.nextInt();
        if (produtos.remove(codigo) != null) {
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    static void realizarVenda() {
        double total = 0;
        Map<Produto, Integer> carrinho = new LinkedHashMap<>();

        while (true) {
            System.out.print("Código do produto (0 para finalizar): ");
            int codigo = scanner.nextInt();
            if (codigo == 0) break;

            Produto p = produtos.get(codigo);
            if (p == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            carrinho.put(p, quantidade);
            total += p.valor * quantidade;
        }

        if (carrinho.isEmpty()) {
            System.out.println("Nenhum produto foi selecionado.");
            return;
        }

        System.out.printf("Total da compra: R$ %.2f\n", total);

        // Forma de pagamento
        System.out.println("\nFormas de pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão (crédito/débito)");
        System.out.println("3. Dinheiro");
        System.out.print("Escolha: ");
        int forma = scanner.nextInt();
        scanner.nextLine();

        switch (forma) {
            case 1 -> {
                System.out.println("Chave Pix: sr.abu@lojinha.com");
                System.out.println("Pagamento via Pix realizado com sucesso!");
            }
            case 2 -> {
                System.out.print("Digite o número do cartão: ");
                String cartao = scanner.nextLine();
                System.out.print("Digite o tipo (crédito/débito): ");
                String tipo = scanner.nextLine();
                System.out.println("Pagamento no cartão (" + tipo + ") aprovado!");
            }
            case 3 -> {
                System.out.print("Digite o valor pago: R$ ");
                double pago = scanner.nextDouble();
                if (pago >= total) {
                    System.out.printf("Troco: R$ %.2f\n", pago - total);
                    System.out.println("Pagamento em dinheiro realizado com sucesso!");
                } else {
                    System.out.println("Valor insuficiente! Venda cancelada.");
                }
            }
            default -> System.out.println("Forma de pagamento inválida.");
        }
    }

    static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        System.out.println("\n=== Produtos cadastrados ===");
        for (Produto p : produtos.values()) {
            p.exibir();
        }
    }
}


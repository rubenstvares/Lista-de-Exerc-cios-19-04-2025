import java.util.ArrayList;
import java.util.Scanner;

class Paciente {
    String nome;
    int idade;
    String cpf;

    public Paciente(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("-------------------------");
    }
}

public class CadastroPacientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Sistema de Cadastro de Pacientes ===");
            System.out.println("1. Cadastrar novo paciente");
            System.out.println("2. Listar pacientes cadastrados");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // limpar buffer

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    pacientes.add(new Paciente(nome, idade, cpf));
                    System.out.println("Paciente cadastrado com sucesso!");
                    break;

                case 2:
                    if (pacientes.isEmpty()) {
                        System.out.println("Nenhum paciente cadastrado.");
                    } else {
                        System.out.println("\n=== Lista de Pacientes ===");
                        for (Paciente p : pacientes) {
                            p.exibirInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}

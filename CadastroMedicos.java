import java.util.ArrayList;
import java.util.Scanner;

class Medico {
    String nome;
    String especialidade;
    int crm;

    public Medico(String nome, String especialidade, int crm) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public void exibirInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("CRM: " + crm);
        System.out.println("----------------------------");
    }
}

public class CadastroMedicos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Medico> medicos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Menu de Cadastro de Médicos ===");
            System.out.println("1. Cadastrar novo médico");
            System.out.println("2. Listar médicos cadastrados");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do médico: ");
                    String nome = scanner.nextLine();

                    System.out.print("Especialidade: ");
                    String especialidade = scanner.nextLine();

                    System.out.print("CRM: ");
                    int crm = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer

                    Medico novoMedico = new Medico(nome, especialidade, crm);
                    medicos.add(novoMedico);
                    System.out.println("Médico cadastrado com sucesso!");
                    break;

                case 2:
                    if (medicos.isEmpty()) {
                        System.out.println("Nenhum médico cadastrado ainda.");
                    } else {
                        System.out.println("\n=== Lista de Médicos ===");
                        for (Medico m : medicos) {
                            m.exibirInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}

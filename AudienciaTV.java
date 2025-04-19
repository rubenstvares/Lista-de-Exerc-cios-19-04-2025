import java.util.Scanner;

public class AudienciaTV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPessoas = 0;
        int canal4 = 0, canal5 = 0, canal7 = 0, canal12 = 0;

        while (true) {
            System.out.print("Número do canal (4, 5, 7, 12 ou 0 para encerrar): ");
            int canal = scanner.nextInt();

            if (canal == 0) break;

            if (canal != 4 && canal != 5 && canal != 7 && canal != 12) {
                System.out.println("Canal inválido.");
                continue;
            }

            System.out.print("Número de pessoas assistindo: ");
            int pessoas = scanner.nextInt();

            totalPessoas += pessoas;

            if (canal == 4) canal4 += pessoas;
            else if (canal == 5) canal5 += pessoas;
            else if (canal == 7) canal7 += pessoas;
            else if (canal == 12) canal12 += pessoas;
        }

        System.out.println("\nPorcentagem de audiência:");
        if (totalPessoas == 0) {
            System.out.println("Nenhum dado foi inserido.");
        } else {
            System.out.printf("Canal 4: %.2f%%\n", (canal4 * 100.0) / totalPessoas);
            System.out.printf("Canal 5: %.2f%%\n", (canal5 * 100.0) / totalPessoas);
            System.out.printf("Canal 7: %.2f%%\n", (canal7 * 100.0) / totalPessoas);
            System.out.printf("Canal 12: %.2f%%\n", (canal12 * 100.0) / totalPessoas);
        }

        scanner.close();
    }
}

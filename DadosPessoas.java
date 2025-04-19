import java.util.Scanner;

public class DadosPessoas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] idades = new int[10];
        double[] pesos = new double[10];
        double[] alturas = new double[10];

        // Coleta de dados
        for (int i = 0; i < 10; i++) {
            System.out.println("\nPessoa " + (i + 1) + ":");
            System.out.print("Idade: ");
            idades[i] = scanner.nextInt();

            System.out.print("Peso (kg): ");
            pesos[i] = scanner.nextDouble();

            System.out.print("Altura (m): ");
            alturas[i] = scanner.nextDouble();
        }

        // Cálculo da média das idades
        int somaIdades = 0;
        for (int idade : idades) {
            somaIdades += idade;
        }
        double mediaIdades = somaIdades / 10.0;

        // Total com peso > 90kg e altura < 1.50m
        int contadorPesoAltura = 0;
        for (int i = 0; i < 10; i++) {
            if (pesos[i] > 90 && alturas[i] < 1.50) {
                contadorPesoAltura++;
            }
        }

        // Porcentagem com idade entre 10 e 30 e altura > 1.90
        int totalAltos = 0;
        int faixaEtariaAltos = 0;
        for (int i = 0; i < 10; i++) {
            if (alturas[i] > 1.90) {
                totalAltos++;
                if (idades[i] >= 10 && idades[i] <= 30) {
                    faixaEtariaAltos++;
                }
            }
        }
        double porcentagemAltos = (totalAltos > 0) ? (faixaEtariaAltos * 100.0 / totalAltos) : 0;

        // Apresentação dos resultados
        System.out.println("\n--- Resultados ---");
        System.out.printf("Média das idades: %.2f anos\n", mediaIdades);
        System.out.println("Total de pessoas com peso > 90kg e altura < 1.50m: " + contadorPesoAltura);
        System.out.printf("Porcentagem de pessoas entre 10 e 30 anos com mais de 1.90m: %.2f%%\n", porcentagemAltos);

        // Opção para exibir todos os dados
        System.out.print("\nDeseja ver os dados de todas as pessoas? (s/n): ");
        char opcao = scanner.next().toLowerCase().charAt(0);

        if (opcao == 's') {
            System.out.println("\n--- Dados coletados ---");
            for (int i = 0; i < 10; i++) {
                System.out.printf("Pessoa %d - Idade: %d, Peso: %.2fkg, Altura: %.2fm\n",
                        (i + 1), idades[i], pesos[i], alturas[i]);
            }
        }

        scanner.close();
    }
}

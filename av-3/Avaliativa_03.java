import java.util.Arrays;
import java.util.Random;
import java.util.Random;

public class Avaliativa_03 {

  public static void main(String[] args) {
    int n = 6; // Número de linhas
    int m = 5; // Número de colunas

    int[][] matriz = new int[n][m];

    preencherMatriz(matriz); // Preenche a matriz com números aleatórios
    int[][] matrizComMenorPrimeiro = trocarMenorParaPrimeiro(matriz); // Troca o menor elemento para a primeira posição
    int[][] matrizOrdenada = ordenarPrimeiraColuna(matrizComMenorPrimeiro); // Ordena a primeira coluna

    System.out.println("a) Matriz Original:");
    exibirMatriz(matriz);

    System.out.println("\nb) Matriz com Menor na Primeira Posição:");
    exibirMatriz(matrizComMenorPrimeiro);

    System.out.println(
      "\nc) Matriz com Menor na 1ª Posição e 1ª Coluna Ordenada:"
    );
    exibirMatriz(matrizOrdenada);
  }

  public static void preencherMatriz(int[][] matriz) {
    Random random = new Random();
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz[i].length; j++) {
        matriz[i][j] = random.nextInt(100); // Gera números inteiros de 0 a 99 (ajuste conforme necessário)
      }
    }
  }

  public static int[][] trocarMenorParaPrimeiro(int[][] matriz) {
    int[][] copiaMatriz = new int[matriz.length][matriz[0].length];
    for (int i = 0; i < matriz.length; i++) {
      System.arraycopy(matriz[i], 0, copiaMatriz[i], 0, matriz[i].length);
    }

    for (int i = 0; i < matriz.length; i++) {
      int menor = copiaMatriz[i][0];
      int indiceMenor = 0;
      for (int j = 1; j < matriz[i].length; j++) {
        if (copiaMatriz[i][j] < menor) {
          menor = copiaMatriz[i][j];
          indiceMenor = j;
        }
      }
      int temp = copiaMatriz[i][0];
      copiaMatriz[i][0] = menor;
      copiaMatriz[i][indiceMenor] = temp;
    }

    return copiaMatriz;
  }

  public static int[][] ordenarPrimeiraColuna(int[][] matriz) {
    int[][] copiaMatriz = new int[matriz.length][matriz[0].length];
    for (int i = 0; i < matriz.length; i++) {
      System.arraycopy(matriz[i], 0, copiaMatriz[i], 0, matriz[i].length);
    }

    Arrays.sort(copiaMatriz, (a, b) -> Integer.compare(a[0], b[0]));

    return copiaMatriz;
  }

  public static void exibirMatriz(int[][] matriz) {
    for (int[] linha : matriz) {
      for (int valor : linha) {
        System.out.print(valor + "\t");
      }
      System.out.println();
    }
  }
}

import java.util.Scanner;

public class main {
	public static int vetorDeSudokus[][][] = { { { 1, 2, 3, 4 }, { 4, 3, 2, 1 }, { 3, 4, 1, 2 }, { 2, 1, 4, 3 } },

			{ { 2, 1, 4, 3 }, { 3, 4, 1, 2 }, { 1, 2, 3, 4 }, { 4, 3, 2, 1 } },

			{ { 3, 4, 1, 2 }, { 2, 1, 4, 3 }, { 4, 3, 2, 1 }, { 1, 2, 3, 4 } },

			{ { 4, 3, 1, 2 }, { 1, 2, 4, 3 }, { 3, 4, 2, 1 }, { 2, 1, 3, 4 } } };

	public static void main(String[] args) {
		int matrizDoSudoku[][] = new int[4][4];
		jogarSudoku(matrizDoSudoku);
	}

	public static void sorteiaSudoku(int matriz[][], int vetorDeMatrizes[][][]) {
		int t = (int) Math.random() * vetorDeMatrizes.length;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {

				matriz[i][j] = vetorDeMatrizes[t][i][j];
			}
		}
	}

	public static void imprimeSudoku(int matriz[][]) {
		System.out.println("|---|---|---|---|");
		for (int i = 0; i < 4; i++) {
			System.out.print("|");
			for (int j = 0; j < 4; j++) {
				if (matriz[i][j] == 0) {
					System.out.print("   |");
				} else
					System.out.print(" " + matriz[i][j] + " |");
			}
			System.out.println("\n|---|---|---|---|");
		}
	}

	public static void setaNivelDoSudoku(int n, int matriz[][]) {
		
		int i, j, contador = 0;
		
		switch (n) {
		case 1: // Nível fácil
			do {
				i = (int) (Math.random() * 4);
				j = (int) (Math.random() * 4);
				if (matriz[i][j] != 0) {
					matriz[i][j] = 0;
					contador++;
				}
			} while (contador < 4);
			break;
		case 2: // Nível médio
			do {
				i = (int) (Math.random() * 4);
				j = (int) (Math.random() * 4);
				if (matriz[i][j] != 0) {
					matriz[i][j] = 0;
					contador++;
				}
			} while (contador < 8);
			break;
		case 3: // Nível difícil
			do {
				i = (int) (Math.random() * 4);
				j = (int) (Math.random() * 4);
				if (matriz[i][j] != 0) {
					matriz[i][j] = 0;
					contador++;
				}
			} while (contador < 12);
			break;
		default:
			System.out.println("Opções válidas: 1 (fácil), 2 (médio) e 3 (difícil)");
		}

	}

	public static boolean verificaSudoku(int matriz[][]) {
		// Verifica linhas
		for (int i = 0; i < 4; i++)
			if ((matriz[i][0] + matriz[i][1] + matriz[i][2] + matriz[i][3]) != 10)
				return false;

		// Verifica colunas
		for (int j = 0; j < 4; j++)
			if ((matriz[0][j] + matriz[1][j] + matriz[2][j] + matriz[3][j]) != 10)
				return false;
		// Verifica submatriz
		if ((matriz[0][0] + matriz[0][1] + matriz[1][0] + matriz[1][1]) != 10)
			return false;
		// Verifica submatriz
		if ((matriz[0][2] + matriz[0][3] + matriz[1][2] + matriz[1][3]) != 10)
			return false;
		// Verifica submatriz
		if ((matriz[2][0] + matriz[2][1] + matriz[3][0] + matriz[3][1]) != 10)
			return false;
		// Verifica submatriz
		if ((matriz[2][2] + matriz[2][3] + matriz[3][2] + matriz[3][3]) != 10)
			return false;
		return true;
	}
	
	
	public static boolean validarMatriz(int mat[][])
	{
		
		
		for(int i= 0; i < mat.length; i++)
		{
			for(int j =0; j <mat[0].length; j++)
			{
				if(mat[i][j] == 0){
					return false;
				}
				
			}
		}
		return true;
	}

	public static void jogarSudoku(int matriz[][]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Por favor, Escolha uma dificuldade: 1 - Facil, 2 - Medio, 3 - Dificil");
		int dificuldade = sc.nextInt();
		
		int mat[][] = new int[4][4];
		
		sorteiaSudoku(mat,vetorDeSudokus);
		setaNivelDoSudoku(dificuldade, mat);
		imprimeSudoku(mat);
		
		do{
			
			System.out.println("Digite o valor da celula: ");
			int valor = sc.nextInt();
			System.out.println("Escolha a Linha disponivel: ");
			int linha = sc.nextInt();
			System.out.println("Escolha a Coluna disponivel: ");
			int coluna = sc.nextInt();
			
			if(mat[linha][coluna] == 0 && valor > 0 && valor < 5)
			{
				mat[linha][coluna] =valor;
			}else {
				System.out.println("Valor indisponivel");
			}
			
			imprimeSudoku(mat);
			System.out.println();	
			
			if(verificaSudoku(mat) == true ){
				System.out.println("Parabens você venceu o jogo!!");
			}
			else if(validarMatriz(mat) == true)
			{
				System.out.println("Infelizmente você perdeu!!");
				System.exit(coluna);
			}
			
			
		}while(verificaSudoku(mat) == false);
		
		
	}
}
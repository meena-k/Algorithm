package part3;

import java.util.Scanner;

/* 2580  스도쿠 : 백트래킹   */

public class Main_2580 {

	public static int[][] map = new int[9][9];
	public static int currentRow = 0, currentCol = 0;

	public static boolean sdoku() {

		if (findZero())
			return true;

		for (int i = 0; i < 9; i++) {// 유망성 검사
			if (isPossible(i + 1, currentRow, currentCol)) {
				map[currentRow][currentCol] = i + 1;
				if (sdoku()) {
					return true;
				}
				map[currentRow][currentCol] = 0;
			}
		}
		return false;
	}

	private static boolean isPossible(int num, int row, int col) {
		// ㅡ ㅣ
		for (int i = 0; i < 9; i++) {
			if (map[row][i] == num || map[i][col] == num) {
				return false;
			}
		}

		// ㅁ
		int r = (row / 3) * 3;
		int c = (col / 3) * 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (map[r + i][c + j] == num) {
					return false;
				}
			}
		}

		return true;

	}

	public static boolean findZero() {
		// find zero
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] == 0) {
					currentRow = i;
					currentCol = j;
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// map 채우기
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sdoku();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}

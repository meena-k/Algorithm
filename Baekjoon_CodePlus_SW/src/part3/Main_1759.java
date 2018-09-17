package part3;

import java.util.Arrays;
import java.util.Scanner;

/* 1759. 암호 만들기 : 재귀함수
 * 알파벳을 먼저 정렬해 놓고 사용할지 말지 결정
 * 1. 재귀함수 만들기 : go(만들어야 하는 길이, 사용할 수 있는 알파벳, 현재까지 만든 암호, 알파벳 인덱스)
 * 2. 불가능한 경우 생각
 * 3. 정답을 찾은 경우 생각
 * 4. 다음 경우 생각 - 사용 / 안사용    */

public class Main_1759 {
	public static boolean check(String password) {
		int ja = 0;
		int mo = 0;

		for (char x : password.toCharArray()) {
			if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				mo += 1;
			} else {
				ja += 1;
			}
		}
		return ja >= 2 && mo >= 1;
	}

	private static void go(int leng, String[] alpha, String password, int i) {
		if (password.length() == leng) {
			if (check(password)) {
				System.out.println(password);
			}
			return;
		}

		if (i >= alpha.length)
			return;

		go(leng, alpha, password + alpha[i], i + 1);
		go(leng, alpha, password, i + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int L = sc.nextInt();
		int C = sc.nextInt();

		String[] alpha = sc.nextLine().split(" ");
		Arrays.sort(alpha);

		go(L, alpha, "", 0);
	}

}

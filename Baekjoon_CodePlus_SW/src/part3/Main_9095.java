package part3;

import java.util.Scanner;

/* 9095. 1,2,3 더하기 : 재귀함수 */
public class Main_9095 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		while (c-- > 0) {
			int goal = sc.nextInt();
			System.out.println(go(0, 0, goal));
		}
	}

	public static int go(int num, int sum, int goal) {
		int count = 0;

		if (num < 0)
			return 0;
		if (sum > goal)
			return 0;
		if (sum == goal)
			return 1;

		for (int i = 1; i < 4; i++) {
			count += go(num + 1, sum + i, goal);
		}

		return count;
	}
}

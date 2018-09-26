package part3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1963. 소수경로 : BFS */
public class Main_1963 {

	public static int change(int num, int index, int digit) {
		if (index == 0 && digit == 0) {
			return -1;
		}
		String s = Integer.toString(num);
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(index, (char) (digit + '0'));
		return Integer.parseInt(sb.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 에라토스테네스의 체 이용하여 소수구하기 알고리즘
		boolean[] prime = new boolean[10000];

		for (int i = 2; i <= 10000; i++) {
			if (prime[i] == false) {
				for (int j = i * i; j <= 10000; j += i) {
					prime[j] = true;
				}
			}
		}

		for (int i = 0; i <= 10000; i++) {
			prime[i] = !prime[i];
		}

		int T = sc.nextInt();

		while (T-- > 0) {
			int originPW = sc.nextInt();
			int changePW = sc.nextInt();

			boolean[] check = new boolean[10001];
			int[] dist = new int[10001];

			dist[originPW] = 0;
			check[originPW] = true;

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(originPW);

			while (!queue.isEmpty()) {
				int now = queue.poll();
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j <= 9; j++) {
						int next = change(now, i, j);
						if (next != -1) {

							if (prime[next] && check[next] == false) {
								queue.add(next);
								dist[next] = dist[now] + 1;
								check[next] = true;
							}
						}
					}
				}
			}
			System.out.println(dist[changePW]);
		}

	}

}
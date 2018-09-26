package part3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 9019. DSLR: BFS */
public class Main_9019 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			boolean[] check = new boolean[10001];
			int[] dist = new int[10001];
			int[] from = new int[10001];
			char[] how = new char[10001];

			check[A] = true;
			dist[A] = 0;
			from[A] = -1;

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(A);

			while (!queue.isEmpty()) {
				int now = queue.poll();

				int next = (now * 2) % 10000;
				if (check[next] == false) {
					queue.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = 'D';
				}

				next = now - 1;
				if (next == -1)
					next = 9999;
				if (check[next] == false) {
					queue.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = 'S';
				}

				next = (now % 1000) * 10 + (now / 1000);
				if (check[next] == false) {
					queue.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = 'L';
				}

				next = (now / 10) + (now % 10) * 1000;
				if (check[next] == false) {
					queue.add(next);
					check[next] = true;
					dist[next] = dist[now] + 1;
					from[next] = now;
					how[next] = 'R';
				}

			}

			StringBuilder ans = new StringBuilder();
			while (B != A) {
				ans.append(how[B]);
				B = from[B];
			}
			System.out.println(ans.reverse());
		}
	}
}

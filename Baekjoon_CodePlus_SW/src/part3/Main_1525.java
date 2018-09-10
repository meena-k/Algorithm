package part3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1525. 퍼즐 : BFS */
public class Main_1525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[9];
		int origin = 0;
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int testCase = 0; testCase < 9; testCase++) {
			int x = sc.nextInt();
			if (x == 0) {
				origin = testCase;
			}
			a[testCase] = x;
		}

		int[] to = new int[9];
		int[] dist = new int[9];

		to[origin] = -1;
		dist[origin] = 0;

		queue.add(origin);
		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now - 1 > 0) {
				if (a[now - 1] == now + 1) {
					queue.add(now - 1);
					a[now] = now + 1;
					a[now - 1] = 0;
					to[now] = now + 3;
					dist[now - 1] = dist[now] + 1;
				}
			}
			if (now + 1 < 8) {
				if (a[now + 1] == now + 1) {
					queue.add(now + 1);
					a[now] = now + 1;
					a[now + 1] = 0;
					to[now] = now + 1;
					dist[now + 1] = dist[now] + 1;
				}
			}

			if (now - 3 > 0) {
				if (a[now - 3] == now + 1) {
					queue.add(now - 3);
					a[now] = now + 1;
					a[now - 3] = 0;
					to[now] = now - 3;
					dist[now - 3] = dist[now] + 1;
				}
			}
			if (now + 3 < 9) {
				if (a[now + 3] == now + 1) {
					queue.add(now + 3);
					a[now] = now + 1;
					a[now + 3] = 0;
					to[now] = now + 3;
					dist[now + 3] = dist[now] + 1;
				}
			}
		}

		while (to[origin] != -1) {
			origin = to[origin];
		}

		System.out.println(dist[origin]);
	}
}

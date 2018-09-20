package part3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_TEST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] check = new boolean[100001];
		int[] dist = new int[100001];

		int n = sc.nextInt();
		int k = sc.nextInt();

		queue.add(n);
		check[n] = true;
		dist[n] = 0;

		while (!queue.isEmpty()) {
			int next = queue.poll();

			if (next - 1 > 0) {
				if (!check[next - 1]) {
					dist[next - 1] = dist[next] + 1;
					check[next - 1] = true;
					queue.add(next - 1);
				}
			}
			if (next + 1 < 100000) {
				if (!check[next + 1]) {
					dist[next + 1] = dist[next] + 1;
					check[next + 1] = true;
					queue.add(next + 1);
				}
			}
			if (next * 2 < 100000) {
				if (!check[next * 2]) {
					dist[next * 2] = dist[next] + 1;
					check[next * 2] = true;
					queue.add(next * 2);
				}
			}
		}

		System.out.println(dist[k]);
	} // end main

} // end class

package part3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1697. 숨바꼭질 : BFS */
public class Main_1697 {

	final static int MAX = 100000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<Integer>();

		// 이전에 방문했는지 확인
		boolean[] check = new boolean[MAX];

		// n까지 가는거리 저장하는 배열
		int[] dist = new int[MAX];

		int N = sc.nextInt();
		int K = sc.nextInt();

		check[N] = true;
		dist[N] = 0;

		queue.add(N);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now - 1 >= 0) {
				if (check[now - 1] == false) {
					queue.add(now - 1);
					check[now - 1] = true;
					dist[now - 1] = dist[now] + 1;
				}
			}

			if (now + 1 < MAX) {
				if (check[now + 1] == false) {
					queue.add(now + 1);
					check[now + 1] = true;
					dist[now + 1] = dist[now] + 1;
				}
			}

			if (now * 2 < MAX) {
				if (check[now * 2] == false) {
					queue.add(now * 2);
					check[now * 2] = true;
					dist[now * 2] = dist[now] + 1;
				}
			}
		}

		System.out.println(dist[K]);

	}

}
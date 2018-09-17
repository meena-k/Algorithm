package part3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Basket {
	public int A;
	public int B;
	public int C;

	public Basket(int A, int B, int C) {
		this.A = A;
		this.B = B;
		this.C = C;
	}
}

/* 2251. 물통 : BFS */
public class Main_2251 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] ans = new boolean[201];
		boolean[][][] visit = new boolean[201][201][201];

		int maxA = sc.nextInt();
		int maxB = sc.nextInt();
		int maxC = sc.nextInt();

		Queue<Basket> queue = new LinkedList<Basket>();
		queue.add(new Basket(0, 0, maxC));

		while (!queue.isEmpty()) {
			int nowA = queue.peek().A;
			int nowB = queue.peek().B;
			int nowC = queue.peek().C;
			queue.poll();

			if (visit[nowA][nowB][nowC]) {
				continue;
			}
			visit[nowA][nowB][nowC] = true;
			if (nowA == 0) {
				ans[nowC] = true;
			}

			// C->A : C에 물이 있고, A가 가득 안차있을 때
			if (nowC != 0 && nowA < maxA) {
				int leftA = maxA - nowA;

				// C의 물 > A의 남은 공간
				if (nowC > leftA) {
					queue.add(new Basket(maxA, nowB, nowC - leftA));
				} else { // C의 물 <= A의 남은 공간
					queue.add(new Basket(nowA + nowC, nowB, 0));
				}
			} // end if (C->A)

			// C-> B : C에 물이 있고, B가 가득 안차있을 때
			if (nowC != 0 && nowB < maxB) {
				int leftB = maxB - nowB;

				// C의 물 > B의 남은 공간
				if (nowC > leftB) {
					queue.add(new Basket(nowA, maxB, nowC - leftB));
				} else { // C의 물 <= B의 남은 공간
					queue.add(new Basket(nowA, nowB + nowC, 0));
				}
			} // end if (C->B)

			// B->A : B에 물이 있고, A가 가득 안차있을 때
			if (nowB != 0 && nowA < maxA) {
				int leftA = maxA - nowA;

				// B의 물 > A의 남은 공간
				if (nowB > leftA) {
					queue.add(new Basket(maxA, nowB - leftA, nowC));
				} else { // B의 물 <= A의 남은 공간
					queue.add(new Basket(nowA + nowB, 0, nowC));
				}
			} // end if (B->A)

			// B->C : B에 물이 있고, C가 가득 안차있을 때
			if (nowB != 0 && nowC < maxC) {
				int leftC = maxC - nowC;

				// B의 물 > C의 남은 공간
				if (nowB > leftC) {
					queue.add(new Basket(nowA, nowB - leftC, maxC));
				} else { // B의 물 <=C의 남은 공간
					queue.add(new Basket(nowA, 0, nowC + nowB));
				}
			} // end if (B->C)

			// A->C : A에 물이 있고, C가 가득 안차있을 때
			if (nowA != 0 && nowC < maxC) {
				int leftC = maxC - nowC;

				// A의 물 > C의 남은 공간
				if (nowA > leftC) {
					queue.add(new Basket(nowA - leftC, nowB, maxC));
				} else { // A의 물 <=C의 남은 공간
					queue.add(new Basket(0, nowB, nowC + nowA));
				}
			} // end if (A->C)

			// A->B : A에 물이 있고, B가 가득 안차있을 때
			if (nowA != 0 && nowB < maxB) {
				int leftB = maxB - nowB;

				// A의 물 > B의 남은 공간
				if (nowA > leftB) {
					queue.add(new Basket(nowA - leftB, maxB, nowC));
				} else { // A의 물 <=B의 남은 공간
					queue.add(new Basket(0, nowB + nowA, nowC));
				}
			} // end if (A->B)
		} // end while
		for (int i = 0; i <= maxC; i++) {
			if (ans[i] == true) {
				System.out.print(i + " ");
			}
		}
	} // end main
} // end class

package samsung;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 뱀 {
	static Queue<POS> tail = new LinkedList<POS>();
	static HashMap<Integer, Character> inform = new HashMap<Integer, Character>();
	static boolean[][] apple, snake;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;
	static int t;

	public static class POS {
		int x;
		int y;

		POS(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		t = 0; // 걸린 시간 초기화

		N = sc.nextInt();
		apple = new boolean[N][N];
		snake = new boolean[N][N];

		int K = sc.nextInt();
		while (K-- > 0) {
			apple[sc.nextInt() - 1][sc.nextInt() - 1] = true;
		}

		int L = sc.nextInt();
		while (L-- > 0) {
			inform.put(sc.nextInt(), sc.next().toUpperCase().charAt(0));
		}
		tail.add(new POS(0, 0));

		bfs(0, 0, 1);
		System.out.println(t);
	}

	public static void bfs(int x, int y, int len) {
		int dir = 0;
		int nx = x;
		int ny = y;

		while (true) {
			t += 1;

			nx += dx[dir];
			ny += dy[dir];

			if (nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || len > N) {
				return;
			}

			if (snake[nx][ny]) {
				return;
			}

			snake[nx][ny] = true;
			tail.add(new POS(nx, ny));

			if (apple[nx][ny]) { // 사과 존재
				len += 1;
				apple[nx][ny] = false;
			} else {
				POS pos = tail.poll();
				snake[pos.x][pos.y] = false;
			}

			if (inform.containsKey(t)) {
				if (inform.get(t) == 'D') { // 오른쪽 90도 회전
					dir = (dir + 1) % 4;
				} else if (inform.get(t) == 'L') { // 왼쪽 90도 회전
					if (dir == 0) {
						dir = 3;
					} else {
						dir = dir - 1;
					}
				}
			}
		}

	}
}

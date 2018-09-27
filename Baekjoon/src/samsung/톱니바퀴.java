package samsung;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// bit mask 입력어케받음..
// 0번을 12시방향 2번을 3시방향으로 설정
public class 톱니바퀴 {
	static Deque<Node> deque = new LinkedList<Node>();
	static int ans = 0;

	static class Node {
		int idx;
		int dir;
		int range;

		public Node(int idx, int dir, int range) {
			this.idx = idx;
			this.dir = dir;
			this.range = range;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = (line.charAt(j)) - '0';
			}
		}
		int num = sc.nextInt();

		// queue에 실행작업 넣기
		while (num-- > 0) {
			int idx = sc.nextInt();
			int dir = sc.nextInt();
			deque.add(new Node(idx - 1, dir, 0));
		}

		rotateWheel(gear);
		System.out.println(ans);

	}

	public static void print(int[][] gear) {
		for (int i = 0; i < 4; i++) {
			ans += ((gear[i][0]) * Math.pow(2, i));
		}
	}

	public static void rotateWheel(int[][] gear) {
		int[][] wheel = new int[4][8];

		if (deque.isEmpty()) {
			print(gear);
			return;
		} else {
			// 첫번째 작업부터 수행
			Node node = deque.removeFirst();
			int idx = node.idx;

			switch (node.dir) {
			// 반시계방향 <--
			case -1:
				for (int i = 0; i < 4; i++) {
					// 이전 정보 복사
					wheel[i] = Arrays.copyOf(gear[i], 8);
				}

				for (int i = 0; i < 7; i++) {
					// 작업할 라인 다시 복사
					wheel[idx][i] = gear[idx][i + 1];
				}

				wheel[idx][7] = gear[idx][0];

				if (node.range == 0) {
					if (idx == 1 || idx == 2) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					} else if (idx == 0) {
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					} else if (idx == 3) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
					}
				} else if (node.range == 1) {
					if (idx == 1 || idx == 2) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
					} else if (idx == 3) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
					}
				} else if (node.range == 2) {
					if (idx == 1 || idx == 2) {
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					} else if (idx == 0) {
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					}
				}
				rotateWheel(wheel);
				break;

			// 시계 방향 -->
			case 1:
				for (int i = 0; i < 4; i++) {
					// 이전 정보 복사
					wheel[i] = Arrays.copyOf(gear[i], 8);
				}
				for (int i = 0; i < 7; i++) {
					// 작업할 라인 다시 복사
					wheel[idx][i + 1] = gear[idx][i];
				}
				wheel[idx][0] = gear[idx][7];

				if (node.range == 0) {
					if (idx == 1 || idx == 2) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					} else if (idx == 0) {
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					} else if (idx == 3) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
					}
				} else if (node.range == 1) {
					if (idx == 1 || idx == 2) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
					} else if (idx == 3) {
						if ((gear[idx][6] != wheel[idx - 1][2])) {
							deque.addFirst(new Node(idx - 1, (node.dir) * (-1), 1));
						}
					}
				} else if (node.range == 2) {
					if (idx == 1 || idx == 2) {
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					} else if (idx == 0) {
						if ((gear[idx][2] != wheel[idx + 1][6])) {
							deque.addFirst(new Node(idx + 1, (node.dir) * (-1), 2));
						}
					}
				}
				rotateWheel(wheel);

				break;
			}
		}

	} // end rotateWheel

}

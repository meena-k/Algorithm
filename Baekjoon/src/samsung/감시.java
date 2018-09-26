package samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 감시 {
	static ArrayList<Node> cctv = new ArrayList<>();
	static int N, M, ans=Integer.MAX_VALUE;
	static int[][] map;

	static class Node {
		int value;
		int col;
		int row;

		public Node(int v, int c, int r) {
			value = v;
			col = c;
			row = r;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctv.add(new Node(map[i][j], i, j));
				}
			}
		}
		search(0, map);
		System.out.println(ans);
	}

	private static void search(int cctvIndex, int[][] prev) {
		int[][] visited = new int[N][M];
		if (cctvIndex == cctv.size()) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (prev[i][j] == 0) {
						temp++;
					}
				}
			}
			if (temp < ans) {
				ans = temp;
			}
		} else {
			Node node = cctv.get(cctvIndex);

			switch (node.value) {
			case 1:
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < N; i++) {
						// 이전 감시 현황 가져옴
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// 감시여부 체크
					detect(visited, node.col, node.row, k);
					// 다음 CCTV 탐색
					search(cctvIndex + 1, visited);
				}
				break;
			case 2:
				for (int k = 0; k < 2; k++) {
					for (int i = 0; i < N; i++) {
						// 이전 감시 현황 가져옴
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// 감시여부 체크
					detect(visited, node.col, node.row, k);
					detect(visited, node.col, node.row, k + 2);
					// 다음 CCTV 탐색
					search(cctvIndex + 1, visited);
				}
				break;
			case 3:
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < N; i++) {
						// 이전 감시 현황 가져옴
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// 감시여부 체크
					detect(visited, node.col, node.row, k);
					detect(visited, node.col, node.row, (k + 1) % 4);
					// 다음 CCTV 탐색
					search(cctvIndex + 1, visited);
				}
				break;
			case 4:
				for (int k = 0; k < 4; k++) {
					for (int i = 0; i < N; i++) {
						// 이전 감시 현황 가져옴
						visited[i] = Arrays.copyOf(prev[i], M);
					}
					// 감시여부 체크
					detect(visited, node.col, node.row, k);
					detect(visited, node.col, node.row, (k + 1) % 4);
					detect(visited, node.col, node.row, (k + 2) % 4);
					// 다음 CCTV 탐색
					search(cctvIndex + 1, visited);
				}
				break;
			case 5:
				for (int i = 0; i < N; i++) {
					// 이전 감시 현황 가져옴
					visited[i] = Arrays.copyOf(prev[i], M);
				}
				// 감시여부 체크
				detect(visited, node.col, node.row, 0);
				detect(visited, node.col, node.row, 1);
				detect(visited, node.col, node.row, 2);
				detect(visited, node.col, node.row, 3);
				// 다음 CCTV 탐색
				search(cctvIndex + 1, visited);
				break;
			}
		}
	}

	private static void detect(int[][] visited, int col, int row, int direct) {
		switch (direct) {
		// <--
		case 0:
			for (int i = row; i >= 0; i--) {
				if (map[col][i] == 6) {
					break;
				}
				visited[col][i] = 7;
			}
			break;
		// ^ 위
		case 1:
			for (int i = col; i >= 0; i--) {
				if (map[i][row] == 6) {
					break;
				}
				visited[i][row] = 7;
			}
			break;
		// -->
		case 2:
			for (int i = row; i < M; i++) {
				if (map[col][i] == 6) {
					break;
				}
				visited[col][i] = 7;
			}
			break;
		// | 아래
		case 3:
			for (int i = col; i < N; i++) {
				if (map[i][row] == 6) {
					break;
				}
				visited[i][row] = 7;
			}
			break;
		}
	}
}

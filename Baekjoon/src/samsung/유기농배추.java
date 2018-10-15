package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {
	static boolean[][] cabbage;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int M, N;
	static int worm;

	public static class Position {
		int col, row;

		Position(int col, int row) {
			this.col = col;
			this.row = row;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			worm = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			visited = new boolean[N][M];
			cabbage = new boolean[N][M];

			while (K-- > 0) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				cabbage[n][m] = true;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (cabbage[i][j]) {
						findworm(j, i);
					}
				}
			}
			System.out.println(worm);
		}
	}

	public static void findworm(int col, int row) {
		if (visited[row][col]) {
			return;
		}
		Queue<Position> wormPos = new LinkedList<Position>();
		wormPos.add(new Position(col, row));
		visited[row][col] = true;

		while (!wormPos.isEmpty()) {
			Position pos = wormPos.poll();
			for (int i = 0; i < 4; i++) {
				int nx = pos.col + dx[i];
				int ny = pos.row + dy[i];

				if ((nx >= 0 && nx < M && ny >= 0 && ny < N) && !visited[ny][nx]) {
					if (cabbage[ny][nx]) {
						visited[ny][nx] = true;
						wormPos.add(new Position(nx, ny));
					}
				}
			}
		}
		worm += 1;

	}

}

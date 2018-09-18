package part3;

import java.util.Scanner;

/* 9663. N-Queen : 백트래킹
 * 같은 열에 있거나 대각선에 위치할 경우를 제외하고 찾기 */
public class Main_9663 {
	public static int[] cols;
	public static int N;
	public static int ans;

	public static boolean isPossible(int level) {
		for (int i = 0; i < level; i++) {
			if (cols[level] == cols[i] || Math.abs(cols[level] - cols[i]) == Math.abs(level - i)) {
				return false;
			}
		}
		return true;
	}

	public static void N_Queen(int level) {

		if (level == N) {
			ans++;
			return;
		} else {
			for (int i = 0; i < N; i++) {
				cols[level] = i;
				if (isPossible(level)) {
					N_Queen(level + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cols = new int[N];

		N_Queen(0);

		System.out.println(ans);
	}

}

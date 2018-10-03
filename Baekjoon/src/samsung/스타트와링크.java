package samsung;

import java.util.ArrayList;
import java.util.Scanner;

public class 스타트와링크 {
	static int N, sum = 0;
	static ArrayList<int[]> team = new ArrayList<int[]>();
	static ArrayList<int[]> start = new ArrayList<int[]>();
	static ArrayList<int[]> link = new ArrayList<int[]>();
	static int min = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		makeTeam(new int[N / 2], N, (N / 2), 0, 0);
		System.out.println(min());
	} // end main

	public static void makeTeam(int[] data, int n, int r, int idx, int num) {
		// nCr > data : 각각의 경우 담을 배열, idx : 각각의 배열의 인덱스값 , num : 번호

		if (r == 0) {
			team.add(data.clone());
			return;
		}
		if (n == num) {
			return;
		}
		data[idx] = num;

		makeTeam(data, n, r - 1, idx + 1, num + 1);
		makeTeam(data, n, r, idx, num + 1);

	} // end makeTeam

	public static void calculateSum(int[] data, int[] arr, int n, int r, int idx, int num) {
		if (r == 0) {
			sum += map[data[0]][data[1]] + map[data[1]][data[0]];
			return;
		}
		if (n == num) {
			return;
		}
		data[idx] = arr[num];

		calculateSum(data, arr, n, r - 1, idx + 1, num + 1);
		calculateSum(data, arr, n, r, idx, num + 1);

	} // end makeTeam

	public static int min() {
		int startP = 0, linkP = 0;
		for (int i = 0; i < team.size(); i++) {
			calculateSum(new int[2], team.get(i), N / 2, 2, 0, 0);
			startP = sum;
			sum = 0;
			calculateSum(new int[2], team.get(Math.abs(i - (team.size() - 1))), N / 2, 2, 0, 0);
			linkP = sum;
			sum = 0;
			if (min > Math.abs(startP - linkP)) {
				min = Math.abs(startP - linkP);
			}
		}
		return min;
	} // end min
}

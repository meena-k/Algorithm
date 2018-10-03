package samsung;

import java.util.ArrayList;
import java.util.Scanner;

/* 
 * 1. nCr : 치킨집 뽑기
 2. 각각의 집에서 거리 탐색
 3. 모든 집에서의 치킨거리의 합 저장
 4. 모든 조합에 대해 반복
 */

public class 치킨배달 {
	static ArrayList<Integer> house = new ArrayList<Integer>();
	static ArrayList<Integer> chicken = new ArrayList<Integer>();
	static ArrayList<int[]> dist = new ArrayList<>();
	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int temp = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp = sc.nextInt();
				if (temp == 1) {
					house.add((i * 5) + j);
				}
				if (temp == 2) {
					chicken.add((i * 5) + j);
				}
			}
		}

		nCr(chicken, chicken.size(), m, new int[m], 0, 0);

		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < dist.size(); i++) {
			int distance = getMinDist(i);
			if (minDistance > distance) {
				minDistance = distance;
			}
		}

		System.out.println(minDistance);
	}

	public static void nCr(ArrayList chicks, int n, int r, int data[], int index, int i) {
		if (r == 0) {
			dist.add(data.clone());
			return;
		}

		if (i >= n)
			return;

		data[index] = i;
		nCr(chicks, n, r - 1, data, index + 1, i + 1);
		nCr(chicks, n, r, data, index, i + 1);
	}

	public static int getMinDist(int idx) { // 각 조합의 거리값 구하기

		int totalDist = 0;
		for (int i = 0; i < house.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				int cx = chicken.get(dist.get(idx)[j]) / n;
				int cy = chicken.get(dist.get(idx)[j]) % n;

				int distant = Math.abs((house.get(i) / n) - cx) + Math.abs((house.get(i) % n) - cy);

				if (min > distant)
					min = distant;
			}
			totalDist += min;
		}
		return totalDist;
	}

}

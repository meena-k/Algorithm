package part3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 1525. 퍼즐 : BFS */
public class Main_1525 {

	// 상하, 좌우 개념이 있어야 하므로 이동할 수 있는 배열 만듦
	public static final int[] dx = { 1, -1, 0, 0 };
	public static final int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 3;
		int start = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				if (temp == 0)
					temp = 9;

				start = start * 10 + temp;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		// 배열크기 만큼 배열을 만들어야 하는것과는 달리 맵은 키값과 데이터만으로 만들수 있기때문에 메모리면에서 좋음
		HashMap<Integer, Integer> dist = new HashMap<Integer, Integer>();
		dist.put(start, 0);
		queue.add(start);
		while (!queue.isEmpty()) {
			int now_num = queue.poll();
			String now = Integer.toString(now_num);

			// 9의 위치 (0의 위치) 찾기
			int z = now.indexOf("9");
			int x = z / 3;
			int y = z % 3;

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				// 이동한 x,y에 대해 이동 전 x,y의 위치의 값과 변경 (swap)
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 현재 위치의 문자열 값을 StringBuilder를 통해 만듦
					StringBuilder next = new StringBuilder(now);

					// 이전의 값을 temp에 넣어둠
					char temp = next.charAt(x * 3 + y);

					// x*3+y의 자리에 nx*3+ny의 인덱스를 갖는 값을 넣어줌
					next.setCharAt(x * 3 + y, next.charAt(nx * 3 + ny));
					// nx*3+ny의 인덱스에 temp(x*3+y)의 인덱스 갖는 곳의 값을 넣어 넘겨줌
					next.setCharAt(nx * 3 + ny, temp);

					// next를 queue와 map에 넣어줌
					int num = Integer.parseInt(next.toString());
					if (!dist.containsKey(num)) {
						dist.put(num, dist.get(now_num) + 1);
						queue.add(num);
					} // end if
				} // end if
			} // end for
		} // end if(Empty)

		if (dist.containsKey(123456789)) {
			System.out.println(dist.get(123456789));
		} else {
			System.out.println("-1");
		}
	} // end main
} // end class

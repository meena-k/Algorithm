package part3;

import java.util.Scanner;

/* 1107. 리모컨 
 * 
 * 숫자버튼을 누르고 그 후에 + / - 버튼을 눌러야 한다.
 * +와 -를 번갈아 누르는것은 의미가 없다. 둘 중 하나만 눌러야 최소
 * 
 * 1. 숫자 버튼을 이용하여 채널 C로 이동
 * 2. 거기서 +나 -버튼을 몇번 눌러야 하는지 계산
 * 3. 가능한 M의 개수 : 500000개
 * 4. +나 0를 누르는 횟수 계산은 뺄셈으로 한번에 구할 수 있다.
 * 
 * 전략 
 * 1. 이동할 채널 C 구하기
 * 2. C에 포함되어있는 숫자 중 망가진 버튼이 있는지 확인
 * 3. 망가진 버튼이 없다면 |C-N|을 계산해 +나 -버튼을 총 몇 번 눌러야 하는지 계산
 * 
 * */
public class Main_1107 {
	static boolean[] broken = new boolean[10]; // 버튼이 망가져 있으면 true, 아니면 false

	public static int possible(int channel) {
		int len = 0;

		if (channel == 0) {
			return broken[0] ? 0 : 1;
		}

		while (channel > 0) {
			if (broken[channel % 10])
				return 0;
			channel /= 10;
			len++;
		}
		return len;
	}

	public static void main(String[] args) {
		int def = 100;
		Scanner sc = new Scanner(System.in);

		// 이동하려 하는 채널
		int n = sc.nextInt();

		// 고장난 버튼의 개수
		int m = sc.nextInt();

		// 고장난 버튼
		if (m != 0) {
			while (m-- > 0)
				broken[sc.nextInt()] = true;
		}

		// 100에서 n까지 숫자 버튼을 누르지 않고, +와 -만을 눌러서 이동하는 코드
		int answer = n - 100;
		if (answer < 0) {
			answer = -answer;
		}

		// 이동할 채널 c를 결정한 다음, 가능하면 버튼을 총 몇번 눌러야하는지
		for (int i = 0; i <= 1000000; i++) {
			int channel = i;
			int length = possible(channel); // 길이 잰다
			if (length > 0) {
				int press = channel - n; // +나 -를 몇번 눌러야 하는지
				if (press < 0) {
					press = -press;
				}
				if (answer > length + press) {
					answer = length + press;
				}
			}
		}
		System.out.println(answer);
	}

}

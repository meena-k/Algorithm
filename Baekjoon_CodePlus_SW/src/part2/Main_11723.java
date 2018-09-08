package part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 11723. С§Че */
public class Main_11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer str;
		String cmd;
		int m, S = 0;

		m = Integer.parseInt(br.readLine());
		while (m-- > 0) {
			str = new StringTokenizer(br.readLine());
			cmd = str.nextToken();
			int x = Integer.parseInt(str.nextToken());

			if (cmd.contains("add")) {
				S = S | (1 << x);
			} else if (cmd.contains("remove")) {
				S = S & ~(1 << x);
			} else if (cmd.contains("check")) {
				int res = S = S & (1 << x);
				if (res != 0) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
			} else if (cmd.contains("toggle")) {
				S = S ^ (1 << x);
			} else if (cmd.contains("all")) {
				S = (1 << 20) - -1;
			} else if (cmd.contains("empty")) {
				S = 0;
			}
		}
	}
}

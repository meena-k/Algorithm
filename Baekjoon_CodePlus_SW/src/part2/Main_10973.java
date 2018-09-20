package part2;

import java.util.Scanner;

/* 10972. 이전 순열 */
public class Main_10973 {

	public static boolean prev_permutation(int[] a) {
		int i = a.length - 1;
		while (i > 0 && a[i] >= a[i - 1])
			i -= 1;

		if (i <= 0)
			return false;

		int j = a.length - 1;
		while (a[j] >= a[i - 1])
			j -= 1;

		int temp = a[j];
		a[j] = a[i - 1];
		a[i - 1] = temp;

		j = a.length - 1;
		while (i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		if (prev_permutation(a)) {
			for (int i = 0; i < n; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		} else {
			System.out.println("-1");
		}
	} // end main
} // end class

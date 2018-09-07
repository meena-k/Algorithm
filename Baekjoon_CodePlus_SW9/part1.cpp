/* 11020.  A+B-7 */


/* 11021.  A+B-7 */
#if 0
#include <iostream>
using namespace std;

int main()
{
	int a, b;
	int i = 1;
	int t;

	cin >> t;

	while (t--) {
		cin >> a >> b;

		cout << "Case #" << i << ": " << a + b << endl;
		i++;
	}

	return 0;
}
#endif

/* 11022.  A+B-8 */
#if 0
#include <iostream>
using namespace std;

int main()
{
	int a, b;
	int i = 1;
	int t;

	cin >> t;

	while (t--) {
		cin >> a >> b;

		cout << "Case #" << i << ": " << a << " + " << b << " = " << a + b << endl;
		i++;
	}

	return 0;
}
#endif

/* 11718.  그대로 출력하기  */
#if 0
#include <cstdio>

using namespace std;

int main()
{
	char str[111];

	while (scanf("%[^\n]\n", str) == 1) {
		printf("%s\n", str);
	}

	return 0;
}
#endif

/* 11719.  그대로 출력하기2  */
#if 0
#include <cstdio>

using namespace std;

int main()
{
	char c;

	while ((c = getchar()) && c != EOF) {
		printf("%c", c);
	}
	return 0;
}
#endif

/* 11720.  숫자의 합 */
#if 0
#include <cstdio>

using namespace std;

int main()
{
	int num = 0;
	int len;
	int sum = 0;

	scanf("%d", &len);

	while (len--) {
		scanf("%1d", &num);
		sum += num;
	}

	printf("%d", sum);

	return 0;
}
#endif

/* 11721.  열 개씩 끊어 출력하기 */
#if 0
#include <cstdio>
#include <string>

using namespace std;

int main()
{
	char s[100];

	while (scanf("%10s", s) == 1) {
		printf("%s\n", s);
	}

	return 0;
}
#endif 

/* 
원격 리포지토리에 푸시하지 못했다는 에러 처리하기
https://blog.naver.com/venaticus629/221319594503 참조
*/  
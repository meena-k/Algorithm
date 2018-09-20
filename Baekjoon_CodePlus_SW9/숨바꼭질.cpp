#include <iostream>
#include <queue>

using namespace std;
bool check[200001];
int dist[200001];

int main() {
	int n, m;
	cin >> n >> m;

	check[n] = true;
	dist[n] = 0;

	queue<int> queue;
	queue.push(n);
	while (!queue.empty()) {
		int now = queue.front();
		queue.pop();

		if (now - 1 >= 0) {
			if (check[now - 1] == false) {
				queue.push(now - 1);
				check[now - 1] = true;
				dist[now - 1] = dist[now] + 1;
			}
		}
		if (now + 1 < 200000) {
			if (check[now + 1] == false) {
				queue.push(now + 1);
				check[now + 1] = true;
				dist[now + 1] = dist[now] + 1;
			}
		}
		if (now * 2 < 200000) {
			if (check[now * 2] == false) {
				queue.push(now * 2);
				check[now * 2] = true;
				dist[now * 2] = dist[now] + 1;
			}
		}
	}

	cout << dist[m] << '\n';
	return 0;
}
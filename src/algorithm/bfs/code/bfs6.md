# 16236번: 아기 상어

## 문제

- https://www.acmicpc.net/problem/16236
- not solved ❌
- 골드3

## 풀이 접근

- 다시 분석해서 풀어봐야겠음
- 구현이 복잡해서 이해가 잘 안됨

```java
import java.util.*;
import java.io.*;

/**
 * 2024-03-01
 * 16236번: 아기 상어 (골드3)
 * not solved ❌
 */
class Point6 {
    int x;
    int y;
    int dist;
    public Point6(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class Bfs_6 {
    private static int n;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] area, dis;
    private static int size = 2;
    private static int eat = 0;
    private static int time = 0;
    private static Queue<Point6> Q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 9) {
                    Q.offer(new Point6(i, j, 0));
                    area[i][j] = 0;
                }
            }
        }

        while (true) {
            List<Point6> eatenFish = new ArrayList<>();
            dis = new int[n][n];

            bfs(eatenFish);

            if (eatenFish.isEmpty()) {
                System.out.println(time);
                return;
            }

            Point6 curFish = eatenFish.get(0);
            for (int i = 1; i < eatenFish.size(); i++) {
                if (curFish.dist > eatenFish.get(i).dist) {
                    curFish.dist = eatenFish.get(i).dist;
                } else if (curFish.dist == eatenFish.get(i).dist) {
                    if (curFish.x > eatenFish.get(i).x) {
                        curFish = eatenFish.get(i);
                    } else if (curFish.x == eatenFish.get(i).x) {
                        if (curFish.y > eatenFish.get(i).y) {
                            curFish = eatenFish.get(i);
                        }
                    }
                }
            }

            time += curFish.dist;
            eat++;
            area[curFish.x][curFish.y] = 0;
            if (eat == size) {
                size++;
                eat = 0;
            }
            Q.offer(new Point6(curFish.x, curFish.y, 0));
        }
    }

    private static void bfs(List<Point6> eatenFish) {
        while (!Q.isEmpty()) {
            Point6 cur = Q.poll();
            int cv = cur.x;
            int cy = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = cv + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && area[nx][ny] <= size && dis[nx][ny] == 0) {
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                    Q.offer(new Point6(nx, ny, dis[nx][ny]));
                    if (area[nx][ny] >= 1 && area[nx][ny] <= 6 && area[nx][ny] < size) {
                        eatenFish.add(new Point6(nx, ny, dis[nx][ny]));
                    }
                }
            }
        }
    }
}
```
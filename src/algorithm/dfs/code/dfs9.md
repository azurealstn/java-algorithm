# 11725번: 트리의 부모 찾기

## 문제

- https://www.acmicpc.net/problem/11725
- solved ⭕
- 실버2

## 풀이 접근

- 양방향 그래프
- 그래프 인접리스트
- 방문했던 곳은 또 방문하지 않기 위해 ch배열로 체크
- 재귀를 호출하면서 전역 HashMap으로 key는 정점, value는 상위 부모 정점을 추가
- 정렬

```java
/**
 * 2024.02.28
 * 11725번: 트리의 부모 찾기  (실버2)
 * solved ⭕
 */
public class Dfs_9 {
    static int n;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        ch = new int[n + 1];
        ch[1] = 1;
        dfs(1);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (int key : list) {
            System.out.println(map.get(key));
        }
    }

    private static void dfs(int v) {
        for (int nv : graph.get(v)) {
            if (ch[nv] == 0) {
                ch[nv] = 1;
                map.put(nv, v);
                dfs(nv);
            }
        }
    }
}
```
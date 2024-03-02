package algorithm.bfs;

import java.util.*;
import java.io.*;

/**
 * 2024-03-02
 * 16953번: A → B (실버2)
 * not solved ❌
 */
public class Bfs_7 {
    private static long a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Long> Q = new LinkedList<>();
        Q.offer(a);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                long cn = Q.poll();
                if (cn == b) {
                    return L+1;
                }
                if (cn * 2 <= b) Q.offer(cn * 2);
                if (cn * 10 + 1 <= b) Q.offer(cn * 10 + 1);
            }
            L++;
        }
        return -1;
    }
}

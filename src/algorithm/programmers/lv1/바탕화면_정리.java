package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-24
 * 바탕화면 정리 (Lv1)
 * not solved ❌
 */
public class 바탕화면_정리 {
    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    private static int[] solution(String[] wallpaper) {
        int top = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    bottom = Math.max(bottom, i + 1);
                    right = Math.max(right, j + 1);
                }
            }
        }
        int[] result = {top, left, bottom, right};

        return result;
    }
}

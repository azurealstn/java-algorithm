package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-23
 * 데이터 분석 (Lv1)
 * solved ✅
 */
public class 데이터_분석 {
    public static void main(String[] args) {
        int[][] data = {
                {1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8}
        };
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        System.out.println(Arrays.toString(solution(data, ext, val_ext, sort_by)));
    }

    private static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int n = data.length;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        List<int[]> list = new ArrayList<>();
        int extIndex = map.get(ext);
        for (int i = 0; i < n; i++) {
            if (data[i][extIndex] <= val_ext) {
                list.add(data[i]);
            }
        }

        int[][] result = new int[list.size()][4];
        int sortByIndex = map.get(sort_by);
        Collections.sort(list, (v1, v2) -> v1[sortByIndex] - v2[sortByIndex]);
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

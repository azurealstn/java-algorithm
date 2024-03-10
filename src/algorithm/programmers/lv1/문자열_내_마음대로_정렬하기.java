package algorithm.programmers.lv1;

import java.util.*;
import java.io.*;

/**
 * 2024-03-10
 * 문자열 내 마음대로 정렬하기 (Lv1)
 * solved ✅
 */
class Word implements Comparable<Word> {
    String name;
    char ch;

    public Word(String name, char ch) {
        this.name = name;
        this.ch = ch;
    }

    @Override
    public int compareTo(Word o) {
        if (ch == o.ch) return name.compareTo(o.name);
        return ch - o.ch;
    }
}
public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String[] strings = new String[m];
        for (int i = 0; i < m; i++) {
            strings[i] = st.nextToken();
        }
        int n = Integer.parseInt(br.readLine());
        System.out.println(Arrays.toString(solution(strings, n)));
    }

    private static String[] solution(String[] strings, int n) {
        String[] result = new String[strings.length];
        List<Word> list = new ArrayList<>();
        for (String str : strings) {
            list.add(new Word(str, str.charAt(n)));
        }
        Collections.sort(list);
        for (int i = 0; i < strings.length; i++) {
            result[i] = list.get(i).name;
        }
        return result;
    }
}

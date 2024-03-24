package algorithm.programmers.lv1;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

/**
 * 2024-03-24
 * 개인정보 수집 유효기간 (Lv1)
 * solved ✅
 */
public class 개인정보_수집_유효기간 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        for (int x : solution(today, terms, privacies)) {
            System.out.print(x + " ");
        }
    }

    private static List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] arr = term.split(" ");
            termMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] arr = privacy.split(" ");
            LocalDate date = LocalDate.parse(arr[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            date = date.plusMonths(termMap.get(arr[1])).minusDays(1);
            LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            if (todayDate.isAfter(date)) {
                list.add(i+1);
            }
        }

        return list;
    }
}

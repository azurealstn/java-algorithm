package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-26
 * 붕대 감기 (Lv1)
 * not solved ❌
 */
public class 붕대_감기 {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {
                {2, 10},
                {9, 15},
                {10, 5},
                {11, 5},
        };
        System.out.println(solution(bandage, health, attacks));
    }

    private static int solution(int[] bandage, int health, int[][] attacks) {
        int result = 0;

        int continueSuccess = 0;
        int nAttack = attacks.length;
        int indexAttack = 0;
        int maxHealth = health;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        for (int time = 1; time <= attacks[nAttack - 1][0]; time++) {
            if (time == attacks[indexAttack][0]) { // 공격 O
                continueSuccess = 0;
                health -= attacks[indexAttack][1];
                indexAttack++;
                if (health <= 0) return -1;
            } else { // 공격 X
                continueSuccess++;
                health += x;
                if (continueSuccess == t) { // 연속성공시
                    health += y;
                    continueSuccess = 0;
                }
                if (health > maxHealth) health = maxHealth;
            }
        }

        result = health;
        return result;
    }
}

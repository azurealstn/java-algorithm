package algorithm.programmers.lv1;

import java.util.*;

/**
 * 2024-03-25
 * 공원 산책 (Lv1)
 * solved ✅
 */
public class 공원_산책 {
    public static void main(String[] args) {
        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};
        System.out.println(Arrays.toString(solution(park, routes)));
    }

    private static int[] solution(String[] park, String[] routes) {
        boolean flag = false;
        int x = 0;
        int y = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    flag = true;
                    x = i;
                    y = j;
                    int xTmp = x;
                    int yTmp = y;
                    for (String route : routes) {
                        String[] dis = route.split(" ");

                        if (dis[0].equals("E")) {
                            for (int k = 0; k < Integer.parseInt(dis[1]); k++) {
                                if (yTmp + 1 < park[i].length() && park[x].charAt(yTmp + 1) != 'X') {
                                    yTmp++;
                                } else {
                                    yTmp = y;
                                    break;
                                }
                            }
                        } else if (dis[0].equals("W")) {
                            for (int k = 0; k < Integer.parseInt(dis[1]); k++) {
                                if (yTmp - 1 >= 0 && park[x].charAt(yTmp - 1) != 'X') {
                                    yTmp--;
                                } else {
                                    yTmp = y;
                                    break;
                                }
                            }
                        } else if (dis[0].equals("S")) {
                            for (int k = 0; k < Integer.parseInt(dis[1]); k++) {
                                if (xTmp + 1 < park.length && park[xTmp + 1].charAt(y) != 'X') {
                                    xTmp++;
                                } else {
                                    xTmp = x;
                                    break;
                                }
                            }
                        } else if (dis[0].equals("N")) {
                            for (int k = 0; k < Integer.parseInt(dis[1]); k++) {
                                if (xTmp - 1 >= 0 && park[xTmp - 1].charAt(y) != 'X') {
                                    xTmp--;
                                } else {
                                    xTmp = x;
                                    break;
                                }
                            }
                        }
                        x = xTmp;
                        y = yTmp;
                    }
                }
                if (flag) break;
            }
            if (flag) break;
        }

        return new int[]{x, y};
    }
}

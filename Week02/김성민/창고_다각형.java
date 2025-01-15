package baekjoon_2304;

import java.util.*;

public class 창고_다각형 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int n = scanner.nextInt();
        int[][] pillars = new int[n][2];

        for (int i = 0; i < n; i++) {
            pillars[i][0] = scanner.nextInt(); // 왼쪽 면 위치 L
            pillars[i][1] = scanner.nextInt(); // 높이 H
        }

        // 기둥을 L 기준으로 정렬
        Arrays.sort(pillars, Comparator.comparingInt(o -> o[0]));

        // 제일 높은 기둥 찾기
        int highest = 0;
        int hIdx = 0;
        for (int i = 0; i < n; i++) {
            if (pillars[i][1] > highest) {
                highest = pillars[i][1];
                hIdx = i;
            }
        }

        // 면적 구하기
        int area = highest; // 제일 높은 기둥의 높이를 면적에 추가

        // 왼쪽에서 높은 기둥까지 계산
        int h = pillars[0][1];
        for (int i = 0; i < hIdx; i++) {
            if (pillars[i + 1][1] > h) {
                area += (pillars[i + 1][0] - pillars[i][0]) * h;
                h = pillars[i + 1][1];
            } else {
                area += (pillars[i + 1][0] - pillars[i][0]) * h;
            }
        }

        // 오른쪽에서 높은 기둥까지 계산
        h = pillars[n - 1][1];
        for (int i = n - 1; i > hIdx; i--) {
            if (pillars[i - 1][1] > h) {
                area += (pillars[i][0] - pillars[i - 1][0]) * h;
                h = pillars[i - 1][1];
            } else {
                area += (pillars[i][0] - pillars[i - 1][0]) * h;
            }
        }

        System.out.println(area);
    }
}

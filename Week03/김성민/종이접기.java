package baekjoon_1096;

import java.util.*;

public class 종이접기 {
    static int N, M;
    static int[][] paper;
    static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 처리
        N = scanner.nextInt(); // 세로 크기
        M = scanner.nextInt(); // 가로 크기
        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                paper[i][j] = scanner.nextInt();
            }
        }

        // BFS 초기화
        Queue<int[][]> queue = new LinkedList<>();
        queue.add(paper); // 초기 상태 삽입

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[][] currentPaper = queue.poll();

            // 최댓값 갱신
            maxSum = Math.max(maxSum, findMax(currentPaper));

            // 모든 가능한 접기 동작 수행
            for (int[][] nextPaper : fold(currentPaper)) {
                queue.add(nextPaper);
            }
        }

        // 결과 출력
        System.out.println(maxSum);
    }

    // 주어진 상태에서 나올 수 있는 모든 접기 동작 생성
    static List<int[][]> fold(int[][] currentPaper) {
        List<int[][]> nextStates = new ArrayList<>();

        int rows = currentPaper.length;
        int cols = currentPaper[0].length;

        // 행 접기
        for (int r = 1; r < rows; r++) {
            int[][] foldedPaper = new int[r][cols];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < cols; j++) {
                    foldedPaper[i][j] = currentPaper[i][j] + currentPaper[rows - 1 - i][j];
                }
            }
            nextStates.add(foldedPaper);
        }

        // 열 접기
        for (int c = 1; c < cols; c++) {
            int[][] foldedPaper = new int[rows][c];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < c; j++) {
                    foldedPaper[i][j] = currentPaper[i][j] + currentPaper[i][cols - 1 - j];
                }
            }
            nextStates.add(foldedPaper);
        }

        return nextStates;
    }

    // 주어진 상태에서 최댓값 계산
    static int findMax(int[][] paperState) {
        int max = Integer.MIN_VALUE;
        for (int[] row : paperState) {
            for (int val : row) {
                max = Math.max(max, val);
            }
        }
        return max;
    }
}

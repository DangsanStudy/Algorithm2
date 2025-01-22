package baekjoon_1034;

import java.util.*;

public class 거짓말 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫째 줄 입력
        int n = scanner.nextInt(); // 사람의 수 N
        int m = scanner.nextInt(); // 파티의 수 M

        // 진실을 아는 사람 정보
        int k = scanner.nextInt();
        boolean[] knowsTruth = new boolean[n + 1]; // 진실을 아는 사람을 표시 (1부터 N까지)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            int person = scanner.nextInt();
            knowsTruth[person] = true;
            queue.add(person);
        }

        // 각 파티의 참석자 정보를 저장
        List<List<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int h = scanner.nextInt(); //파티원 수 H
            List<Integer> partyMembers = new ArrayList<>();
            for (int j = 0; j < h; j++) {
                partyMembers.add(scanner.nextInt()); //몇 번 파티원인지
            }
            parties.add(partyMembers);
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (List<Integer> party : parties) {
                if (party.contains(current)) {
                    // 현재 사람이 포함된 파티에서 다른 참석자들에게 진실을 전파
                    for (int member : party) {
                        if (!knowsTruth[member]) {
                            knowsTruth[member] = true;
                            queue.add(member);
                        }
                    }
                }
            }
        }

        // 과장된 이야기를 할 수 있는 파티 개수 계산
        int maxLies = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int member : party) {
                if (knowsTruth[member]) { // 진실을 아는 사람이 있다면
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                maxLies++;
            }
        }

        System.out.println(maxLies);
    }
}

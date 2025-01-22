package 현정섭;
import java.io.*;
import java.util.*;

public class 거짓말 {
    public static int[] parent;

    public static void union(int root1, int root2) {
        root1 = find(root1);
        root2 = find(root2);

        if (root1 == root2) {
            return;
        }

        parent[root2] = root1;
    }

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        } 
        
        parent[a] = find(parent[a]);

        return parent[a];
        
    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int knowedCount = Integer.parseInt(st.nextToken());

        int[] knowedArray = new int[knowedCount];

        for (int i = 0; i < knowedCount; i++) {
            knowedArray[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N + 1];
        ArrayList<Integer>[] party = new ArrayList[M];

        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            int partyCount = Integer.parseInt(st.nextToken());

            for (int j = 0; j < partyCount; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            int root = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(root, party[i].get(j));
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            int r = party[i].get(0);

            boolean flag = true;

            for (int j = 0; j < knowedCount; j++) {
                if (find(r) == find(knowedArray[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    

}
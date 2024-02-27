import java.util.*;
public class boxinsertion {
    public static int maxBoxes(int[][] boxes) {
        int n = boxes.length;
        Arrays.sort(boxes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        int[] dp = new int[n];
        int len = 0;
        
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(dp, 0, len, boxes[i][1]);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            
            if (idx == len) {
                len++;
            }
            
            dp[idx] = boxes[i][1];
        }
        
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] boxes = new int[n][2];

        for (int i = 0; i < n; i++) {
            boxes[i][0] = scanner.nextInt();
            boxes[i][1] = scanner.nextInt();
        }

        int result = maxBoxes(boxes);
        System.out.println(result);
    }
}

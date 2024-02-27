import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class segregatenumbers {
    public static List<Integer> segregate(List<Integer> arr) {
        if (arr.size() <= 1) {
            return arr;
        }

        int mid = arr.size() / 2;
        List<Integer> left = segregate(arr.subList(0, mid));
        List<Integer> right = segregate(arr.subList(mid, arr.size()));

        int i = 0, j = 0;
        List<Integer> merged = new ArrayList<>();

        while (i < left.size() && left.get(i) < 0) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size() && right.get(j) < 0) {
            merged.add(right.get(j));
            j++;
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        List<Integer> result = segregate(arr);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

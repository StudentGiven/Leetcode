import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (arr == null || arr.length == 0 || k == 0) {
            return res;
        }

        int left = largestSmallerEqual(arr, x);
        int right = left + 1;

        while (right - left < k - 1) {
            if (right >= arr.length - 1 || left > 0 && (x - arr[left - 1]) <= (arr[right + 1] - x)) {
                left--;
            } else {
                right++;
            }
        }

        // Post-processing
        if (left > 0 && (x - arr[left - 1]) <= (arr[right] - x)) {
            left--;
        }

        for (int i = 0; i < k; i++) {
            res.add(arr[left + i]);
        }
        return res;
    }

    private int largestSmallerEqual(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

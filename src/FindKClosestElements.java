import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    // First Use binary search to locate left and right pointers
    // left: largest smaller or equal to x
    // right: left + 1
    // Expand left to right until there is k element between them(including left and right)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        // Corner cases
        if (arr == null || arr.length == 0 || k == 0) {
            return res;
        }

        int left = 0, right = 0;
        if (x <= arr[0]) {
            left = 0;
            for (int i = 0; i < k; i++) {
                res.add(arr[left + i]);
            }
            return res;
        }
        if (x >= arr[arr.length - 1]) {
            left = arr.length - k;
            for (int i = 0; i < k; i++) {
                res.add(arr[left + i]);
            }
            return res;
        }

        left = largestSmallerOrEqual(arr, x);
        right = left + 1;

        // We can advance the left pointer when:
        // 1: right pointer is out of bound
        // 2: both pointer are not out of bound and left - 1 is closer or equal to target
        while (right - left < k - 1) {
            if (right >= arr.length - 1 || left >= 1 && x - arr[left - 1] <= arr[right + 1] - x) {
                left--;
            } else {
                right++;
            }
        }
        // Post-processing
        if (left >= 1 && (x - arr[left - 1]) <= (arr[right] - x)) {
            left--;
        }

        for (int i = 0; i < k; i++) {
            res.add(arr[left + i]);
        }
        return res;
    }

    private int largestSmallerOrEqual(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left < right - 1) {  //when left = right - 1, we stop
            mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

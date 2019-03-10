public class MedianOfTwoSortedArrays {

    /**
     * Method 1: Two pointers i and j, 谁小移谁      O(m + n)
     * Method 2: Binary search                      O(log(m + n))
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Corner cases
        if (nums1 == null || nums1.length == 0) {
            return ((double)nums2[(nums2.length - 1) / 2] + (double)nums2[nums2.length / 2]) / 2;
        }
        if (nums2 == null || nums2.length == 0) {
            return ((double)nums1[(nums1.length - 1) / 2] + (double)nums1[nums1.length / 2]) / 2;
        }

        if ((nums1.length + nums2.length) % 2 == 1) { // Odd length
            return kth(nums1, 0, nums2, 0, (nums1.length + nums2.length + 1) / 2);
        } else { // Even length
            return (kth(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2) + kth(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2 + 1)) / 2;
        }
    }

    private double kth(int[] a, int aleft, int[] b, int bleft, int k) {
        // Base cases
        if (aleft >= a.length) {
            return b[bleft + k - 1];
        }
        if (bleft >= b.length) {
            return a[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }

        // Recursive rule
        int amid = aleft + k / 2 - 1; // Index of amid
        int bmid = bleft + k / 2 - 1;

        int aval = (amid >= a.length) ? Integer.MAX_VALUE : a[amid];
        int bval = (bmid >= b.length) ? Integer.MAX_VALUE : b[bmid];

        if (aval < bval) {
            return kth(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return kth(a, aleft, b, bmid + 1, k - k / 2);
        }
    }
}

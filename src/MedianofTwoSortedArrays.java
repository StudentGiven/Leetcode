public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a = nums1.length;
        int b = nums2.length;
        if (a == 0) {
            return ((double)nums2[b / 2] + (double)nums2[(b - 1) / 2]) / 2;
        }
        if (b == 0) {
            return ((double)nums1[a / 2] + (double)nums1[(a - 1) / 2]) / 2;
        }
        if ((a + b) / 2 * 2 != (a + b)) { // Total length is odd
            return kthSmallest(nums1, 0, nums2, 0, (a + b) / 2 + 1);
        }
        return (kthSmallest(nums1, 0, nums2, 0, (a + b) / 2 + 1) + kthSmallest(nums1, 0, nums2, 0, (a + b) / 2)) / 2;
    }

    private double kthSmallest(int[] nums1, int aleft, int[] nums2, int bleft, int k) {
        if (aleft >= nums1.length) {
            return nums2[bleft + k - 1];
        }
        if (bleft >= nums2.length) {
            return nums1[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[aleft], nums2[bleft]);
        }

        int amid = aleft + k / 2 - 1;
        int bmid = bleft + k / 2 - 1;

        int aval = (amid >= nums1.length) ? Integer.MAX_VALUE : nums1[amid];
        int bval = (bmid >= nums2.length) ? Integer.MAX_VALUE : nums2[bmid];

        if (aval <= bval) {
            return kthSmallest(nums1, amid + 1, nums2, bleft, k - k / 2);
        } else {
            return kthSmallest(nums1, aleft, nums2, bmid + 1, k - k / 2);
        }

    }
}


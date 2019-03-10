public class LongestPalindromicSubstring {
    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0, end = 0;
        int lenOdd = 0, lenEven = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            lenOdd = expand(s, i, i);
            lenEven = expand(s, i, i + 1);
            len = Math.max(lenOdd, lenEven);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R <= s.length() - 1 && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome2(String s) { // Manacher's algorithm
        if (s == null || s.length() < 2) {
            return s;
        }
        String res = "";
        s = preprocess(s);
        int[] P = new int[s.length()];
        int C = 0;  // the center of the main palindrome
        int R = 0;  // the right boundary of the main palindrome
        int mirror = 0; // the mirror location for i, center is C

        for (int i = 1; i < s.length() - 1; i++) {
            mirror = 2 * C - i;
            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }
            while (s.charAt(i + (1 + P[i])) == s.charAt(i - (1 + P[i]))) {
                P[i]++;
            }
            if (i + P[i] > R) {
                R = i + P[i];
                C = i;
            }
        }

        int maxLen = 0, mid = 0;
        for (int i = 0; i < s.length(); i++) {
            if (P[i] > maxLen) {
                mid = i;
                maxLen = P[i];
            }
        }

//        for (int i = 0; i < P.length; i++) {
//            System.out.println(P[i]);
//        }
//        System.out.println(s);
//        System.out.println(mid);
//        System.out.println(maxLen);
//        System.out.println(2 * mid - maxLen);
        res = s.substring(mid - maxLen, mid + maxLen);
        res = res.replaceAll("#", "").replace("$", "").replace("@", "");
        return res;
    }

    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i = 0; i < s.length(); i++) {
            sb.append('#');
            sb.append(s.charAt(i));
        }
        sb.append("#@");
        return sb.toString();
    }



}

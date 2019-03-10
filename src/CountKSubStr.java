import java.util.Arrays;

public class CountKSubStr {
    // Function to count number of substrings
    // with exactly k unique characters
    public int countkDist(String str, int k) {
        // Initialize result
        int res = 0;

        // To store count of characters from 'a' to 'z'
        int cnt[] = new int[26];

        // Consider all substrings beginning with str[i]
        for (int i = 0; i < str.length(); i++) {
            int dist_count = 0;

            // Initializing count array with 0
            Arrays.fill(cnt, 0);

            // Consider all substrings between str[i..j]
            for (int j = i; j < str.length(); j++) {
                // If this is a new character for this substring, increment dist_count
                if (cnt[str.charAt(j) - 'a'] == 0) {
                    dist_count++;
                }

                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;

                // If distinct character count becomes k, then increment result
                if (dist_count == k) {
                    res++;
                }
                if (dist_count > k) {
                    break;
                }
            }
        }

        return res;

    }
}

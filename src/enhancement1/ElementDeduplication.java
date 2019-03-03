package enhancement1;

public class ElementDeduplication {
    public int removeDeduplication(int[] input) {
        int slow = 1;
        for (int fast = 1; fast < input.length; fast++) {
            if (input[fast] == input[slow - 1]) {
                continue;
            }
            input[slow] = input[fast];
            slow++;
        }
        return slow;
    }
}

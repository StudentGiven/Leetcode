package enhancement1;


public class ElementDeduplication {


    /*
    sorted array, remove duplication, remain only one copy
    */
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

    /*
    sorted array, remove duplication, remain at most two copies
    */
    public int removeDeduplication2(int[] input) {
        if (input.length <= 2) {
            return input.length;
        }
        int slow = 2;
        for (int fast = 2; fast < input.length; fast++) {
            if (input[fast] == input[slow - 2]) {
                continue;
            }
            input[slow++] = input[fast];
        }
        return slow;
    }

    /*
    sorted array, remove all duplication
    */
//    public int removeDeduplication3(int[] input) {
//        int slow = 0;
//    }

}

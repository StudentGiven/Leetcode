public class WaterFlowers {
    /**
     *
     * A bottle with size water
     * Task is to water a row of flowers in order(cannot skip), if not enough water, go back and continue
     * water for each flower is stored in the flowers array
     * the min steps should take?

     * e.g
     * water = 10
     * flowers = [3, 4, 3, 2, 3, 5, 2, 4, 3, 3]
     * should return 1 + 1 + 4 + 4 + 7 + 7 + 10 = 34
     */

    public int minSteps(int water, int[] flowers) {
        // Corner case
        if (flowers == null || flowers.length == 0) {
            return 0;
        }
        if (water <= 0 || water <= flowers[0]) {
            return -1;
        }

        int size = water;
        int num = flowers.length;
        int res = 0;
        boolean[] isBack = new boolean[num]; // to track at which position we should go back

        // Update isBack
        for (int i = num - 1; i >= 0; i--) {
            if (size - flowers[i] >= 0) {
                size = size - flowers[i];
                continue;
            }
            isBack[i] = true;
            size = water - flowers[i];
        }

        //Calculate total steps
        for (int i = 0; i < num; i++) {
            if (isBack[i]) {
                res = res + (i + 1) * 2;
            }
        }
        res = res + num;
        return res;
    }

    /**
     * Regular water, calculate steps
     */

    public int steps(int size, int[] flowers) {
        // Corner case
        if (flowers == null || flowers.length == 0) {
            return 0;
        }
        if (size <= 0 || size <= flowers[0]) {
            return -1;
        }

        int water = size;  // remaining water
        int res = flowers.length;

        for (int i = 0; i < flowers.length - 1; i++) {
            if (water - flowers[i] < flowers[i + 1]) {
                res = res + (i + 1) * 2;
                water = size;
            } else {
                water = water - flowers[i];
            }
        }
        return res;
    }

}

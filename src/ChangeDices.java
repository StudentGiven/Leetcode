import java.util.ArrayList;
import java.util.List;

public class ChangeDices {
    public int minSteps(int[] dice1, int[] dice2) {
        if (dice1 == null || dice2 == null || dice1.length == 0 || dice2.length == 0) {
            return 0;
        }
        if (dice1.length != dice2.length) {
            return -1;
        }
        List<Integer> list = majority(dice1, dice2);
        int res = 0;
        if (list.size() == 0) {
            return -1;
        }
        else if (list.size() == 1) {
            int candidate = list.get(0);

            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < dice1.length; i++) {
                if (dice1[i] != candidate) {
                    if (dice2[i] != candidate) {
                        return -1;
                    } else {
                        count2++;
                    }
                } else {
                    count1++;
                }
            }
            return Math.min(dice1.length - count1, dice2.length - count2);
        }
        else {
            int candidate1 = list.get(0);
            int candidate2 = list.get(1);
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < dice1.length; i++) {
                if (dice1[i] != candidate1) {
                    count2++;
                    if (dice2[i] != candidate1) {
                        return -1;
                    }
                } else {
                    count1++;
                    if (dice2[i] == candidate1) {
                        return -1;
                    }
                }
            }
            return Math.min(count1, count2);
        }
    }


    /*
    dice1.length = dice2.length = l
    return the list of integer that appears >= l times
    maybe one maybe two (at most two)
     */
    private List<Integer> majority(int[] dice1, int[] dice2) {
        List<Integer> res = new ArrayList<>();
        int candidate1 = dice1[0];
        int candidate2 = dice1[0];
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < dice1.length; i++) {
            if (dice1[i] == candidate1) {
                count1++;
            } else if (dice1[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = dice1[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = dice1[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        for (int i = 0; i < dice2.length; i++) {
            if (dice2[i] == candidate1) {
                count1++;
            } else if (dice2[i] == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = dice2[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = dice2[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < dice1.length; i++) {
            if (dice1[i] == candidate1) {
                count1++;
            } else if (dice1[i] == candidate2) {
                count2++;
            }
        }
        for (int i = 0; i < dice2.length; i++) {
            if (dice2[i] == candidate1) {
                count1++;
            } else if (dice2[i] == candidate2) {
                count2++;
            }
        }

        if (count1 >= dice1.length) {
            res.add(candidate1);
        }
        if (count2 >= dice1.length) {
            res.add(candidate2);
        }
        return res;
    }
}

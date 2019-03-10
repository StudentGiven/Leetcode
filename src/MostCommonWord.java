import java.util.*;

public class MostCommonWord {

    //        4 steps:
    //
    //        1. remove all punctuations
    //        2. change to lowercase
    //        3. words count for each word not in banned set
    //        4. return the most frequent word

    public String mostCommonWord(String paragraph, String[] banned) {
        // 1 & 2
        String[] words = paragraph.toLowerCase().split("\\W+");

        // 3 add banned words to set
        Set<String> set = new HashSet<>();
        for (String word : banned){
            set.add(word);
        }

        // 3 add paragraph words to hash map
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            if(!set.contains(word)){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // 4 get the most frequent word
        int max = 0; // max frequency
        String res = "";
        for (String str : map.keySet()){
            if(map.get(str) > max){
                max = map.get(str);
            }
        }



        return res;
    }
}

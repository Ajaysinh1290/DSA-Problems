
// https://leetcode.com/problems/bulls-and-cows/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BullsAndCows {
   

    // public static String getHint(String secret, String guess) {

    //     HashMap<Character, ArrayList<Integer>> sMap = new HashMap();
    //     HashMap<Character, ArrayList<Integer>> gMap = new HashMap();

    //     for (int i = 0; i < secret.length(); i++) {
    //         {
    //             ArrayList<Integer> list = sMap.getOrDefault(secret.charAt(i), new ArrayList<>());
    //             list.add(i);
    //             sMap.put(secret.charAt(i), list);
    //         }
    //         {
    //             ArrayList<Integer> list = gMap.getOrDefault(guess.charAt(i),new ArrayList<>());
    //             list.add(i);
    //             gMap.put(guess.charAt(i), list);
    //         }

    //     }

    //     int cow = 0;
    //     int bull = 0;

    //     for (int i = 0; i < guess.length(); i++) {
    //         char ch = guess.charAt(i);
    //         if (sMap.containsKey(ch) && gMap.containsKey(ch)) {
    //             ArrayList<Integer> gList = gMap.get(ch);
    //             ArrayList<Integer> sList = sMap.get(ch);
    //             System.out.println("Char is " + ch+" Bull is "+bull+" Cow is "+cow);
    //             System.out.println("GList : " + Arrays.toString(gList.toArray()));
    //             System.out.println("SList : " + Arrays.toString(sList.toArray()));


    //             if (sList.contains(i) && gList.contains(i)) {
    //                 sList.remove((Object) i);
    //                 gList.remove((Object) i);
    //                 bull++;
    //             } else {
    //                 for (int k = 0; k < sList.size(); k++) {
    //                     if (!gList.contains(sList.get(k))) {
    //                         sList.remove(k);
    //                         cow++;
    //                         break;
    //                     }
    //                 }
    //             }
    //             if(gList.isEmpty()) {
    //                 gMap.remove(ch);
    //             }
    //             if(sList.isEmpty()) {
    //                 sMap.remove(ch);
    //             }
    //         }

    //     }

    //     return bull + "A" + cow + "B";

    // }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s] ++;
                numbers[g] --;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        String result = getHint("1807", "7810");
        System.out.println("Result " + result);
    }
}

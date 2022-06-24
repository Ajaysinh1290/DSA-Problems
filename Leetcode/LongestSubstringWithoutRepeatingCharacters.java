import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

     public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap =  new HashMap<Character,Integer>();
        int result = 0;

        int left = 0 ,right =0;

        while(right<s.length()) {
            if(hashMap.containsKey(s.charAt(right))) {
                // add logic
                System.out.println("Comparing "+(hashMap.get(s.charAt(right))+1)+" and "+left);
                left = Math.max(hashMap.get(s.charAt(right))+1, left);
            }

            result = Math.max(result,right-left+1 );
            hashMap.put(s.charAt(right), right);
            System.out.print("Hashmap is : ");
            System.out.println(Arrays.asList(hashMap));
            right++;
        }

        return result;
        
    }
    

    public static void main(String[] args) {

        String s = "abcaabcdba";
        int result = lengthOfLongestSubstring(s);
        System.out.println("result is "+result);
        
    }
    
}

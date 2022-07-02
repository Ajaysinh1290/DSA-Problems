
// https://leetcode.com/problems/generate-parentheses/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {

    // Solution 1
    // public static List<String> generateParenthesis(int n) {

    // List<String> list = new ArrayList<>();
    // String str = "()".repeat(n);
    // list.add(str);
    // for (int index = 0; index < list.size(); index++) {
    // str = list.get(index);

    // char[] charArray = str.toCharArray();

    // for (int i = 0; i < charArray.length - 1; i++) {
    // if (charArray[i] == ')' && charArray[i + 1] == '(') {
    // charArray[i] = '(';
    // charArray[i + 1] = ')';
    // String newString = new String(charArray);
    // if (!list.contains(newString)) {
    // list.add(newString);
    // }
    // charArray[i] = ')';
    // charArray[i + 1] = '(';
    // }
    // }

    // }
    // return list;
    // }

    // Solution 2 : Backtracking (Optimized Solution)
    // public static List<String> generateParenthesis(int n) {
    // List<String> list = new ArrayList<String>();
    // backtrack(list, "", 0, 0, n);
    // return list;
    // }

    // public static void backtrack(List<String> list, String str, int open, int
    // close, int max){

    // if(str.length() == max*2){
    // list.add(str);
    // return;
    // }

    // if(open < max)
    // backtrack(list, str+"(", open+1, close, max);
    // if(close < open)
    // backtrack(list, str+")", open, close+1, max);
    // }

    // Solution 3 DP
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(Arrays.toString(result.toArray()));

    }
}

import java.util.Stack;

// https://leetcode.com/problems/backspace-string-compare/

public class BackspaceStringCompare {
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for(int i =0; i<s.length()||i<t.length(); i++) {
            if(i<s.length()) {
                char ch = s.charAt(i);
                if (ch == '#') {
                    if (!sStack.isEmpty()) {
                        sStack.pop();
                    }
                } else {
                    sStack.push(ch);
                }
            }
            if(i<t.length()) {
                char ch = t.charAt(i);
                if (ch == '#') {
                    if (!tStack.isEmpty()) {
                        tStack.pop();
                    }
                } else {
                    tStack.push(ch);
                }
            }
        }

        return sStack.equals(tStack);
    }

    public static void main(String[] args) {
        boolean result = backspaceCompare("a##c", "#a#c");
        System.out.println("Result is " + result);
    }
}

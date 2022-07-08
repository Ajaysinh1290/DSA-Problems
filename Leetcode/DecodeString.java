import java.util.Stack;

// https://leetcode.com/problems/decode-string/

public class DecodeString {

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        String output = "";
        for(char ch : s.toCharArray()) {
            if(ch==']') {
                String str = "";
                while(stack.peek()!='[') {
                    str = stack.pop() + str;
                }
                stack.pop();
                String num = stack.pop()+"";
                while(!stack.isEmpty()&&Character.isDigit(stack.peek())) {
                    num = stack.pop()+num;
                }
                System.out.println("Num is "+num);
                int k = Integer.parseInt(num);
                System.out.println("K is "+k);
                String toAdd = "";
                while(k>0) {
                    toAdd+=str;
                    k--;
                }
                System.out.println("String is "+str);
                for(char newCh : toAdd.toCharArray()) {
                    stack.push(newCh);
                }
            }else {
                stack.push(ch);
            }
        }
        String str ="";
        while(!stack.isEmpty()) {
            str = stack.pop()+str;
        }
        
        return output+str;
    }
    public static void main(String[] args) {
        String result =  decodeString("100[leetcode]");
        System.out.println("Result is "+result);
    }    
}

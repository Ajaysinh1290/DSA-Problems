// https://leetcode.com/problems/multiply-strings/


public class MultiplyStrings {

    // public static String multiply(String num1, String num2) {

    //     String result = "";
    //     HashMap<Integer, String> dp = new HashMap();
    //     int n1 = num1.length();
    //     int n2 = num2.length();
    //     for (int i = 0; i < n1; i++) {
    //         int num = toDigit(num1.charAt(i));
    //         String tempResult = "";
    //         if (!dp.containsKey(num)) {
    //             int carry = 0;
    //             for (int j = n2 - 1; j >= 0; j--) {
    //                 int sum = num * toDigit(num2.charAt(j)) + carry;
    //                 carry = 0;
    //                 carry = sum / 10;
    //                 sum %= 10;
    //                 tempResult = sum + tempResult;
    //             }
    //             tempResult = (carry == 0 ? "" : carry) + tempResult;
    //             dp.put(num, tempResult);
    //         }else {
    //             tempResult = dp.get(num);
    //         }

    //         for (int k = n1 - 1; k > i; k--) {
    //             tempResult += "0";
    //         }
    //         result = sum(tempResult, result);
    //     }

    //     return removeZeros(result);
    // }

    // public static int toDigit(char ch) {
    //     return ch - '0';
    // }

    // public static String sum(String num1, String num2) {
    //     int n1 = num1.length();
    //     int n2 = num2.length();
    //     int max = Math.max(n1, n2);
    //     int carry = 0;
    //     String output = "";

    //     for (int i = 1; i <= max; i++) {
    //         int digit1 = n1 - i < 0 ? 0 : toDigit(num1.charAt(n1 - i));
    //         int digit2 = n2 - i < 0 ? 0 : toDigit(num2.charAt(n2 - i));
    //         int sum = digit1 + digit2 + carry;
    //         carry = 0;
    //         if (sum > 9) {
    //             carry = sum / 10;
    //             sum %= 10;
    //         }
    //         output = sum + output;
    //     }
    //     if (carry != 0) {
    //         output = carry + output;
    //     }
    //     return output;
    // }

    // public static String removeZeros(String s) {
    //     int index = 0;
    //     while (index < s.length() && s.charAt(index) == '0') {
    //         index++;
    //     }
    //     if (s.length() == index) {
    //         return "0";
    //     }
    //     return s.substring(index);
    // }
    

    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
       
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    public static void main(String[] args) {
        String result = multiply("103", "98");
        System.out.println("Multiplication is is " + result);
    }
}

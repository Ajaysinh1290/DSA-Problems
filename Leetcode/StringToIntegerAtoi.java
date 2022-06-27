
//  https://leetcode.com/problems/string-to-integer-atoi/

public class StringToIntegerAtoi {

    public static int myAtoi(String s) {
        int number = 0;
        boolean isNegative = false;
        int index = 0;
        for (char ch : s.toCharArray()) {
            if ((ch == '-' || ch == '+' || ch == ' ') && index == 0) {
                if (ch == ' ') {
                    continue;
                }
                else if (ch == '-') {
                    isNegative = true;
                }
                index++;

            } else if (ch >= '0' && ch <= '9') {
                int prevNumber = number;
                number = number * 10 + (ch - '0');
                index++;
                if ((number / 10) != prevNumber) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        if (isNegative) {
            number *= (-1);
        }
        return number;
    }

    public static void main(String[] args) {

        int number = myAtoi("      -9339");
        System.out.println("Number is " + number);

    }
}

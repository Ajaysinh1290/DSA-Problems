
// https://leetcode.com/problems/happy-number/

public class HappyNumber {

    // public static boolean isHappy(int n) {
    // HashSet<Integer> set = new HashSet<>();
    // while (true) {
    // n = getNext(n);
    // if (n == 1 || set.contains(n)) {
    // break;
    // } else {
    // set.add(n);
    // }
    // }
    // return n == 1;
    // }
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
            if (fast == 1) {
                break;
            }
        } while (slow != fast);
        return slow == 1 || fast == 1;
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + (int) Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        boolean result = isHappy(2);
        System.out.println("Result is " + result);
    }
}

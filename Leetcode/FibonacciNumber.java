public class FibonacciNumber {

    public static int fib(int n) {
        if(n<=1) return n;
        int first = 0;
        int second = 1;
        for(int i = 2; i<n; i++) {
            int temp = second;
            second = first + second;
            first  = temp;
        }
        return  first+second;
    }
    public static void main(String[] args) {
        int result = fib(1);
        System.out.println("Result is "+result);
    }
}

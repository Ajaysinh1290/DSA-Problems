public class ReverseInteger {

    public static int reverse(int x) {
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
    }
    public static void main(String[] args) {
        System.out.println("Reverse number is "+reverse(1232249993));
    }   
}


public class MovePiecesToObtainAString {
    public static boolean canChange(String st, String tar) {
        int n = tar.length();
        int i = 0, j = 0;
        while (i < n || j < n) {

            while (i < n && tar.charAt(i) == '_')
                i++;
            while (j < n && st.charAt(j) == '_')
                j++;

            if (i == n || j == n) {
                return i == n && j == n;
            }

            if (tar.charAt(i) != st.charAt(j))
                return false;

            if (tar.charAt(i) == 'L') {
                if (j < i)
                    return false;
            } else {
                if (i < j)
                    return false;
            }

            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String start = "_R";
        String target = "R_";
        boolean result = canChange(start, target);
        System.out.println("Result is result " + result);
    }
}

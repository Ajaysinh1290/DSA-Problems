public class FirstBadVersion {

    // Solution 1
    // public static int firstBadVersion(int n) {
    //     int low = 0;
    //     int high = n;

    //     while (high >= low) {
    //         int mid = low + (high - low) / 2;

    //         if (isBadVersion(mid)) {
    //             if (isBadVersion(low)) {
    //                 return low;
    //             }
    //             high = mid;
    //         } else {
    //             low = mid + 1;
    //         }
    //     }
    //     return -1;
    // }

    // Second solution with less api calls 
    public static int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (!isBadVersion(mid))
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    public static boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static void main(String[] args) {

        int result = firstBadVersion(5);
        System.out.println("Result is " + result);

    }
}

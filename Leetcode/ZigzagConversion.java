// https://leetcode.com/problems/zigzag-conversion/

public class ZigzagConversion {

    // Solution 1
    // public static String convert(String s, int numRows) {

    //     String result = "";
    //     ArrayList<Character>[] chars = new ArrayList[numRows];
    //     int index = 0;

    //     int addOn = 0;

    //     while (index < s.length()) {
    //         for (int i = 0; i < numRows; i++) {

    //             int cIndex = index % numRows;
    //             if (index >= s.length()) {
    //                 break;
    //             }
    //             System.out.println("Index is " + cIndex + " i is " + i + " Add on is" + addOn);
    //             if (chars[cIndex] == null) {
    //                 chars[cIndex] = new ArrayList<>();
    //             }
              
    //             if (addOn < 1) {
    //                 chars[i].add(s.charAt(index));
    //                 index++;
    //             }
    //             else if (addOn == i) {
    //                 chars[i].add(s.charAt(index));
    //                 index++;
    //             } 

    //             if ((i % (numRows - 1)) == 0&& i > 0) {
    //                 if (addOn == 0) {
    //                     addOn = numRows - 2;
    //                 } else {
    //                     addOn--;
    //                 }
    //             }

    //         }
    //     }
    //     result = "";
    //     for (int j = 0; j < numRows; j++) {
    //         for (char ch : chars[j]) {
    //             System.out.print(ch + " ");
    //             result += ch+"";
    //         }
    //         System.out.println();
    //     }
       
    //     return result;
    // }

    //Solution 2 

    public static String convert(String s, int numRows) {

        int index = 0;
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i<numRows; i++) {
            sb[i] = new StringBuffer();
        }
        while(index<s.length()) {
            for(int i = 0; i<numRows&&index<s.length(); i++) {
                sb[i].append(s.charAt(index));
                index++;
            }
            for(int i=numRows-2; i>0&&index<s.length(); i--) {
                sb[i].append(s.charAt(index));
                index++;
            }
        }

        for(int i = 1; i<numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }


    public static void main(String[] args) {
        String result = convert("PAYPALISHIRING",  4);
        System.out.println("Result is " + result);
    }
}

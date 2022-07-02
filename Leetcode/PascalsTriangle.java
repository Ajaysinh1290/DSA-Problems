// https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

    // Solution 1 using recursion
    public static List<List<Integer>> generate(int numRows) {

        if (numRows == 1) {
            List<List<Integer>> list = new ArrayList<>();
            ArrayList<Integer> fList = new ArrayList<>();
            fList.add(1);
            list.add(fList);
            return list;
        }
        
        List<List<Integer>> list = generate(numRows-1);
        ArrayList<Integer> sublist = new ArrayList<>();
        sublist.add(1);
        List<Integer> lastList = list.get(list.size()-1);
        for(int i = 1; i<lastList.size(); i++) {
            sublist.add(lastList.get(i)+lastList.get(i-1));
        }
        sublist.add(1);
        list.add(sublist);
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for(List<Integer> list : result) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}

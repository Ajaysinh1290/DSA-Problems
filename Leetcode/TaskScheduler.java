import java.util.HashMap;

public class TaskScheduler {

    
    public static int leastInterval(char[] tasks, int n) {
        int nTasks = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int idleCountIs = 0;

        while (!map.isEmpty()) {

            int count = 0;
            for (char k : map.keySet()) {
                int freq = map.get(k);
                if (freq > 0) {
                    idleCountIs = 0;
                    map.put(k, map.get(k) - 1);
                    count++;
                    if(count>n) {
                        break;
                    }
                }
            }

            System.out.println("Count value is " + count);
            if (count == 0) {
                break;
            }
            nTasks += count;
            if (count <= n) {
                idleCountIs = n - count + 1;
                System.out.println("Invalid");
                nTasks += idleCountIs;
            }
            System.out.println("N value is " + nTasks);
        }

        return nTasks - idleCountIs;
    }

    public static void main(String[] args) {

        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int result = leastInterval(tasks, 2);
        System.out.println("Result is " + result);

    }
}

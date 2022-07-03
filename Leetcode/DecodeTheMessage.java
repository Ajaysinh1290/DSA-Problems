import java.util.HashMap;

public class DecodeTheMessage {

    public static String decodeMessage(String key, String message) {

        HashMap<Character,Character> table = new HashMap();
        char rchar = 'a';
        for(char ch : key.toCharArray()) {
        
            if(ch!=' '&&!table.containsKey(ch)) {
                table.put(ch, rchar);
                rchar++;
            }
        }
        String s = "";
        for(char ch : message.toCharArray()) {
            if(ch == ' '){
                s+=' ';
            } else {
                s+=table.get(ch);
            }
        }
        return s;
    }
    public static void main(String[] args) {
        String result = decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv");
        System.out.println(result);
    }
}

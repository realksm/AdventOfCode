import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1Part1 {
    public static ArrayList<String> input = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        File file = new File("2023/day1/day1input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            input.add(st);
        }
        Trebuchet();
    }
    private static void Trebuchet() {
        long sum = 0;
        for(String st : input) {
            sum += getNum(st);
        }
        
        System.out.println(sum);
    }
    private static int getNum(String st) {
        char[] ch = st.toCharArray();
        int num = 0;
        for (int i = 0; i < ch.length; i++) {
            if(Character.isDigit(ch[i])) {
                num = ch[i] - '0';
                break;
            }
        }
        for (int i = ch.length - 1; i >= 0; i--) {
            if(Character.isDigit(ch[i])) {
                num = num * 10 + (ch[i] - '0');
                break;
            }
        }
        return num;
    }
}

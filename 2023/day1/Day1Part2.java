import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day1Part2 {
    public static ArrayList<String> input = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        File file = new File("2023/day1/day1input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null) {
            input.add(st);
        }
        Trebuchet2();
    }
    private static void Trebuchet2() {
        long sum = 0;
        for(String st : input) {
            sum += getNum(st, true) * 10 + getNum(st, false);
        }
        
        System.out.println(sum);
    }
    private static int getNum(String st, boolean isFirst) {
        int num = 0;
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if(Character.isDigit(ch)) {
                int digit = Character.getNumericValue(ch);
                if(isFirst) {
                    return digit;
                } else {
                    num = digit;
                }
            } else {
                int value = getWordValue(st, i);
                if(value != -1) {
                    if(isFirst) {
                        return value;
                    } else {
                        num = value;
                    }
                }
            }
        }
        return num;
    }
    private static int getWordValue(String st, int i) {
        StringBuilder sb = new StringBuilder();
        int index = i;
        while (index < st.length() && Character.isLetter(st.charAt(index))) {
            sb.append(st.charAt(index));
            if(getValue(sb.toString()) != -1) {
                return getValue(sb.toString());
            }
            index++;
        }
        return -1;
    }
    private static int getValue(String word) {
        switch (word) {
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return -1;
        }
    }    
}
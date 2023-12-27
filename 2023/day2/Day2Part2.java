import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Game {
    int id;
    ArrayList<GameSet> gameSets;

    public Game(int id) {
        this.id = id;
        this.gameSets = new ArrayList<GameSet>();
    }

    public void addGameSet(int r, int g, int b) {
        gameSets.add(new GameSet(r, g, b));
    }
}

class GameSet {
    int red;
    int green;
    int blue;

    public GameSet(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
}
public class Day2Part2 {
    final static int RED = 12, GREEN = 13, BLUE = 14;
    static ArrayList<Game> input = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File file = new File("2023/day2/day2input.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String st;

            while ((st = br.readLine()) != null) {
                processInput(st);
            }
        }
        int power = CubeConundrum2();
        System.out.println(power);
    }

    private static int CubeConundrum2() {
        int power = 0;
        for (Game game : input) {
            int blueMax = 0, redMax = 0, greenMax = 0;
            for (GameSet set : game.gameSets) {
                redMax = Math.max(redMax, set.red);
                blueMax = Math.max(blueMax, set.blue);
                greenMax = Math.max(greenMax, set.green);
            }
            power += redMax * blueMax * greenMax;
        }
        return power;
    }

    private static void processInput(String st) {
        String[] game = st.split(": ");
        String[] nameid = game[0].split(" ");

        input.add(new Game(Integer.parseInt(nameid[1])));
        
        String[] sets = game[1].split("; ");
        for (String string : sets) {
            int r = 0, g = 0, b = 0;
            String[] colors = string.split(", ");
            for (String pair : colors) {
                String[] parts = pair.split(" ");
                int count = Integer.parseInt(parts[0]);
                String color = parts[1];
                switch (color) {
                    case "red" -> r = count;
                    case "green" -> g = count;
                    case "blue" -> b = count;
                }
            }
            input.get(input.size() - 1).addGameSet(r, g, b);
        }
    }
}

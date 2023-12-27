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

public class Day2Part1 {
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
        int possibleGameSets = CubeConundrum();
        System.out.println(possibleGameSets);
    }

    private static int CubeConundrum() {
        int possibleGame = 0;
        for (Game Game : input) {
            boolean possible = true;
            for (GameSet set : Game.gameSets) {
                if (set.red > RED) {
                    possible = false;
                }
                if (set.blue > BLUE) {
                    possible = false;
                }
                if (set.green > GREEN) {
                    possible = false;
                }
            }
            if(possible) possibleGame += Game.id;
        }
        return possibleGame;
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
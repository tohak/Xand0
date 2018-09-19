import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryService {
    private static final String FILENAME = "file.txt";
    private static final Gson GSON = new Gson();

    public static void histToGson(History history) {

        String s = GSON.toJson(history);

        try {
            FileWriter writer = new FileWriter(FILENAME, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(s);
            bufferWriter.newLine();
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println("Не удалось записать в файл");
        }

    }

    public static List<History> histFromGson() {
        List<History> historyList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String str;
            for (; (str = reader.readLine()) != null; ) {
                historyList.add(GSON.fromJson(str, History.class));
            }
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл");
        }
        return historyList;
    }

    public static void printConsol(History history) {
        String[][] pole = history.getPole();
        String userOne = history.getUserName()[0];
        String userTho = history.getUserName()[1];
        String victoryName = history.getVictoryName();
        System.out.println("Игравое поле:");
        Game.getPole(pole);
        System.out.println("Играли: " + userOne + " и " + userTho);
        System.out.println("Победил " + victoryName);
        System.out.println("________");
        System.out.println();


    }
}

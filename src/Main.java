import java.util.List;

public class Main {

/*
* Консольная игра Крестики-Нолики
*/
    public static void main(String[] args) {
        List<History> historyList = HistoryService.histFromGson();
        Menu.menuGames(historyList);
    }

}

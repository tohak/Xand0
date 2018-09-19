import java.util.List;

public class Menu {
    private static List<History> histories;
    public static void menuGames(List<History> historyLis) {
        histories=historyLis;
        String[] menuArray = new String[]{"1) Играть", "2) История", "3) Выход"};
        String errorInput = "Не правильно ввели цифру, попробуйте еще раз..";
        for (String menu : menuArray) {
            System.out.println(menu);
        }
        boolean checkInput = false;
        do {
            System.out.println();
            System.out.println("Введите цифру меню (1-3), для выбраного действия");
            int numberMenu = Util.getInputNumber();

            if (numberMenu > 0 && numberMenu <= 3) {
                switch (numberMenu) {
                    case 1:
                        Game.playGames();
                        History one = Game.getHistory();
                        HistoryService.histToGson(one);

                        break;
                    case 2:
                        System.out.println("История игр");
                        for (History h : histories) {
                            System.out.println("ИГРА:");
                            HistoryService.printConsol(h);
                        }
                        break;
                    case 3:
                        System.out.println("Выход. Приходите еще:)");
                        break;
                }
                checkInput = true;
            } else {
                System.out.println(errorInput);
            }
        } while (!checkInput);

    }

    public static void victorymenu() {
        System.out.println("Хотите сыграть? нажмите '1', главное меню '2', выход нажмите любое целое число(кроме 1,2)");
        int numberMenu = Util.getInputNumber();
        History one = Game.getHistory();
        histories.add(one);
        if (numberMenu == 1) {
            Game.playGames();
        } else if (numberMenu == 2) {
            menuGames(histories);
        } else {
            System.out.println("Пока, приходите еще!");
        }

    }
}

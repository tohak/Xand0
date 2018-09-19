public class Game {
    private static final String PUSTO = "   ", KRESTIK = " X ", NOLIK = " 0 ";
    private static final int STROKA = 3, STOLBIK = 3;
    private static final int STATUS_GAMES_PLAY = 0, STATUS_NICHYYA = 1, STATUS_POBEDA_X = 2, STATUS_POBEDA_O = 3;

    private static String[][] pole = new String[STROKA][STOLBIK];
    private static int statusGame;
    private static String activeUser, activeUserName;
    private static String[] nameUser;

    public static void playGames() {
        nameUser = Util.nameUser();
        startGames(nameUser[0]);
        do {
            drowGames();
            getStatus();
            getPole(pole);
            if (statusGame == STATUS_POBEDA_X) {
                getPole(pole);
                System.out.println("Игрок игравший крестиком: " + nameUser[0] +
                        ", игрок игравший ноликом: " + nameUser[1]);
                System.out.println("Победил " + nameUser[0] + ", УРЯ!!!");
                Menu.victorymenu();
            } else if (statusGame == STATUS_POBEDA_O) {
                getPole(pole);
                System.out.println("Игрок игравший крестиком: " + nameUser[0] +
                        ", игрок игравший ноликом: " + nameUser[1]);
                System.out.println("Победил " + nameUser[1] + ", УРЯ!!!");
                Menu.victorymenu();
            } else if (statusGame == STATUS_NICHYYA) {
                getPole(pole);
                System.out.println("Игрок игравший крестиком: " + nameUser[0] +
                        ", игрок игравший ноликом: " + nameUser[1]);
                System.out.println("Победила ДРУЖБА!!!:)");
                Menu.victorymenu();
            }
            activeUser = (activeUser.equals(KRESTIK) ? NOLIK : KRESTIK);
            activeUserName = (activeUserName.equals(nameUser[0]) ? nameUser[1] : nameUser[0]);

        } while (statusGame == STATUS_GAMES_PLAY);
    }

    private static void startGames(String userOne) {
        for (int i = 0; i < STROKA; i++) {
            for (int j = 0; j < STOLBIK; j++) {
                pole[i][j] = PUSTO;
            }
        }
        activeUser = KRESTIK;
        activeUserName = userOne;
        getPole(pole);
    }

    public static void getPole(String[][] pole) {
        for (int i = 0; i < STROKA; i++) {
            for (int j = 0; j < STOLBIK; j++) {
                System.out.print(pole[i][j]);
                if (j != STOLBIK - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i != STROKA - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    private static void drowGames() {
        boolean checkInput = false;
        do {
            System.out.println("Игрок " + activeUserName + ", введите значение строки(1-3)");
            int numberStroka = Util.getInputNumber() - 1;
            System.out.println("Игрок " + activeUserName + ", введите значение столбца(1-3)");
            int numberStolbec = Util.getInputNumber() - 1;
            if (numberStroka >= 0 && numberStroka < STROKA && numberStolbec >= 0 && numberStolbec < STOLBIK && pole[numberStroka][numberStolbec].equals(PUSTO)) {
                pole[numberStroka][numberStolbec] = activeUser;
                checkInput = true;
            } else {
                System.out.println("Выбраное поле(" + (numberStroka + 1) + ";" + (numberStolbec + 1) + "), не может быть использовано. Введите заного...");
            }
        } while (!checkInput);
    }

    private static String userVictory() {
        int countSymbol;
        for (int i = 0; i < STROKA; i++) {
            countSymbol = 0;
            for (int j = 0; j < STOLBIK; j++) {
                if (!pole[i][0].equals(PUSTO) && pole[i][0].equals(pole[i][j])) {
                    countSymbol += 1;
                }
            }
            if (countSymbol == 3) {
                return pole[i][0];
            }
        }
        for (int i = 0; i < STOLBIK; i++) {
            countSymbol = 0;
            for (int j = 0; j < STROKA; j++) {
                if (!pole[0][i].equals(PUSTO) && pole[0][i].equals(pole[j][i])) {
                    countSymbol += 1;
                }
            }
            if (countSymbol == 3) {
                return pole[0][i];
            }
        }
        if (!pole[0][0].equals(PUSTO) && pole[0][0].equals(pole[1][1]) && pole[0][0].equals(pole[2][2])) {
            return pole[0][0];
        }
        if (!pole[0][2].equals(PUSTO) && pole[1][1].equals(pole[0][2]) && pole[2][0].equals(pole[0][2])) {
            return pole[0][2];
        }
        return PUSTO;
    }

    private static boolean checkEndPole() {
        for (int i = 0; i < STROKA; i++) {
            for (int j = 0; j < STOLBIK; j++) {
                if (pole[i][j].equals(PUSTO)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void getStatus() {
        String victory = userVictory();
        if (victory.equals(KRESTIK)) {
            statusGame = STATUS_POBEDA_X;
        } else if (victory.equals(NOLIK)) {
            statusGame = STATUS_POBEDA_O;
        } else if (checkEndPole()) {
            statusGame = STATUS_NICHYYA;
        } else {
            statusGame = STATUS_GAMES_PLAY;
        }
    }

    public static History getHistory() {
        return new History(pole, nameUser, activeUserName);

    }

}

public class History {

    private String[][] pole;
    private String[] userName;
    private String victoryName;

    public History() {
    }

    public History(String[][] pole, String[] userName, String victoryName) {
        this.pole = pole;
        this.userName = userName;
        this.victoryName = victoryName;
    }

    public String[][] getPole() {
        return pole;
    }

    public String[] getUserName() {
        return userName;
    }

    public String getVictoryName() {
        return victoryName;
    }

}

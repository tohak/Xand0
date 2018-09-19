import java.util.NoSuchElementException;
import java.util.Scanner;

public class Util {

    private static Scanner sc = new Scanner(System.in);

    public static String[] nameUser() {
        String[] users = new String[2];
        System.out.println("Введите Имя первого игрока:");
        users[0] = sc.nextLine();
        System.out.println("Введите Имя второго игрока:");
        users[1] = sc.nextLine();
        return users;
    }

    public static int getInputNumber() {

        int number = -1;
        try {
            String input = sc.nextLine();
            number = Integer.parseInt(input);
        } catch (NoSuchElementException | NumberFormatException e) {
            System.out.println("вводите только целые числа от 1 до 3.");
        }
        return number;
    }
}

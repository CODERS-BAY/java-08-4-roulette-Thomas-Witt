import java.util.Random;
import java.util.Scanner;

public class Roulette2 {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Wie viel Geld möchtest du verlieren?");
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        int number;
        do {
            System.out.println("Möchtest du auf eine Farbe setzen (drücke 1), oder auf ein Drittel (drücke 2) oder möchtest du eine Zahl wählen (drücke 3)? Um aufzuhören drücke 'Q'.");
            String choice = scanner.next();
            if (choice.equals("q") || choice.equals("Q")) {
                System.out.println("Du nimmst dir " + money + "€ mit nach Hause. Auf Wiedersehen.");
                money = 0;
            } else {
                number = rand.nextInt(36);
                switch (choice) {
                    case "1" -> {
                        System.out.println("Auf welche Farbe möchtest du setzen? Rot für die ungeraden Zahlen (drücke 1), oder schwarz für die greaden Zahlen (drücke 2).");
                        int secondChoice = scanner.nextInt();
                        int bet;
                        do {
                            System.out.println("Wie viel von deinen " + money + "€ möchtest du setzen? ");
                            bet = scanner.nextInt();
                            if (bet > money) {
                                System.out.println("Es tut mir leid, du kannst nicht mehr setzen als du besitzt.");
                            }
                        } while (bet > money);
                        money = money - bet;
                        if (secondChoice == 1 && number % 2 == 1 || number != 0 && secondChoice == 2 && number % 2 == 0) {
                            System.out.println("Und die Glückszahl lautet ... " + number);
                            money = bet * 2 + money;
                            System.out.println("Herzlichen Glükwunsch. Du hast gewonnen. Du hast nun " + money + "€.");
                        } else {
                            System.out.println("Und die Glückszahl lautet ... " + number);
                            System.out.println("Oje. Das war wohl nichts. Du hast noch " + money + "€.");
                        }
                    }
                    case "2" -> {
                        System.out.println("Auf welches drittel möchtest du setzen? Für 1 - 12 drücke '1', für 13 - 24 drücke '2' und für 25 - 36 drücke '3':");
                        int secondChoice = scanner.nextInt();
                        int bet;
                        do {
                            System.out.println("Wie viel von deinen " + money + "€ möchtest du setzen? ");
                            bet = scanner.nextInt();
                            if (bet > money) {
                                System.out.println("Es tut mir leid, du kannst nicht mehr setzen als du besitzt.");
                            }
                        } while (bet > money);
                        money = money - bet;
                        if (secondChoice == 1 && number > 0 && number <= 12 || secondChoice == 2 && number >= 13 && number <= 24 || secondChoice == 3 && number >= 25) {
                            System.out.println("Und die Glückszahl lautet ... " + number);
                            money = bet * 3 + money;
                            System.out.println("Herzlichen Glükwunsch. Du hast gewonnen. Du hast nun " + money + "€.");
                        } else {
                            System.out.println("Und die Glückszahl lautet ... " + number);
                            System.out.println("Oje. Das war wohl nichts. Du hast noch " + money + "€.");
                        }
                    }
                    case "3" -> {
                        System.out.println("Auf welche Zahl möchtest du setzen?");
                        int secondChoice = scanner.nextInt();
                        int bet;
                        do {
                            System.out.println("Wie viel von deinen " + money + "€ möchtest du setzen? ");
                            bet = scanner.nextInt();
                            if (bet > money) {
                                System.out.println("Es tut mir leid, du kannst nicht mehr setzen als du besitzt.");
                            }
                        } while (bet > money);
                        money = money - bet;
                        if (secondChoice == number) {
                            System.out.println("Und die Glückszahl lautet ... " + number);
                            money = bet * 36 + money;
                            System.out.println("Herzlichen Glükwunsch. Du hast gewonnen. Du hast nun " + money + "€.");
                        } else {
                            System.out.println("Und die Glückszahl lautet ... " + number);
                            System.out.println("Oje. Das war wohl nichts. Du hast noch " + money + "€.");
                        }
                    }
                    default -> {
                        money = money / 2;
                        System.out.println("Soso? An Scheiß eingeben? no do hod si dei Vermögen glei amoi hoibiat! Du host nu " + money);
                    }
                }
            }
        } while (money > 0);
    }
}

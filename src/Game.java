import java.util.Scanner;

public class Game {

    // Scanner skapas en gång och används i hela klassen
    private Scanner scanner = new Scanner(System.in);

    // Huvudmetoden som kör hela spelet - anropas från Main
    public void run() {
        boolean playing = true; // styr om loopen (VG-kravet) ska fortsätta

        while (playing) {
            System.out.println("=== Nytt spel ===");

            // Skapar två spelare genom att fråga efter namn
            Player player1 = createPlayer(1);
            Player player2 = createPlayer(2);

            // Varje spelare slår tärningen två gånger
            playRound(player1);
            playRound(player2);

            // Jämför poäng och visar vinnaren
            showResult(player1, player2);

            // Frågar om användaren vill spela igen
            System.out.print("Vill du spela igen? (ja/nej): ");
            String answer = scanner.nextLine();

            if (!answer.equalsIgnoreCase("ja")) {
                playing = false; // avslutar while-loopen
            }
        }

        System.out.println("Tack för spelet!");
        scanner.close(); // stänger Scanner när programmet är klart
    }

    // Skapar en spelare genom att fråga efter förnamn och efternamn
    private Player createPlayer(int number) {
        String firstName = readNonEmpty("Spelare " + number + " förnamn: ");
        String lastName = readNonEmpty("Spelare " + number + " efternamn: ");
        return new Player(firstName, lastName);
    }

    // Läser in text från användaren och kontrollerar att den inte är tom
    private String readNonEmpty(String prompt) {
        while (true) { // fortsätter fråga tills giltig inmatning ges
            System.out.print(prompt);
            String input = scanner.nextLine();

            try {
                if (input.isEmpty()) {
                    // Kastar ett undantag om användaren bara tryckte Enter
                    throw new IllegalArgumentException("Värdet får inte vara tomt. Försök igen.");
                }
                return input; // returnerar värdet om det är giltigt
            } catch (IllegalArgumentException e) {
                // Fångar felet och visar meddelandet, sedan frågas det igen
                System.out.println(e.getMessage());
            }
        }
    }

    // Låter en spelare slå tärningen två gånger och lägger till poängen
    private void playRound(Player player) {
        System.out.println("--- " + player.getFullName() + " kastar ---");

        for (int i = 0; i < 2; i++) { // två kast per spelare
            int roll = Dice.roll();
            Dice.printDie(roll);
            System.out.println(player.getFullName() + " slog: " + roll);
            player.addToScore(roll);
        }
    }

    // Jämför spelarnas poäng och skriver ut resultatet samt vinnaren
    private void showResult(Player player1, Player player2) {
        System.out.println("--- Resultat ---");
        System.out.println(player1.getFullName() + " har " + player1.getScore() + " poäng");
        System.out.println(player2.getFullName() + " har " + player2.getScore() + " poäng");

        if (player1.getScore() > player2.getScore()) {
            System.out.println("Vinnare: " + player1.getFullName());
        } else if (player2.getScore() > player1.getScore()) {
            System.out.println("Vinnare: " + player2.getFullName());
        } else {
            System.out.println("Det blev oavgjort.");
        }
    }
}
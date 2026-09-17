import java.util.random.RandomGenerator;

public class Dice {

    // Statisk metod - kan anropas utan att skapa ett Dice-objekt (Dice.roll())
    // Slår en tärning och returnerar ett tal mellan 1 och 6
    public static int roll() {
        return RandomGenerator.getDefault().nextInt(1, 7); // 7 är inte inkluderat
    }

    // Skriver ut tärningen i ASCII-konst beroende på vilket tal som slogs
    public static void printDie(int roll) {

        String dice1 = """
                 -------
                |       |
                |   ●   |
                |       |
                 -------
                """;
        String dice2 = """
                 -------
                | ●     |
                |       |
                |     ● |
                 -------
                """;
        String dice3 = """
                 -------
                | ●     |
                |   ●   |
                |     ● |
                 -------
                """;
        String dice4 = """
                 -------
                | ●   ● |
                |       |
                | ●   ● |
                 -------
                """;
        String dice5 = """
                 -------
                | ●   ● |
                |   ●   |
                | ●   ● |
                 -------
                """;
        String dice6 = """
                 -------
                | ●   ● |
                | ●   ● |
                | ●   ● |
                 -------
                """;

        // Switch-uttryck som väljer rätt tärningsbild beroende på slaget
        switch (roll) {
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
            default -> System.out.println("Ogiltigt tärningsslag: " + roll); // skydd ifall roll inte är 1-6
        }
    }
}
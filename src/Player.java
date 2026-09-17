public class Player {

    // Privata attribut - kan bara nås inifrån klassen
    private String firstName;
    private String lastName;
    private int score;

    // Konstruktor - tar emot förnamn och efternamn och skapar en ny spelare
    public Player(String firstName, String lastName) {
        this.firstName = firstName; // "this" pekar på objektets eget attribut
        this.lastName = lastName;
        this.score = 0; // spelaren börjar alltid med 0 poäng
    }

    // Getter-metod som returnerar spelarens nuvarande poäng
    public int getScore() {
        return score;
    }

    // Lägger till poäng från ett tärningskast till spelarens totala score
    public void addToScore(int score) {
        // parametern "score" skuggar attributet, därför måste vi skriva this.score
        this.score = this.score + score;
    }

    // Returnerar förnamn och efternamn ihopsatta som en sträng
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
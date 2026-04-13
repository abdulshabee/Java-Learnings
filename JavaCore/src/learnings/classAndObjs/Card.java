package learnings.classAndObjs;

public class Card {

    private final int rank;
    private final int suite;

    public final static int DIOMONDS = 1;
    public final static int CLUBS = 2;
    public final static int HEARTS = 3;
    public final static int SPADES = 4;

    // RANKS
    public final static int ACE = 1;
    public final static int DUECE = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int JACK = 11;
    public final static int QUEEEN = 12;
    public final static int KING = 13;

    public Card(int rank, int suite){
        assert isValid(rank);
        assert isValidSuite(suite);
        this.rank = rank;
        this.suite = suite;
    }

    public static boolean isValid(int rank){
        return rank >= ACE && rank <= KING;
    }

    public static  boolean isValidSuite(int suite){
        return suite >= DIOMONDS && suite <= SPADES;
    }

}

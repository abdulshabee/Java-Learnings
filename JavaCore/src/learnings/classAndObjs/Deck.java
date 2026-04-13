package learnings.classAndObjs;

public class Deck {

    public static final int sumSuite = 4;
    public static final int sumRank = 13;

    private Card[][] cards;


    public Deck(){
        cards = new Card[sumSuite][sumRank];

        for (int suite = Card.DIAMOND; suite <= Card.SPADES; suite++){
            for(int rank = Card.ACE; rank <= Card.KING; rank++){
                cards[suite-1][rank-1] = new Card(suite,rank);
            }
        }
    }

    public Card getCards(int suite, int rank){
        return cards[suite -1][rank-1];
    }
}

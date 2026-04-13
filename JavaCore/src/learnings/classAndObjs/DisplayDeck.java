package learnings.classAndObjs;

public class DisplayDeck {

    public static void main(String[] args) {
        Deck deck = new Deck();

        for (int suite = Card.DIAMOND; suite <= Card.SPADES; suite++) {
            for (int rank = Card.ACE; rank <= Card.KING; rank++) {

                Card card = deck.getCards(suite,rank);

                System.out.printf("%s of %s %n",
                        Card.rankToString(rank),
                        Card.suitToString(suite));
            }
        }
    }
}

import java.util.ArrayList;

public class Deck {
    // also it is the instance variable
    // create constructor for our variables
    private ArrayList<Card> cards;
// constructor over here 
    public Deck(){
        this.cards = new ArrayList<Card>();
    }
// creates a full deck of cards, suit value returns everything like an array :)
    public void createFullDeck(){
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()) { // then make another card in the whole shbam
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }
    // need some sort of method to be able to shuffle said imaginary deck
    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        // ^^ pulls a random card
        int originalSize = this.cards.size();
        for (int i =0; i < originalSize; i ++) {
            randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) +1) + 0;
            // Random Index rand.nextInt((max - min) + 1) + min;  is a syntax to find a random number
            tmpDeck.add(this.cards.get(randomCardIndex));

            this.cards.remove(randomCardIndex); // this gets rid of the random varibles we put into this
        }
        this.cards = tmpDeck;

    }// randomly puts cards in deck which is a temporay a deck but the temp deck would be the shuffled deck

    public String toString(){
        String cardListOutput = "";
        // int i = 0; (testing reasons)
        // loop that makes a string with the card values
        for(Card zCard : this.cards) {
            cardListOutput += "\n" + i + "-" + zCard.toString();
            // i ++; (testing reasons)
        }
        return cardListOutput;
    }


    public void removeCard(int i ) {
        this.cards.remove(i);
    }
    public Card getCard(int i ){
        return this.cards.get(i);

    }
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    // method to some how draw a card to another
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0)); // possible way to get from the array list 
        comingFrom.removeCard(0);// removes card deck from 0
    }
}

public class Card {
    
    private Suit suit;
    private Value value;
    // making the constructor
    public Card(Suit suit, Value value){

        this.value = value;
        this.suit = suit;
    }
        // allows to reuturn suit and the value
    public String toString(){
        return this.suit.toString() + "-" + this.value.toString();
    }
        // uses to check value in the deck, also determines how many cards/points in the users hand
    public Value getValue(){
        return this.value;

    }
}

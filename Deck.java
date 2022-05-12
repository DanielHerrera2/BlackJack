import java.util.ArrayList;
import java.util.Random;

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
    int i = 0;// (testing reasons)
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

  public int deckSize(){
    return this.cards.size();
  }
  // so we need another method for redo the whole round once all is said and done
  public void moveAllToDeck(Deck moveTo){
    int thisDeckSize = this.cards.size();

    for(int i = 0; i < thisDeckSize; i ++){ // moves cards into the moveto Deck
      moveTo.addCard(this.getCard(i));
    }

    for(int i = 0; i < thisDeckSize; i++){
      this.removeCard(0);
    }
  }
  // method to some how draw a card to another
  public void draw(Deck comingFrom){
    this.cards.add(comingFrom.getCard(0)); // possible way to get from the array list
    comingFrom.removeCard(0);// removes card deck from 0
  }

  public int cardsValue(){
    int totalValue = 0;
    int aces = 0;

    for (Card zCard : this.cards){
      switch(zCard.getValue()){
        case TWO: totalValue += 2; break;
        case THREE: totalValue += 3; break;
        case FOUR: totalValue += 4; break;
        case FIVE: totalValue += 5; break;
        case SIX: totalValue += 6; break;
        case SEVEN: totalValue += 7; break;
        case EIGHT: totalValue += 8; break;
        case NINE: totalValue += 9; break;
        case TEN: totalValue += 10; break;
        case JACK: totalValue += 10; break;
        case QUEEN: totalValue += 10; break;
        case KING: totalValue += 10; break;
        case ACE: aces += 1; break;

      }
    }


    // for the aces if they have one
    for (int i = 0; i < aces; i++){
      if(totalValue > 10){
        totalValue += 1;
      }else{
        totalValue += 11; // deals with problem if player gets like 2 aces
      }
    }
    return totalValue;


  }
}
// method to to see all the cards in the deck or the dealers deck

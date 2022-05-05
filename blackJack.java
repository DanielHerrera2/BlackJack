import java.util.Scanner;

public class BlackJack {

  public static void main(String[] args){
    System.out.println("WELCOME TO BLACKJACK3!!!");
    // basic values for the game

    // BLACK JACK 3 because i tried 2 ways to create this and it turned out terrible
    Deck playingDeck = new Deck();
    playingDeck.createFullDeck();
    playingDeck.shuffle(); // this is that cool random method I'm proud i found
    // gaming aspect needs to be continued

    Deck playerDeck = new Deck();
    Deck dealerDeck = new Deck();
// something to keep track of the players $$$
    double playerMoney = 100.0;
    // need a double because its a small game and we dont mind a coulple rounding errors
    // decimal
    Scanner userInput = new Scanner(System.in);

    //turn based type game until there is no money
    while (playerMoney > 0) {
      System.out.println("YOU HAVE $ " + playerMoney + " HOW MUCH WOULD YOU LIKE TO BET?");

      double playerBet = userInput.nextDouble(); // if you lose more money than you have you get kicked out
      if(playerBet > playerMoney) {
        break;
      }
      // boolean needed to know when round is over to move on to the next round
      boolean endRound = false;

      // Dealt cards are drawn
      playerDeck.draw(playingDeck);
      playerDeck.draw(playingDeck);
      // now we cant forget the dealer
      dealerDeck.draw(playingDeck);
      dealerDeck.draw(playingDeck);

      while(true){
        System.out.println("Your HAND:");
        System.out.println(playerDeck.toString());
        System.out.println("Deck value is:" + playerDeck.cardsValue());

        System.out.println("Dealer Hand:" + dealerDeck.getCard(0).toString() + "and [Hidden");
        // hidden because you know only one card is showing when game is being played
        System.out.println("Would you like to (1)Hit or (2) Stand ?");
        int response = userInput.nextInt();

        //Next we need to show what hapens when the choices are selceted
        if(response == 1){
          playerDeck.draw(playingDeck);
          System.out.println("You drew:" + playerDeck.getCard(playerDeck.deckSize()-1).toString());
          // reason for the -1 is so it is indexed right. it is 0 based <<<
          if(playerDeck.cardsValue() > 21){
            System.out.println("Bust. Valued at:" + playerDeck.cardsValue());
            playerMoney -= playerBet;
            endRound = true;
            break;
          }
        }
        if(response==2){
          break;
        }
      }

      System.out.println("Dealer Cards: " + dealerDeck.toString());
      // for thr game aspect if the dealer has more than the dealer wins
      if((dealerDeck.cardsValue() > playerDeck.cardsValue())&& endRound == false){
        System.out.println("Dealer had a higher hand than you");
        playerMoney -= playerBet;
        endRound = true;
      }
      while((dealerDeck.cardsValue() < 17)&& endRound == false){
        dealerDeck.draw(playingDeck);
        System.out.println("Dealer Draws: " + dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
      }
      // Need something to display total value of dealer soooooooooo
      System.out.println("Dealer's Hand is valued at: " + dealerDeck.cardsValue());

      if((dealerDeck.cardsValue() > 21)&& endRound == false){
        System.out.println("Dealer busts! You win.");
        playerMoney += playerBet;
        endRound = true;
      }

      // Then something for the push or whatever we wanna call it
      if ((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false){
        System.out.println("Push");
        endRound = true;
      }

      // Statement when player whens
      if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false){
        System.out.println("Winner Winner Winner");
        playerMoney += playerBet;
        endRound = true;
      }
      else if(endRound == false) {
        System.out.println("You lose the hand.");
        playerMoney -= playerBet;
        endRound = true;
      }

      playerDeck.moveAllToDeck(playingDeck); // moves to the top deck using add method so the end of the array list is the bottom and the front is where we draw from so its 0
      dealerDeck.moveAllToDeck(playingDeck);
      System.out.println("End of hand");


    }
    System.out.println(" You are out!: (");

    System.out.println(playingDeck);
  }
}

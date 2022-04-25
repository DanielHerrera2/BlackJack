public class blackJack {
    
    public static void main(String[] args){
        System.out.println("WELCOME TO BLACKJACK3!!!");
            // BLACK JACK 3 because i tried 2 ways to create this and it turned out terrible
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle(); // this is that cool random method I'm proud i found
        // gaming aspect needs to be continued  

        System.out.println(playingDeck);
    }
}

import java.util.Random;
/*
 * Author: Aurel Hoxha
 * Date: June 29, 2017
 * Version JDK 1.8.0
 * Description: Holds a collection of cards.
 */
public class Cards
{
    //CONSTANTS
    private int FULLDECK = 52;
    
    //Properties of the Deck of Cards
    private Card[] deckOfCards;
    private int valid;
    
    //CONSTRUCTOR
    public Cards(boolean createFullPack)
    {
        //Initialize a deck that will contain 52 cards
        deckOfCards = new Card[ FULLDECK ];
        
        //Since it is empty no cards is available
        valid = 0;
        
        if ( createFullPack )
            createFullPackOfCards();
    }
    
    public int getValidCards()
    {
        return valid;
    }
    
    //Add a card to the top of the deck and return true if the operation is done
    //Return false if the operation is not done
    public boolean addTopCard( Card c )
    {
        //If we have place to put valid cards we add
        if( valid < deckOfCards.length )
        {
            deckOfCards[valid] = c;
            valid = valid + 1;
            return true;
        }
        //If there is no place for cards the operation is not done
        return false;
    }
    
    //Return the card that is found on the top of the deck
    public Card getTopCard()
    {
        //If the valid is smaller or equall to zero there is no card
        if( valid <= 0)
            return null;
        
        //If there are cards on the deck
        else
        {
            //Deacrese the valid number
            valid--;
            //Save the card at that location
            Card temporary = deckOfCards[valid];
            //Remove the card from the deck
            deckOfCards[valid] = null;
            //Return the card to the user
            return temporary;
        }
    }
    
    //Create a Deck full of Cards
    public void createFullPackOfCards()
    {
        //Go from 0 until 51
        for( int i = 0; i < 52; i++ )
            addTopCard( new Card(i) );
        
        //Make the valid 52 so we have 52 valid cards
        valid = 52;
    }
    
    // This Method shuffle the cards
    public void shuffle()
    {
        //Shuffle the cards by changing a lot of cards
        //Use Random class to find a random number for which location of cards to change
        Random gen = new Random();
        int location1,location2;
        for ( int i = 0 ; i < 550 ; i++ )
        {
            location1 = gen.nextInt(valid );
            location2 = gen.nextInt( valid );
            swapCards (location1 , location2);
        }
    }
    
    //Swap two Cards
    private void swapCards( int card1, int card2 ) 
    {
        Card temp = deckOfCards[card1];
        deckOfCards[card1] = deckOfCards[card2];
        deckOfCards[card2] = temp;
    }
    

}
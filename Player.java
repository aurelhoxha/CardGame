/*
 * Author: Aurel Hoxha
 * Date: June 29, 2017
 * Version JDK 1.8.0
 * Description: Holds a collection of cards.
 */

public class Player
{
    //Properties that a player have
    private String name;
    private Cards cardsOnHand;
    
    //Constructor
    //Create a new player giving his name and don't create a full pack of cards
    public Player(String name)
    {
        this.name = name;
        cardsOnHand = new Cards( false );
    }
    
    //Return the name of the Player
    public String getName()
    {
        return name;
    }
    
    //Add a Card to the player hand
    public void addCard( Card addedCard )
    {
        cardsOnHand.addTopCard(addedCard);
    }
    
    //Play one card from the User hand
    public Card playCard()
    {
        if (cardsOnHand.getValidCards() == 0 )
            return null;
        else
            return cardsOnHand.getTopCard();
    }
    
}
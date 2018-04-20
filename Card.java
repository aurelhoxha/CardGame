/*
 * Author: Aurel Hoxha
 * Date: June 29, 2017
 * Version JDK 1.8.0
 * Description: Hold all the properties than a simple card can have.
 * 
 */

public class Card
{
    
    //CONSTANTS
    final String[] SUITS = {"Hearts","Diamonds","Spades","Clubs"};
    final String[] FACES = {"A","1","2","3","4","5","6","7","8","9","10","J","Q","K"};
    
    //Properties of the Card
    private int cardValue;
    
    //CONSTRUCTORS
    public Card(int faceValue, int suit)
    {
        cardValue = suit * 13 + faceValue;
    }
    
    public Card(int cardValue)
    {
        this.cardValue = cardValue;
    }
    
    //Return the number that the card has
    public int getFaceValue()
    {
        return cardValue % 13;
    }
    
    //Return the suit of the card divind it by 13
    public int getSuit()
    {
        return cardValue / 13;
    }
    
    //Return the card Value
    public int getCardValue()
    {
        return cardValue;
    }
    
    //Prints the Card Information
    public String toString()
    {
        String faceOfCard = FACES[ getFaceValue() ];
        String suitOfCard = SUITS[ getSuit() ];
        return faceOfCard + " of " + suitOfCard;
    }
  
    // Compare two Cards whether two cards have the same value
    public boolean equals( Object otherCard )
    {
        Card myCard = (Card) otherCard;
        //Cast the Object to Card and if the faceValue is same return true
        if ( this.getCardValue() == myCard.getCardValue() )
            return true;
        
        //If cards are not same return false
        else
            return false;
    }
  
    // Compare this Card with another Card c
    public int compareTo( Card c)
    {
        int biggerCard;
        //If faceValues are not equal
        if ( this.getFaceValue() != c.getFaceValue() ) 
            biggerCard = this.getFaceValue() > c.getFaceValue() ?  1 :  -1;
        
        //If the FaceValues are not equal
        else
            biggerCard = this.getSuit() > c.getSuit() ?  1 :  -1;
        return biggerCard;
    }
    
}
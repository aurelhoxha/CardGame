/*
 * Author: Aurel Hoxha
 * Date: June 30, 2017
 * Version JDK 1.8.0
 * Description: Test the classes created
 */

public class TestClasses
{
    public static void main(String[] args)
    {
        
        // VARIABLES
        
        //Properties that need to be initialized
        Card       mCard;
        Cards      mCards;
        ScoreCard  scores;
        Player     p1,p2,p3,p4;

        
        // PROGRAM CODE
        
        //Create a new card and print it which calls the toString Method of the Card
        mCard = new Card( 2 );
        System.out.println( mCard );
        System.out.println();
        
        // Create an object of Cards which is full packed and add our card to the top
        mCards = new Cards( true);
        mCards.addTopCard( mCard);
        
        // Create a Scorecard for four player and updates the scores of some players 
        scores = new ScoreCard( 4);
        scores.update( 0, 7);
        scores.update( 3, 6);
        System.out.println( "\n" + scores );
        
        // Create some objects of players and initialize those
        p1 = new Player("Aurel");
        p2 = new Player("Andi");
        p3 = new Player ("Serxhio");
        p4 = new Player  ("Arlind");
        

        System.out.println( "\nEnd of CardGameTest\n" );

    }
}
import java.util.*;
/*
 * Author: Aurel Hoxha
 * Date: June 30, 2017
 * Version JDK 1.8.0
 * Description:Test The Card Game
 */
public class FinalCardGame
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of MyCardGame\n");
        
        // CONSTANTS
        final int MENU_EXIT    = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_PLAY_P4 = 4;
        final int MENU_SCORES  = 5;
        
        // VARIABLES
        Player     player1, player2, player3, player4;
        CardGame   mGame;
        int        selection;
        
        // PROGRAM CODE
        
        // create players...
        player1 = new Player( "First  Student");
        player2 = new Player( "Second Student");
        player3 = new Player( "Third  Student");
        player4 = new Player( "Fourth Student144");
        
        // create game with the 4 players...
        mGame = new CardGame( player1, player2, player3, player4);
        
        // display menu, get and process selection, until exit
        do 
        {
            // display menu
            System.out.println();
            System.out.println( "MyCardGame   Round: " + mGame.getRoundNo() 
                                   + "\t TurnOfPlayer: " + (mGame.getTurnOfPlayerNo() + 1) );
            System.out.println();
            System.out.println( MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays" );
            System.out.println( MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays" );
            System.out.println( MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays" );
            System.out.println( MENU_PLAY_P4 + " - Player " + MENU_PLAY_P4 + " plays" );
            System.out.println( MENU_SCORES  + " - Show scores" );
            
            // ask for and get selection
            System.out.println();
            System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
            selection = scan.nextInt();
            
            // process selection
            if ( selection == MENU_PLAY_P1 )
                play( player1, mGame);
            
            else if ( selection == MENU_PLAY_P2 )
                play( player2, mGame);
            
            else if ( selection == MENU_PLAY_P3 )
                play( player3, mGame);
            
            else if ( selection == MENU_PLAY_P4 )
                play( player4, mGame);
            
            else if ( selection == MENU_SCORES )
                System.out.println( mGame.showScoreCard() );
            
            else if ( selection != MENU_EXIT)
                System.out.println( "Invalid selection! \n" );
            
        } while ( selection != MENU_EXIT && !mGame.isGameOver());
        
        // display winners...
        
        System.out.println( "\nGame Over, Scores:" );
        System.out.println( mGame.showScoreCard() );
        printWinners( mGame );
        System.out.println( "\nEnd of MyCardGame\n" );
        scan.close();
    }
    
    // ToDo...
    // get the card, c, that player p wants to play
    // pass c to the game, see if it accepted c from p
    // if game didn't accept the card, give c back to the player! 
    // return accepted.
    static boolean play( Player p, CardGame mGame)
    {
        // No need to return card since playTurn won't remove card unless acceptable
        boolean    accepted;
        accepted = mGame.playTurn(p, null); 
        return accepted;
    }
    static void printWinners ( CardGame mGame ){
        String winners = "";
        for ( int i = 0; i <3 ; i++) 
            if ( mGame.getWinners()[i] != null)
            winners += mGame.getWinners()[i].getName() +"\n";
        System.out.println( "The Winners are:\n" + winners );
    }
}
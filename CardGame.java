import java.util.ArrayList;
/*
 * Author: Aurel Hoxha
 * Date: June 30, 2017
 * Version JDK 1.8.0
 * Description: Create all the logic and what happens in the game
 */

public class CardGame
{
    // PROPERTIES
    Cards             mFullPack;
    ArrayList<Player> mPlayers;
    ScoreCard         mScoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    
    // CONSTRUCTORS
    public CardGame( Player player1, Player player2, Player player3, Player player4)
    {
        // Initialize Variables
        
        //Add the players to the ArrayList of the Players
        mPlayers = new ArrayList<Player>();
        mPlayers.add(player1);
        mPlayers.add(player2);
        mPlayers.add(player3);
        mPlayers.add(player4);
        
        //Initialize an an ArrayList of size 4 that will hold cards for each player
        cardsOnTable = new Cards[4];
        for (int i = 0; i <4 ; i++)
            cardsOnTable[i] = new Cards ( false);
        
        //Create a pack of cards and shuffle it 
        mFullPack = new Cards (true);
        mFullPack.shuffle();
        
        //Distribute the cards to the player by calling distributeCards
        distributeCards();
        
        //Initialize the ScoreCard by adding four players to it
        mScoreCard = new ScoreCard (4);
        
        //Initialize the round to one and make the firstPlayer to start
        roundNo = 1;
        turnOfPlayer = 0;
    }
    
    // PlayTurn methods runs until the game is not over
    // If a players tends to play when it's not his/her turn a message is printed
    // If the player plays on his/her turn the topCard is taken
    // If the 4 player is playing the cards are checked and the result are updated
    public boolean playTurn( Player p, Card c)
    {
        
        if ( isGameOver())
            return false;
        else if ( !isTurnOf(p)) {
            System.out.println ("It is not your turn. Please be patien!");
            return false;
        }
        
        // If the 4 player is playing the cards are checked and the result are updated
        else 
        {
            cardsOnTable[turnOfPlayer ].addTopCard(p.playCard());
            //Update turns
            if ( turnOfPlayer == 3) 
            {
                updateScores();
                roundNo++;
                turnOfPlayer = 0;
            }
            //If the player is not the last just update the turn of the player
            else turnOfPlayer++;
        }
        return true;
    }
    
    //Distribute the cards from the table pack to each player pack
    private void distributeCards() 
    {
        // Distribute the cards to the players
        // It need to go round 13 times since there are 52 cards
        // Everytime it gets the top cards and add the the player pack of cards
        for (int i = 0; i <13 ; i++) 
            for ( int turn = 0 ; turn < 3 ; turn++)
            mPlayers.get(turn).addCard(mFullPack.getTopCard());
    }
    
    
    private void updateScores() 
    {
        Card[] cards = new Card [4];
        Card highestCard;
        int highestIndex;
        
        for ( int i = 0; i < 4 ; i++ ){
            cards[i] = cardsOnTable[i].getTopCard();
        }
        highestCard = cards[0];
        highestIndex = 0;
        for ( int i = 1 ; i < 3 ; i++) 
            if ( cards[i].compareTo(highestCard) > 0){
            highestCard = cards[i];
            highestIndex = i;
        }
        
        //Make the scorecard of the player that has the highestCard 1
        mScoreCard.update(highestIndex, 1);
    }
    
    //Check if the the turn of a specific player
    public boolean isTurnOf( Player p)
    {
        if ( mPlayers.indexOf(p) == turnOfPlayer )
            return true;
        else return false;
    }
    
    // Check if the game is OVER
    // The game is over after 13 rounds
    public boolean isGameOver()
    {
        if ( roundNo > 13)
            return true;
        else return false;
    }
    
    // Return the score for a specific player
    // Calls getScore method for that player
    public int getScore( int playerNumber)
    {
        return mScoreCard.getScore(playerNumber);
    }
    
    // Return the name of the player by giving the player number
    public String getName( int playerNumber)
    {
        return mPlayers.get(playerNumber).getName();
    }
    
    //Return the round of the game
    public int getRoundNo()
    {
        return roundNo;
    }
    
    //Return the turn when the player should play
    public int getTurnOfPlayerNo()
    {
        return turnOfPlayer;
    }
    
    // Return the winner or the winners of the games
    public Player[] getWinners()
    {
        // Goes through the ArrayList of all players
        // If the scoreCard is 1 it means that the player is a winner
        Player[] winners = new Player[4];
        for ( int i = 0; i < 4 ; i++)
            if (mScoreCard.getWinners()[i] == 1)
            winners[i] = mPlayers.get(i);
        // Return the winners
        return winners;
        
    }
    
    //Print the result of the scoreCard for the moment
    public String showScoreCard() 
    {
        return mScoreCard.toString();
    }
    
}
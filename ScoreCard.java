/*
 * Author: Aurel Hoxha
 * Date: June 29, 2017
 * Version JDK 1.8.0
 * Description: Holds a collection of cards.
 */

public class ScoreCard
{
    private int[] scores;
    
    //Constructor
    public ScoreCard( int numberOfPlayers )
    {
        //Create a array of integers based on the number of players
        scores = new int[numberOfPlayers];
        
        //Reset all the players' score to 0
        for(int i = 0 ; i < numberOfPlayers; i++ )
            scores[i] = 0; 
    }
    
    //Returns specified score
    public int getScore(int scoreNo)
    {
        return scores[scoreNo];
    }
    
    //Add amount to scoreNo
    public void update(int scoreNo, int amount)
    {
        scores[scoreNo] =  scores[scoreNo] + amount;
    }
    
    //Print all the scores
    public String toString()
    {
        String scoreResult;
        
        //Print the score into a good manner
        scoreResult = "\n"
            + "**********************\n"
            + "*  Player\tScore *\n"
            + "**********************\n";

        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            scoreResult = scoreResult + "*  " + playerNo + "\t\t    " + scores[playerNo] + " *\n";
        }

        scoreResult += "**********************\n";
        return scoreResult;
    }

    //Print the 
    public int[] getWinners() //returns 1 if player is a winner, 0 if not
    {
        //Create an array to keep the position of the winners
        int[] winners = new int[ scores.length ];
        
        //Initiliaze the first score as the biggest
        int temp = scores[0];
        
        //If any score bigger are found change the value of the biggest score
        for ( int i = 1; i < scores.length; i++)
        {
            if (scores[i] > temp )
                temp = scores[i];
        }
        
        //If there are found players with the same score make them winners
        for (int i = 0 ; i < scores.length; i++ )
        {
            if ( scores[i] == temp)
                winners[i] = 1;
            else winners[i] = 0;
        }
        
        return winners;  
 }

}
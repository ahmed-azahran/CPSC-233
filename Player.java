import java.util.Scanner;

public class Player{

    ////Fields////

    /** the type of player.
     * 0 for human
     * 1 for AI level 1
     * 2 for AI level 2
     * 3 for AI level 3
     */
    private int playerType;
    /** the selected position by the player (0 ~ 8)
     */
    private int selectedPosition;

    ////Methods////

    public Player() {
        playerType = 0;
        selectedPosition = 0;
    }

    /** set the player type.
     * @param type either 0,1,2 or 3
     */
    public void setPlayerType(int type){
        playerType = type;
    }

    /** get the AI's command
     * @param level the level of AI
     * @return the position chosen
     */
    public int getAICommand(int level){     //for next objective
        return(0) ;
    }


    ////Getter Methods////

    /** get the player type
     * @return the player type
     */
    public int getPlayerType(){
        return playerType;
    }

    /** get the selected position
     * @return the selected position
     */
    public int getSelectedPosition(){
        return selectedPosition;
    }



}//end class

import java.util.*;
import java.io.*;


public class Display{

    /// Instance Variables ///

    private Game game;

    /** The save state of the game. Contains the current progress
     */
    private Save saveState;
    private int player = 0;

    /// Public Methods ///

    /** creates a new game
     */
    public Display(){
        game = new Game();
    }

    /** set level of ai
    */
    public void setLevel(int i){
        game.setLevel(i);
        // if(i!=-1)System.out.println("here setting ai level to "+i);
    }

    /** reset the game
    */
    public void reset(){
        game = new Game();
    }

    /** getPlayer
    * @return the player that has its turn right now
    */
    public int getPlayer(){
        return player;
    }

    /// Private Methods ///

    /** draws the page for the main game
    */
    public void draw(){

        //display board
        show();

        boolean win = false;
        while(win == false){//loop game until someone wins

            //ask for player to make a move
            ask();
            //display board
            show();

            //Check for win
            win = checkWin();

            //Ask AI for move (if ai is activated)
            if(!win && game.getLevel()!=-1){

                int move = game.getMove();
                if(move!=-1){
                    player = 0;
                    win = checkWin();
                    System.out.println("The computer is making its move");
                    show();
                }
            }//end check win
        }
    }//end draw()

    /** restart the menu
     */
    private void menu(){
        Menu menu = new Menu();
        menu.draw();
    }



    /** check for winners and display the result
     */
    private boolean checkWin(){

        int status = game.getBoard().getStatus();
        if(status == 1){
            //Show message
            System.out.println("Player O wins!");

            /////////////////////////////////////////////
            int next = game.getLevel()+1;
            Save save = new Save();
            save.save(next);
            /////////////////////////////////////////////
            menu();
            return true;
        }
        else if(status == 2){
            //Show message
            System.out.println("Player X wins!");
            menu();
            return true;
        }
        else if(status == 3){
            //Show message
            System.out.println("It's a tie!");
            menu();
            return true;
        }
        if(status != 0){//no one wins yet
            return false;
        }
        return false;
    }

    /** ask for player input
     */
    private void ask(){
    System.out.println("Place your mark: enter an integer for the corresponding space (0~8)");
    Scanner scanner = new Scanner(System.in);
    try{
        int i = scanner.nextInt();
        if(i>=0 && i<=8){
            //If the clicked button is available
            if(game.getBoard().checkEmpty(i)){

                //Place mark on board
                if(player == 0){
                    game.getBoard().setO(i);
                    player = 1;
                }
                else{
                    game.getBoard().setX(i);
                    player = 0;
                }
            }//if space available
            else{
                System.out.println("Error: Selected position is already taken.");
                ask();
            }
        }//if not valid input
        else{
            System.out.println("Error: Invalid input.");
            ask();
        }
    }catch(Exception e){
        System.out.println("Error: Invalid input. Entry not an integer number.");
        ask();
    }//end exception
    }//end ask

    /** display board
     */
    private void show(){
        //refresh the board every time
        int [] curBoard = new int[9];

        //Display Board///////
        curBoard = game.getBoard().getBoard();
        for(int x = 0 ; x<9; x++){
            if(x==0 || x==3 || x==6){
                System.out.println("");
            }
            if(curBoard[x]==0)System.out.print(" _ ");
            if(curBoard[x]==1)System.out.print(" O ");
            if(curBoard[x]==2)System.out.print(" X ");
        }
        System.out.println("");
        System.out.println("");
    }




}//end class

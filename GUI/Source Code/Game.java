
public class Game{

    /// Instance Variables ///

    /** Board object to handle game state/logic
     */
    private Board board;

    /** AI object, to produce the Computer Player's moves
    */
    private AI computer;

    /// Constructor Methods ///

    /** Constructor initializes the players and the board
     */
    public Game() {
        board = new Board();
        computer = new AI(board);
    }

    /// Public Methods ///

    /** Get the AI's move
    * @return the move
    */
    public int getMove(){
        return computer.getMove();
    }


    /** Set AI difficulty
    * @param i the level selected
    */
    public void setLevel(int i){
        computer.setLevel(i);
    }

    /** Get AI difficulty
    * @return the level
    */
    public int getLevel(){
        return computer.getLevel();
    }

    /** Gets the board object
     *  @return the board object
     */
    public Board getBoard(){
        return board;
    }

    /// Private Methods ///

    /** Clears the board
     */
    private void reset() {
        board.clear();
    }

}//end class

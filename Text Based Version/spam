import java.util.Random;

public class AI extends Player {

    /// Instance Variables ///

    /** Declaring a board object called "board"
     */
    private Board board;

    /** Difficulty level of the AI player;
     *  0 for AI level 0 - Easyiest
     *  1 for AI level 1
     *  2 for AI level 2
     *  3 for AI level 3
     *  4 for AI level 4 - Hardest
     */
    private int difficultyLevel;

    /** The first move in the game
     */
    private boolean firstMove = true;

    /// Constructor Methods ///

    /** Initializes an AI object with the sepecified board and AI difficulty level
    * @param board passing the Board object
    */
    public AI(Board board) {
        this.board = board;
    }
    /** Mutator for setting the level of difficulty
    * @param level the difficulty level chosen by the user
    */
    public void setLevel(int level){
        difficultyLevel = level;
    }

    /// Other Methods ///

    /** Accessor for getting the level of difficulty
    * @return difficultyLevel
    */
    public int getLevel(){
        return difficultyLevel;
    }

    /** Accessor for getting the move based on the difficulty level
    * @return move
    */
    public int getMove() {
        int move = -1;

        if (this.difficultyLevel == 0){
            move = difficultyZero();
        } else if (this.difficultyLevel == 1) {
            move = difficultyOne();
        } else if (this.difficultyLevel == 2) {
            move = difficultyTwo();
        } else if (this.difficultyLevel == 3) {
            move = difficultyThree();
        }
        else if (this.difficultyLevel == 4) {
            move = difficultyFour();
        }

        return move;
    }

    /** The AI will try to lose on this difficulty
    * @return moveAttempt
    */
    private int difficultyZero() {

        Board temp;
        int not = -1;

        for(int i=0; i<9; i++){
            temp = new Board(board);
            if(temp.checkEmpty(i)){
                temp.setO(i);
                if(temp.getStatus()!=0){
                    not = i;
                    break;
                }
            }
        }

        Random newRand = new Random();
        Boolean moveIncomplete = true;

        int moveAttempt = 0;
        while(moveIncomplete) {
            moveAttempt = newRand.nextInt(8);

            if (board.checkEmpty(moveAttempt) && moveAttempt!= not) {
                board.setX(moveAttempt);
                moveIncomplete = false;

            }
            if(moveAttempt == not){
                not = -1;
            }
        }

        return moveAttempt;
        }

    /** The AI will make random moves
    * @return moveAttempt
    */
    private int difficultyOne() {
        Random newRand = new Random();
        Boolean moveIncomplete = true;

        int moveAttempt =0;
        while(moveIncomplete) {
            moveAttempt = newRand.nextInt(8);

            if (board.checkEmpty(moveAttempt)) {
                board.setX(moveAttempt);
                moveIncomplete = false;

            }}

        return moveAttempt;
        }

    /** The AI will try to block you from winning
    * @return move
    */
    private int difficultyTwo() {

        Board temp;

        for(int i=0; i<9; i++){
            temp = new Board(board);
            if(temp.checkEmpty(i)){
                temp.setO(i);
                if(temp.getStatus()!=0){

                    board.setX(i);
                    return i;
                }
            }
        }
        int move = difficultyOne();

        return move;
}

    /** The AI will try to block you and win (if possible)
    * @return move
    */
    private int difficultyThree() {

        Board temp;

        for(int i=0; i<9; i++){
            temp = new Board(board);
            if(temp.checkEmpty(i)){
                temp.setX(i);
                if(temp.getStatus()!=0){

                    board.setX(i);
                    return i;
                }
            }
        }
        int move = difficultyTwo();

        return move;
        }

    /** This AI incorporates logic from difficulty three
    * It will additional attempt to secure the corner spots
    * If not, it will secure the center
    * @return move
    */
    private int difficultyFour() {

        if(firstMove){
        if(board.checkEmpty(4)){

            board.setX(4);
            firstMove = false;
            return 4;
        }
        else if(board.checkEmpty(0)){

            board.setX(0);
            firstMove = false;
            return 0;
        }
        else if(board.checkEmpty(2)){

            board.setX(2);
            firstMove = false;
            return 2;
        }
        else if(board.checkEmpty(6)){

            board.setX(6);
            firstMove = false;
            return 6;
        }
        else if(board.checkEmpty(8)){

            board.setX(8);
            firstMove = false;
            return 8;
        }
        }


        int move = difficultyThree();

        return move;
        }


}

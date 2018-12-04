public class Board {

	////Fields////

	/** Integer array of 9 spaces representing the board for player O.
	*/
	private int[] boardO = new int[9];

	/** Integer array of 9 spaces representing the board for player X.
	*/
	private int[] boardX = new int[9];

	/** Integer array representing the win condition.
	{{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}}*/
	private int[][] winCondition = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

	//// Constructors ////
    
    /** Default constructor
    */
    public Board() {
    }

    /** Copy constructor
    * @param other passing a board object
    */
    public Board(Board other){
        int [] tempO = new int[9];
        int [] tempX = new int[9];
        tempO = other.getBoardO();
        tempX = other.getBoardX();
        for(int i=0; i<9; i++){
            boardO[i] = tempO[i];
            boardX[i] = tempX[i];
        }
    }

	////Methods////

    /** Void method with no arguments.
    *  Sets all boardO and boardX values to 0.
    */
	public void clear() {
		for (int index = 0; index < boardO.length; index++) {
			boardO[index] = 0; // reset all members of boardO to 0.
		}
		for (int index = 0; index < boardX.length; index++) {
			boardX[index] = 0; // reset all members of boardX to 0.
		}
	}

	/** Marks a specific position on boardX with 'O'.
    * @param position the position on boardO that will be marked.
    */
	public void setO(int position) {
		boardO[position] = 1;
	}

	/** Marks a specific position on boardX with 'X'.
    * @param position the position on boardX that will be marked.
    */
	public void setX(int position) {
		boardX[position] = 1;
	}

    /** Checks if the space of the given position is available.
    * @param position the position on boardX or boardO that will be marked.
    * @return the empty space
    */
    public boolean checkEmpty(int position) {
        boolean spaceEmpty = false;

        int[] fullBoard = getBoard();

        if (fullBoard[position] == 0) {
            spaceEmpty = true;
        }
        return spaceEmpty;
    }

    /** Creates an array named "fullBoard", which represents all of the non-zero
    * values from boardO as the number 1 and all of the non-zero values from
    * boardX as the number 2.
    * @return the full board containing both player's entries.
    */
    public int[] getBoard() {
        int[] tempArray = new int[9];
        int[] fullBoard = new int[9];

		for(int index = 0; index < boardX.length; index++) {
                    // create a temporary array which contains the values of
                    // boardX multiplied by 2.
					tempArray[index] = boardX[index]*2;
			}

		for(int index = 0; index < boardX.length; index++) {
					fullBoard[index] = tempArray[index] + boardO[index];
			}
		return fullBoard;
    }

    /** Checks boardO for a winning configuation and returns a boolean value.
    * @return the boolean value representing whether the player has won
    */
    private boolean checkWinO() {
        boolean checkWin = false;
        int temp = 0;

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 3; j++) {
                // for loops allow the 2d array to be iterated through.
                temp += boardO[winCondition[i][j]];
                if (temp == 3) {
                    checkWin = true;
                }
            }

        temp = 0;  // temp value resets for each winCondition/completion of the second for loop.
        }
        return checkWin;
    }

    /** Checks boardX for a winning configuation and returns a boolean value.
    * @return the boolean value representing whether the player has won
    */
    private boolean checkWinX() {
        boolean checkWin = false;
        int temp = 0;

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 3; j++) {
                // for loops allow the 2d array to be iterated through.
                temp += boardX[winCondition[i][j]];
                if (temp == 3)
                {
                    checkWin = true;
                }
            }
        temp = 0; // temp value resets for each winCondition/completion of the second for loop.
        }
        return checkWin;
    }

    /** Checks if the combined board of boardO and boardX contains only non-zero entries.
    * @return the boolean value representing whether the board is full or not
    */
    private boolean checkTie() {
        boolean checkTie = false;
        int temp = 0;

        for (int index = 0; index < 9; index++) {
            // sums the entries of both boardO and boardX.
            temp += boardO[index];
            temp += boardX[index];
        }
        if (temp == 9) { // if entires sum to 9, then all 9 spaces have been populated.
            checkTie = true;
        }
        return checkTie;
    }

    /** Accessor method for boardO
    * @return boardO
    */
    public int[] getBoardO(){
        return boardO;
    }

    /** Accessor method for boardX
    * @return boardX
    */
    public int[] getBoardX(){
        return boardX;
    }

    /** Checks if boardO and boardX satisfy any game ending conditions.
    * 0 represents that no game ending condition has been met
    * 1 represents that Player O has won
    * 2 represents that Player X has won
    * 3 represents that the game has ended in a tie
    * @return returns the values 0, 1, 2, or 3
    */
    public int getStatus() {
        // Call the respective check for each constions and assign result to boolean.
        boolean winO = checkWinO();
        boolean winX = checkWinX();
        boolean tie = checkTie();

        int status = 0; // initailize status

        if (winO) {
            status = 1;
        } else if (winX) {
            status = 2;
        } else if (tie) {
            status = 3;
        }
        return status;
    }
}

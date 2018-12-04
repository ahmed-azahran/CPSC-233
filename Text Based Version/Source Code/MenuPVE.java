import java.util.*;
import java.io.*;


public class MenuPVE{

    /// Instance Variables ///


    /** The display object that will draw the game in the command/line terminal
     */
    private Display display;

    /** The save state of the game. Contains the current progress
     */
    private Save saveState = new Save();


    /// Public Methods ///


    /** Reset the game board display
     */
    public void MenuPVE(){
        display = new Display();
    }

    /** Draws the PVE menu and runs all necessary menu functionality
     */
    public void draw() {

        // Load the user's save progress
        int saveProgress = saveState.load();

        // Print menu text, adjusted for the user's save progress
        displayMenuText(saveProgress);

        // Get user's input for selection
        int userSelection = getUserInput(0, saveProgress);

        // Print selection text. adjusted for the user's selection
        levelSelectionText(userSelection);

        // Create/display the game board with the user selected Computer Level
        display = new Display();
        display.setLevel(userSelection);
        display.draw();
    }


    /// Private Methods ///


    /** Displays the menu text, adjusting for save progress
     * @param saveProgress value indicating the highest level of AI unlocked
     */
    private void displayMenuText(int saveProgress) {

        // Print menu text
        System.out.println("\nPVE MENU\n");
        System.out.println("Computer Battle!\n");
        System.out.println("Choose the difficulty level for the Computer Player.\n");
        System.out.println("Difficulty levels range from 0 (Easiest) to 4 (Hardest).");
        System.out.println("Complete a level to unlock a level of higher difficulty!\n");

        System.out.println("Enter 0 for COMPUTER LEVEL ZERO");

        // Print additional options depending on saveProgress
        if(saveProgress > 0) System.out.println("Enter 1 for COMPUTER LEVEL ONE");
        if(saveProgress > 1) System.out.println("Enter 2 for COMPUTER LEVEL TWO");
        if(saveProgress > 2) System.out.println("Enter 3 for COMPUTER LEVEL THREE");
        if(saveProgress > 3) System.out.println("Enter 4 for COMPUTER LEVEL FOUR");
    }

    /** Displays the AI description according to the user's selection
     * @param userSelection value indicating the level of AI selected
     */
    private void levelSelectionText(int userSelection) {
        switch (userSelection) {
            case 0:
                System.out.println("Level 0 AI: This AI will try to lose to you");
                break;
            case 1:
                System.out.println("Level 1 AI: This AI will randomly place their mark");
                break;
            case 2:
                System.out.println("Level 2 AI: This AI will block you if you are going to win");
                break;
            case 3:
                System.out.println("Level 3 AI: This AI will block you and attempt to win");
                break;
            case 4:
                System.out.println("Level 4 AI: This AI will try its best to tie with you or win");
                break;
        }
    }

    /** Gets keyboard input, and checks that the input is within the desired range
     *  if so, returns the input
     *  in not, prints appropriate error message and prompts user for input again
     * @param min Minimum acceptable value that the user can enter
     * @param max Maximum acceptable value that the user can enter
     * @return User's input
     */
    private int getUserInput(int min, int max) {
        // Create flag for loop
        boolean inputValid = false;
        // Create Scanner object to take keyboard input
        Scanner keyboardStream = new Scanner(System.in);
        // Create variablesto hold keyboard input
        int keyboardInput = -1;

        while(!inputValid) {

        try {

            // Get input from keyboard
            System.out.print("Your Selection: ");
            keyboardInput = Integer.parseInt(keyboardStream.next());
            System.out.print("\n");

            if ((keyboardInput >= min) && (keyboardInput <= max)) {

                // If input is within the expected range set flag to true
                inputValid = true;
            } else if ((keyboardInput <= min) || (keyboardInput >= max)) {

                // Print error message on input outside of range
                System.out.printf("Error: Invalid input. Entry is not within range (%d - %d).\n", min, max);
            }
        } catch (NumberFormatException e) {

            // Print error message on non-numaric input
            System.out.println("Error: Invalid input. Entry not an integer number.");
        }}

        return keyboardInput;
    }
}//end class

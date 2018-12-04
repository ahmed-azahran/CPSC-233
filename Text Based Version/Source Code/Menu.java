import java.util.*;
import java.io.*;


public class Menu{

    /// Instance Variables ///


    /** The display object that will draw the game board in the command/line terminal
     */
    private Display display;


    /// Public Methods ///


    /** Reset the game board display
     */
    public void Menu(){
        display = new Display();
    }

    /** Draws the main menu and runs all necessary menu functionality
     */
    public void draw() {

        // Display welcome text
        displayMenuText();

        // Get user keyboard input
        int userSelection = getUserInput(1, 2);

        // If PVP is selected, draw game board

        if (userSelection == 1) {
            display = new Display();
            display.setLevel(-1);
            display.draw();
        }

        // If PVE is selected, draw PVE menu
        if (userSelection == 2) {
            MenuPVE pveMenu = new MenuPVE();
            pveMenu.draw();
         }

    }


    /// Private Methods ///


    /** Displays the menu text
     */
    private void displayMenuText() {

        // Print menu text
        System.out.println("\nTIC-TAC-TOE\n");
        System.out.println("MAIN MENU\n");

        System.out.println("PVP - Battle agaisnt a friend!");
        System.out.println("PVE - Battle agaisnt the computer!\n");
        System.out.println("Choose the game mode: \nEnter 1 for PVP \nEnter 2 for PVE");
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
            
            keyboardStream = new Scanner(System.in);
            keyboardInput = Integer.parseInt(keyboardStream.nextLine());

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

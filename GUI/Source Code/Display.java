import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Display{

    /// Instance Variables ///

    /** Game object to handle game logic
     */
    private Game game;

    /** Save object to handle saves
     */
    private Save saveState;

    /** Indicates which player went last, expressed as an integer
     *  If 0, Playerx went last
     *  If 1, PlayerO went last
     */
    private int lastPlayer = 0;

    private JFrame frame;
    private JButton[]Buttons;

    /// Constructor Methods ///

    /** Default constructor
     *  Sets a new Game object and Save object
     */
    public Display(){
        game = new Game();
        saveState = new Save();
    }


    /// Public Methods ///


    /** Resets the Game object
     */
    public void reset(){
        game = new Game();
    }

    /** Takes an integer argument and sets the Computer's level of difficulty
    * @param i the level chosen
    */
    public void setLevel(int i){
        game.setLevel(i);
    }

    /** getPlayer
    * @return the player that has its turn right now
    */
    public int getLastPlayer(){
        return lastPlayer;
    }

    /** Draws the window for the game board
    */
    public void draw(){

        //Main Frame
        frame = new JFrame();

        //Panels
        JPanel PanelButtons = new JPanel();
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();

        Color yellow = new Color(255,210,0);
        Color yellow2 = new Color(255,229,32);

        Panel1.setOpaque(true);
        Panel1.setBackground(yellow);
        Panel2.setOpaque(true);
        Panel2.setBackground(yellow);
        Panel3.setOpaque(true);
        Panel3.setBackground(yellow);

        BoxLayout layout = new BoxLayout(PanelButtons,BoxLayout.Y_AXIS);
        PanelButtons.setLayout(layout);

        //Buttons
        Buttons = new JButton[9];

        for(int i= 0; i<9; i++){
            Buttons[i] = new JButton("");
            Buttons[i].setOpaque(true);
            Buttons[i].setPreferredSize(new Dimension(100,100));
            Buttons[i].addActionListener(new action());
            Buttons[i].setBackground(yellow2);
            Buttons[i].setBorderPainted(false);
            Buttons[i].setFont(new Font("Comic Sans", Font.BOLD, 32));

            JButton temp = Buttons[i];

            temp.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseEntered(java.awt.event.MouseEvent Entered) {
                temp.setBackground(yellow2.brighter());
            }

            public void mouseExited(java.awt.event.MouseEvent MOUSE_EXITED) {
                temp.setBackground(yellow2);
            }
            });
        }

        //Padding
        Panel1.add(Box.createRigidArea(new Dimension(10,0)));
        Panel2.add(Box.createRigidArea(new Dimension(10,0)));
        Panel3.add(Box.createRigidArea(new Dimension(10,0)));

        for(int i=0; i<3; i++){
            Panel1.add(Buttons[i]);
            Panel1.add(Box.createRigidArea(new Dimension(10,0)));
            Panel2.add(Buttons[3+i]);
            Panel2.add(Box.createRigidArea(new Dimension(10,0)));
            Panel3.add(Buttons[6+i]);
            Panel3.add(Box.createRigidArea(new Dimension(10,0)));
        }


        PanelButtons.add(Box.createRigidArea(new Dimension(0,10)));
        PanelButtons.add(Panel1);
        PanelButtons.add(Box.createRigidArea(new Dimension(0,5)));
        PanelButtons.add(Panel2);
        PanelButtons.add(Box.createRigidArea(new Dimension(0,5)));
        PanelButtons.add(Panel3);
        PanelButtons.add(Box.createRigidArea(new Dimension(0,10)));
        PanelButtons.setBackground(yellow);

        //Setup
        frame.setSize(400,400);
        frame.setLayout(new BorderLayout());
        frame.setTitle("Tic Tac Toe");

        //Centered
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);

        frame.add("Center",PanelButtons);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end draw()

    /// Private Methods ///

    /** Action listener class to deal with buttons in-game
     */
    private class action implements ActionListener{
        public void actionPerformed(ActionEvent a){

            //If the action is performed for one of the 9 buttons
            for(int i=0; i<9; i++){

            if(a.getSource() == Buttons[i]){

            //If the clicked button is available
            if(game.getBoard().checkEmpty(i)){

                //Place mark on board
                if(lastPlayer == 0){
                    // If it is PlayerO's turn
                    Buttons[i].setText("O");
                    game.getBoard().setO(i);
                    lastPlayer = 1;

                } else {
                    // If it is PlayerX's turn
                    Buttons[i].setText("X");
                    game.getBoard().setX(i);
                    lastPlayer = 0;
                }

                //Disable the button after it is clicked
                Buttons[i].setEnabled(false);
                Buttons[i].setBackground(Color.black);

                //Check for win
                if(!checkWin()){

                    int move = game.getMove();

                    // If the game is set to PVE then get the Computer's move and set it
                    if(move != -1) {
                        Buttons[move].setText("X");
                        Buttons[move].setEnabled(false);
                        lastPlayer = 0;

                        // Check for win
                        checkWin();
                    }
                }

        }}}}}

    /// Private Methods ///

    /** Restarts the menu
    */
    private void menu(){
        Menu menu = new Menu();
        menu.draw();
    }

    /** Takes a label and formats the font and alignment
     *  @param label the label to be formatted
     */
    private JLabel setLabel(JLabel label){
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Comic Sans", Font.BOLD, 16));
        return label;
    }

    /** Disables all of the buttons in the JButton array
     */
    private void disableButtons() {
        for (int j = 0; j < 9; j++) {

            // Disables the Jbuttons
            Buttons[j].setEnabled(false);
        }
    }

    /** Creates and displays the ending sequence on a timed delay, then displays
     *  the main menu.
     *  @param endText Text to be displayed
     */
    private void createTimedEnding(String endText) {
        ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // Show message
                JOptionPane.showMessageDialog(frame,
                setLabel(new JLabel(endText)),
                "Game Over",
                JOptionPane.PLAIN_MESSAGE);

                // Draw the main menu
                menu();

                // Remove the game board scene
                frame.dispose();
            }};

            // Set timer with the above action
            Timer timer = new Timer(600, action);
            timer.setRepeats(false);
            timer.start();
    }


    /** Checks for game completion
     *  If the game has completed, and appropriate message is shown and the user is
     *  taken back to the main menu. Returns value of true.
     *  If the game has not completed no action is taken. Returns value of false.
     */
    private boolean checkWin(){

        // Get the status of the game
        int gameStatus = game.getBoard().getStatus();


        if(gameStatus == 1) {

            // If PlayerO has won
            disableButtons();
            createTimedEnding("Player O Wins!");
            saveState.save(game.getLevel() + 1);

            return true;
        } else if(gameStatus == 2) {

            // If PlayerX has won
            disableButtons();
            createTimedEnding("Player X Wins!");

            return true;
        } else if(gameStatus == 3) {

            // If there has been a tie
            disableButtons();
            createTimedEnding("It's a Tie!");

            return true;
        }
        // If the game has not met one of the three conditions, return false
        return false;
    }

}//end class

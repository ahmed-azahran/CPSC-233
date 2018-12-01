import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuPVE{
    
    ////Fields////
    private Display display;
    private JFrame menuFrame;
    private JButton[]menuButtons;

Color yellow = new Color(255,210,0);
Color yellow2 = new Color(255,229,32);
    
    ////Methods////
    
    /** reset
     */
    public void MenuPVE(){
        display = new Display();
    }


    /** draws the main menu
     */
    public void draw(){
        //Main Frame
        menuFrame = new JFrame();
        JPanel menuPanel = new JPanel();

        Color yellow = new Color(255,210,0);
        Color yellow2 = new Color(255,229,32);
        
        //Label
        JButton label= new JButton("Player vs Computer");
        label.setPreferredSize(new Dimension(340,50));
        label.setEnabled(false);
        label.setBackground(yellow);
        label.setBorderPainted(false);
        label.setFont(new Font("Comic Sans", Font.BOLD, 20));

        //Buttons
        menuButtons = new JButton[5];
        menuButtons[0] = new JButton("Level 1");
        menuButtons[1] = new JButton("Level 2");
        menuButtons[2] = new JButton("Level 3");
        menuButtons[3] = new JButton("Level 4");
        menuButtons[4] = new JButton("Level 5");
        
        /////////////////////////////////////////////////////
        
        for(int i=0; i<5; i++){setup(menuButtons[i],i);}
        
        /////////////////////////////////////////////////////
        
        //Adding the buttons to the panel
        menuPanel.add(label);
        menuPanel.add(menuButtons[0]);
        menuPanel.add(menuButtons[1]);
        menuPanel.add(menuButtons[2]);
        menuPanel.add(menuButtons[3]);
        menuPanel.add(menuButtons[4]);
        menuPanel.setBackground(yellow);
        
        //Setup
        menuFrame.setSize(340,340);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setTitle("PVE Menu");
        
        //Centered
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        menuFrame.setLocation(dim.width/2-menuFrame.getSize().width/2, dim.height/2-menuFrame.getSize().height/2);
        
        menuFrame.add("Center", menuPanel);
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /** action listener class to deal with the menu buttons
     */
    private class menuAction implements ActionListener{
        public void actionPerformed(ActionEvent a){
            
            if(a.getSource() == menuButtons[0]){
                display = new Display();

	//Show message
                menuFrame.dispose();
      	  JOptionPane.showMessageDialog(new JFrame(),
       	 setLabel(new JLabel("<html><body>Level 1 AI: <br><br>This AI will try to lose to you</body></html>")),
       	 "Game Start",
      	  JOptionPane.PLAIN_MESSAGE);

                display.draw();
                display.setLevel(0);

            }
            else if(a.getSource() == menuButtons[1]){
                display = new Display();

	//Show message
                menuFrame.dispose();
      	  JOptionPane.showMessageDialog(new JFrame(),
       	 setLabel(new JLabel("<html><body>Level 2 AI: <br><br>This AI will randomly place their mark</body></html>")),
       	 "Game Start",
      	  JOptionPane.PLAIN_MESSAGE);

                display.draw();
                display.setLevel(1);

            }
	else if(a.getSource() == menuButtons[2]){
                display = new Display();

	//Show message
                menuFrame.dispose();
      	  JOptionPane.showMessageDialog(new JFrame(),
       	 setLabel(new JLabel("<html><body>Level 3 AI: <br><br>This AI will block you if you are going to win</body></html>")),
       	 "Game Start",
      	  JOptionPane.PLAIN_MESSAGE);

                display.draw();
                display.setLevel(2);

            }
	else if(a.getSource() == menuButtons[3]){
                display = new Display();

	//Show message
                menuFrame.dispose();
      	  JOptionPane.showMessageDialog(new JFrame(),
       	 setLabel(new JLabel("<html><body>Level 4 AI: <br><br>This AI will block you and attempt to win</body></html>")),
       	 "Game Start",
      	  JOptionPane.PLAIN_MESSAGE);

                display.draw();
                display.setLevel(3);

            }
	else if(a.getSource() == menuButtons[4]){
                display = new Display();

	//Show message
	menuFrame.dispose();
      	  JOptionPane.showMessageDialog(new JFrame(),
       	 setLabel(new JLabel("<html><body>Level 5 AI: <br><br>This AI will try its best to tie with you or win</body></html>")),
       	 "Game Start",
      	  JOptionPane.PLAIN_MESSAGE);

                display.draw();
                display.setLevel(4);
                
            }
            
        }}

/** setup buttons
*/
private void setup(JButton b, int i){
    
    
    /////////////////////////////////////////////
    //If level is not unlocked, disable it
    Save save = new Save();
    if(i > save.load()){
        b.setText("Locked");
        b.setEnabled(false);
    }
    
    /////////////////////////////////////////////
    
	b.setPreferredSize(new Dimension(340,40));
    b.setOpaque(true);
	b.setBackground(yellow2);
        	b.setBorderPainted(false);
        	b.setFont(new Font("Comic Sans", Font.BOLD, 18));

	JButton temp = b;
	temp.addActionListener(new menuAction());
              temp.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent Entered) {
            	temp.setBackground(yellow2.brighter());
           	}

    	public void mouseExited(java.awt.event.MouseEvent MOUSE_EXITED) {
      	temp.setBackground(yellow2);
    	}
	});
}

/** setup label text
*/
private JLabel setLabel(JLabel l){
l.setHorizontalAlignment(JLabel.CENTER);
l.setFont(new Font("Comic Sans", Font.BOLD, 16));
return l;
}
    
    
}//end class


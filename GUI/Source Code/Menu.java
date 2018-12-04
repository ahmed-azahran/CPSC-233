import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Menu{
    
    ////Fields////
    private Display display;
    private JFrame menuFrame;
    private JButton[]menuButtons;
    private UIManager UI = new UIManager();

Color yellow = new Color(255,210,0);
Color yellow2 = new Color(255,229,32);
    
    ////Methods////
    
    /** reset
     */
    public void Menu(){
        System.out.println("*");
        display = new Display();
    }
    
    /** draws the main menu
     */
    public void draw(){

	//UI
	UI = new UIManager();
	UI.put("OptionPane.background", yellow);
	UI.put("Panel.background", yellow2);
	UI.put("Button.background",yellow2);
	UI.put("OptionPane.messageFont", new Font("Comic Sans", Font.BOLD, 16)); 
	UI.put("OptionPane.minimumSize",new Dimension(400,400));

        //Main Frame
        menuFrame = new JFrame();
        JPanel menuPanel = new JPanel();
        

        //Label
        JButton label= new JButton("Tic Tac Toe");
        label.setPreferredSize(new Dimension(400,100));
        label.setEnabled(false);
        label.setBackground(yellow);
        label.setBorderPainted(false);
        label.setFont(new Font("Comic Sans", Font.BOLD, 20));
        
        //Buttons
        menuButtons = new JButton[2];
        menuButtons[0] = new JButton("PVP");
        menuButtons[0].setPreferredSize(new Dimension(400,100));
        menuButtons[0].addActionListener(new menuAction());
        menuButtons[1] = new JButton("PVE");
        menuButtons[1].setPreferredSize(new Dimension(400,100));
        menuButtons[1].addActionListener(new menuAction());

        menuButtons[0].setOpaque(true);
        menuButtons[0].setBackground(yellow2);
        menuButtons[0].setBorderPainted(false);
        menuButtons[0].setFont(new Font("Comic Sans", Font.BOLD, 32));
	JButton temp2 = menuButtons[0];
              temp2.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent Entered) {
            	temp2.setBackground(yellow2.brighter());
           	}

    	public void mouseExited(java.awt.event.MouseEvent MOUSE_EXITED) {
      	temp2.setBackground(yellow2);
    	}
	});

        menuButtons[1].setOpaque(true);
        menuButtons[1].setBackground(yellow2);
        menuButtons[1].setBorderPainted(false);
        menuButtons[1].setFont(new Font("Comic Sans", Font.BOLD, 32));
	JButton temp = menuButtons[1];
              temp.addMouseListener(new java.awt.event.MouseAdapter() {
            	public void mouseEntered(java.awt.event.MouseEvent Entered) {
            	temp.setBackground(yellow2.brighter());
           	}

    	public void mouseExited(java.awt.event.MouseEvent MOUSE_EXITED) {
      	temp.setBackground(yellow2);
    	}
	});
        
        //Adding the buttons to the panel
        menuPanel.add(label);
        menuPanel.add(menuButtons[0]);
        menuPanel.add(menuButtons[1]);
        menuPanel.setBackground(yellow);
        
        //Setup
        menuFrame.setSize(400,400);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.setTitle("Menu");
        
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
                
                //menuFrame.setVisible(false);
                display = new Display();

	//Show message
                menuFrame.dispose();
      	  JOptionPane.showMessageDialog(null,
       	 setLabel(new JLabel("Player versus Player")),
       	 "Game Start",
      	  JOptionPane.PLAIN_MESSAGE);

                display.draw();
                display.setLevel(-1);

            }
            else if(a.getSource() == menuButtons[1]){
                menuFrame.dispose();
                MenuPVE pve = new MenuPVE();
	pve.draw();

            }
            
        }}

/** setup label text
*/
private JLabel setLabel(JLabel l){
l.setHorizontalAlignment(JLabel.CENTER);
l.setFont(new Font("Comic Sans", Font.BOLD, 16));
return l;
}
    
    
}//end class


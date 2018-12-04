public class Application{
    
    ////Methods////
    
    /** creates the display and draws the pages
     * @param args
     */
    public static void main(String [] args){
        
        Application app = new Application();
        app.start();
        
    }
    
    /** start the application
     */
    public void start(){
        Menu menu = new Menu();
        menu.draw();
        
    }
    
    
    
}//end class


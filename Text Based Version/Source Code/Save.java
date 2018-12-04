import java.util.*;
import java.io.*;

/** this save class allows saving and loading of the current level of ai unlocked
*/
public class Save{

    ////Fields////

    private String inputfile = "save.txt";

    ////Public Methods////

    /** Save the current level of ai unlocked, but only if it is lesser than the saved value
    * @param i the current level
    */
    public void save(int i){
        int j = load();
        if(j>i){
            return;
        }
        toFile(i);
    }


    /** Load the current level of ai unlocked
    * @return the level of ai
    */
    public int load(){

        int level = 0;

        try{

            BufferedReader in = new BufferedReader(new FileReader(inputfile));

            String line = in.readLine();
            level = Integer.parseInt(line);
            return level;

        }
        catch(FileNotFoundException ex){
            blindSave(0);
        }
        catch(IOException ex){System.out.print("Error: cannot access savefile");}

        return level;
    }

     //Main for testing
    public static void main(String [] args){
        Save test = new Save();
        // System.out.println("loading: "+test.load());
        test.save(2);
        test.save(1);
        test.save(6);
        test.save(3);
    }


    ////Private Methods////

    //WriteToFile
    /** write the current level to outputfile
    * @param i the level
     */
    private void toFile(int i){
        try
        {
            PrintWriter writer = new PrintWriter(inputfile);
            writer.print(i);
            writer.close();
        } catch (IOException e){System.out.print("\n\nError: Cannot write to outputfile\n"); }

    }//end toFile()

    //Save when there is no existing file

    private void blindSave(int i){
        toFile(i);
    }


}//end class

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Visitor {
    //creating my logger element
   private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

   //creating my save function
    public  String save(String fName, int age, String dateOfVisit, String timeOfVisit, String comments, String nameOfAssistance) {
        try { // opening my try catch statement
            String full_Name = fName.replace(" ", "_");//Making spaces an underscore
            FileWriter fileWriter = new FileWriter("visitor_" + full_Name.toLowerCase() + ".txt");// creating and opening a file
            //writing on the file
            fileWriter.write(fName + " \n" + age + " \n" + dateOfVisit + " \n" + timeOfVisit + " \n" + comments + " \n" + nameOfAssistance);
            fileWriter.close();//Closing a file
            logger.info("file created"); // Throwing an information about the creation of a file

        } catch (IOException e) { // catching any error taking place in our try statements
            logger.error(e.getMessage());
            System.out.printf(e.getMessage());

        }
        return "File created";
    }


    public void load(String name) {
        try {

            File myObj = new File("visitor_" + name.toLowerCase().replace(" ", "_") + ".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String myf = myReader.nextLine();
                logger.info(myf);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            logger.error("An error occurred.");
            e.printStackTrace();
        }
    }
}

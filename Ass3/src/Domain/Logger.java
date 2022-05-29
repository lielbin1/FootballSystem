package Domain;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;



public class Logger {
    private System system;

    public void writeToLog(String message){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            FileWriter myWriter = new FileWriter("logger.txt",true);
            myWriter.write(message + " at " + dtf.format(now));
            myWriter.write("\n");
            myWriter.close();
            //java.lang.System.out.println("Successfully updated to the log file.");
        } catch (IOException e) {
            java.lang.System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void readFromLog(){
        try {
            java.lang.System.out.println("log file:");
            File myObj = new File("logger.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                java.lang.System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            java.lang.System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        java.lang.System.out.println("end of log file.");
    }
}

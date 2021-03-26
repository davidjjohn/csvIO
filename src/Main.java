// Example of reading a csv file
//
// Input on the best of days is very messy.  Care
// must be taken to handle the various scenarios
// that can arise.
//
// This is a simple example of a way to handle
// csv file input.
//
// David John
// March 2021


import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main {


    public static void main(String[] args) {

        Scanner myfile=null;

        // attempt to open "XXX.csv" as a Scanner object
        try {
            myfile = new Scanner(new FileReader("XXX.csv"));
        } catch(FileNotFoundException e){
            System.out.println("bad file name or bad path");
            System.exit(2);
        }

        // variables to receive input values
        int firstToken;
        double secondToken;
        String thirdToken;
        boolean fourthToken;

        // as long as there is a file to process
	    while(myfile.hasNextLine()){

	        // read csv line into String
	        String csvLine = myfile.nextLine();

	        // split the line into individual tokens
	        String [] tokens = csvLine.split(",");

	        // attempt to convert first token to an int
	        try {
                firstToken = Integer.parseInt(tokens[0].strip());
            } catch(NumberFormatException e){
                System.out.println("Error on integer input <" + tokens[0] + ">; setting value to -243");
                firstToken = -243;
            }

	        // attempt to convert second token to a double
	        try {
                secondToken = Double.parseDouble(tokens[1].strip());
            } catch(NumberFormatException e){
	            System.out.println("Error on double input <" + tokens[1] + ">; setting value to 18.77");
	            secondToken = 18.77;
            }

	        // convert third token as a "cleaned up" String
	        thirdToken = tokens[2].replaceAll("\"","").strip();

	        // convert fourth token to a boolean
	        fourthToken = Boolean.parseBoolean(tokens[3].strip());

	        // display
	        System.out.println("Input: " + firstToken +", "+secondToken+", "+
                    thirdToken+", "+fourthToken);

        }

	    // close file and done
	    myfile.close();
    }
}

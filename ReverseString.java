import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This program reverses the lines of the input file.
*
* @author  Melody Berhane
* @version 1.0
* @since   2023-04-14
*/

public final class ReverseString {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private ReverseString() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        // Declare lists.
        final ArrayList<String> inputList = new ArrayList<String>();

        try {
            // Choose a file to get input from.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // Choose (or create) a file to print output to.
            final FileWriter output = new FileWriter("output.txt");

            // Loop to read each line of input file.
            while (scanInput.hasNextLine()) {
                // Add the next line.
                inputList.add(scanInput.nextLine());
            }

            // Create an array with all elements in the input list.
            final String[] inputArr = new String[inputList.size()];
            for (int location = 0; location < inputArr.length; location++) {
                inputArr[location] = inputList.get(location);
            }

            // Loop to send each line to function.
            for (String strLine : inputArr) {
                // Call function.
                final String reversed = reverse(strLine);

                // Print to console and file.
                System.out.println(reversed);
                output.write(reversed + "\n");
            }

            // Close writer.
            output.close();

        } catch (IOException err) {
            // For when no input file is found.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function generates marks for each assignment.
    *
    * @param line from file
    * @return reversed line
    */
    public static String reverse(String line) {
        // Detect if the line is empty.
        if (line.isEmpty()) {
            return line;
        } else {
            // Re-call the function with all characters but the first.
            return reverse(line.substring(1)) + line.charAt(0);
        }
    }
}

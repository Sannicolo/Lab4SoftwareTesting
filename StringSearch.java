import java.util.Scanner;
import java.io.File;

public class StringSearch {

    private static Scanner scan = new Scanner(System.in);

    /**
     * Main method that reads user input and calls search method.
     */
    public static void main(String[] args) {
        System.out.println("Enter: search <pattern> <filename>");
        String input = scan.nextLine();
        String[] inputArray = input.split(" ");

        if (inputArray.length != 3) {
            System.out.println("Invalid input. Enter: search <pattern> <filename>");
        } else if (inputArray[0].equalsIgnoreCase("search")) {
            search(inputArray[1], inputArray[2]);
        } else {
            System.out.println("Invalid command. Only \"search\" is supported");
        }
    }

    /**
     * Searches for a word in a file and prints line numbers where the word is
     * found.
     * 
     * @param word
     * @param file
     */
    public static void search(String word, String file) {
        boolean wordFoundInFile = false;
        Scanner inputFile;

        try {
            inputFile = new Scanner(new File(file));
        } catch (Exception e) {
            System.out.println("File not found");
            return;
        }

        int countLine = 1;

        while (inputFile.hasNextLine()) {
            String line = inputFile.nextLine();
            String[] words = line.split(" ");
            boolean found = false;
            for (String s : words) {
                if (s.equalsIgnoreCase(word)) {
                    // lines.add(Integer.toString(countLine));
                    found = true;
                }
            }
            if (found) {
                System.out.println("Word found on " + countLine + ": " + line);
                wordFoundInFile = true;
            }
            found = false;
            countLine++;
        }

        if (!wordFoundInFile) {
            System.out.println("Word not found in file");
        }
        inputFile.close();

    }

}
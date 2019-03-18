import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String authorName = null;
        int nbOfFiles = 10;
        int invalidFileIndex = 0;
        String fileName = "Latex";
        Scanner sc = null;
        Scanner userInput = new Scanner(System.in);
        PrintWriter pw = null;

        System.out.println("Welcome to BibCreator!\n\n");
        System.out.print("Please enter the author name you're targeting (Case Sensitive!): ");

        authorName = userInput.nextLine();

        try {

            for (int i = 0; i < 10; i++) {
                invalidFileIndex = i;
                sc = new Scanner(new FileInputStream(fileName + (i + 1) + ".bib"));


            }
            sc.close();

        } catch (FileNotFoundException fnfe) {

            System.out.println("Could not open input file " + fileName + (invalidFileIndex + 1) + ".bib for reading.\n\n");
            System.out.println("Please check if file exists! Program will terminate after closing any opened files.");
            System.exit(0);

        }



    }
}

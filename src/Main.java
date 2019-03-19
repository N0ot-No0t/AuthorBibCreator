import java.io.*;
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

        File f1 = new File((authorName+"-IEEE.json"));
        File f2 = new File((authorName+"-ACM.json"));
        File f3 = new File((authorName+"-NJ.json"));

        if(f1.exists() && f2.exists() && f3.exists()){



            try{
                throw new FileExistsException();

            }catch (FileExistsException fee){

                System.out.println("\nA file already exists with the name: "+(authorName+"-IEEE.json"));
                System.out.println("File will be renamed as: "+(authorName+"-IEEE-BU.json")+" and any old BUs will be deleted.\n");

                System.out.println("A file already exists with the name: "+(authorName+"-ACM.json"));
                System.out.println("File will be renamed as: "+(authorName+"-ACM-BU.json")+" and any old BUs will be deleted.\n");

                System.out.println("A file already exists with the name: "+(authorName+"-NJ.json"));
                System.out.println("File will be renamed as: "+(authorName+"-NJ-BU.json")+" and any old BUs will be deleted.\n");

                new File((authorName+"-IEEE-BU.json")).delete();
                new File((authorName+"-ACM-BU.json")).delete();
                new File((authorName+"-NJ-BU.json")).delete();
                f1.renameTo(new File((authorName+"-IEEE-BU.json")));
                f2.renameTo(new File((authorName+"-ACM-BU.json")));
                f3.renameTo(new File((authorName+"-NJ-BU.json")));


            }

        }

            try{

                pw = new PrintWriter(new FileOutputStream((authorName+"-IEEE.json")));
                pw = new PrintWriter(new FileOutputStream((authorName+"-ACM.json")));
                pw = new PrintWriter(new FileOutputStream((authorName+"-NJ.json")));

//                System.out.println("Files "+(authorName+"-IEEE.json")+", "+(authorName+"-ACM.json")+", and "+(authorName+"-NJ.json")+"" +
//                        " have been created!");
                //not yet

            }catch (FileNotFoundException fnfe){

            }


        pw.close();



    }

    public static void processBibFiles(){



    }
}

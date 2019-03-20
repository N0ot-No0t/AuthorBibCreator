import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String authorName;
        int nbOfFiles = 10;
        int invalidFileIndex = 0;
        String fileName = "Latex";
        Scanner scArray [] = new Scanner[nbOfFiles];
        PrintWriter pwArray [] = new PrintWriter[3];
        File fileArray [] = new File[3];
        Scanner userInput = new Scanner(System.in);

        System.out.println("Welcome to BibCreator!\n\n");
        System.out.print("Please enter the author name you're targeting: ");

        authorName = userInput.nextLine();


        try {

            for (int i = 0; i < nbOfFiles; i++) {
                invalidFileIndex = i;
                scArray[i] = new Scanner(new FileInputStream("resources/"+fileName + (i + 1) + ".bib"));

                //scArray[i].close();

            }

        } catch (FileNotFoundException fnfe) {

            System.out.println("Could not open input file " + fileName + (invalidFileIndex + 1) + ".bib for reading.\n\n");
            System.out.println("Please check if file exists! Program will terminate after closing any opened files.");
            System.exit(0);

        }

        fileArray[0] = new File((authorName+"-IEEE.json"));
        fileArray[1] = new File((authorName+"-ACM.json"));
        fileArray[2] = new File((authorName+"-NJ.json"));

        if(fileArray[0].exists() && fileArray[1].exists() && fileArray[2].exists()){



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
                fileArray[0].renameTo(new File((authorName+"-IEEE-BU.json")));
                fileArray[1].renameTo(new File((authorName+"-ACM-BU.json")));
                fileArray[2].renameTo(new File((authorName+"-NJ-BU.json")));


            }

        }

            try{

                pwArray[0] = new PrintWriter(new FileOutputStream((authorName+"-IEEE.json")));
                pwArray[1] = new PrintWriter(new FileOutputStream((authorName+"-ACM.json")));
                pwArray[2] = new PrintWriter(new FileOutputStream((authorName+"-NJ.json")));



            }catch (FileNotFoundException fnfe){

            }

            processBibFiles(scArray,pwArray,authorName,fileName);

        fileArray[0] = new File((authorName+"-IEEE.json"));
        fileArray[1] = new File((authorName+"-ACM.json"));
        fileArray[2] = new File((authorName+"-NJ.json"));

            if(fileArray[0].length() == 0 && fileArray[1].length() == 0 && fileArray[2].length() == 0){

                System.out.println("That person does not exist in the article database... Closing program");

                fileArray[0].delete();
                fileArray[1].delete();
                fileArray[2].delete();

                System.exit(1);

            }

                        System.out.println("Files "+(authorName+"-IEEE.json")+", "+(authorName+"-ACM.json")+", and "+(authorName+"-NJ.json")+"" +
                        " have been created!");




    }

    public static void processBibFiles(Scanner [] scanners, PrintWriter [] printWriters, String authorName,String fileName){

        int articleNo = 0;
        String str = "";
        boolean canRead = false;
        Article article = new Article();


            for(int i = 0; i < scanners.length; i++){

                    //scanners[i] = new Scanner(new FileInputStream(fileName + (i + 1) + ".bib"));
                    str = "";

                    str = scanners[i].nextLine();

                    while(scanners[i].hasNextLine()){


                        if(str.contains("@ARTICLE")) canRead = true;
                        if(str.equals("}")) canRead = false;

                        if(canRead){

                            if(str.split("=")[0].equals("author")){

                                if(!(str.toLowerCase()).contains(authorName.toLowerCase())) canRead = false;

                                article.setAuthors(str);


                            }else if(str.split("=")[0].equals("journal")){

                                article.setJournal(str);

                            }else if(str.split("=")[0].equals("title")){

                                article.setTitle(str);

                            }else if(str.split("=")[0].equals("year")){

                                article.setYear(str);

                            }else if(str.split("=")[0].equals("volume")){

                                article.setVolume(str);

                            }else if(str.split("=")[0].equals("number")){

                                article.setNumber(str);

                            }else if(str.split("=")[0].equals("pages")){

                                article.setPages(str);

                            }else if(str.split("=")[0].equals("keywords")){

                                article.setKeywords(str);

                            }else if(str.split("=")[0].equals("doi")){

                                article.setDoi(str);

                            }else if(str.split("=")[0].equals("ISSN")){

                                article.setISSN(str);

                            }else if(str.split("=")[0].equals("month")){

                                article.setMonth(str);

                            }

                        }
                        str = scanners[i].nextLine();

                        if((article.getAuthors().toLowerCase()).contains(authorName.toLowerCase()) && !article.getAuthors().equals("") && !article.getJournal().equals("") && !article.getTitle().equals("") && !article.getYear().equals("") && !article.getVolume().equals("") && !article.getNumber().equals("") && !article.getPages().equals("") && !article.getKeywords().equals("") && !article.getDoi().equals("") && !article.getISSN().equals("") && !article.getMonth().equals("")){

                            articleNo++;

                            printWriters[0].println(article.toIEEE()+"\n");
                            printWriters[1].println("["+(articleNo)+"] "+article.toACM()+"\n");
                            printWriters[2].println(article.toNJ()+"\n");

                            article.resetAll();

                        }


                        //System.out.println(article.toIEEE());
                    }










            }
        //System.out.println(article.getAuthors());

        for (int i = 0; i < scanners.length; i++){

            scanners[i].close();

        }

        for (int i = 0; i < 3; i++){

            printWriters[i].close();

        }
    }
}

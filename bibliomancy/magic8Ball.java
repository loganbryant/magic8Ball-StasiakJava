

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class Magic8Ball {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String question;

        System.out.println("See the future!");
        System.out.print("What do you wish to see? ");
        question = scan.nextLine(); 

        scan.close();

        File kjv = new File("/home/logan/Documents/javaClassProjects/bibliomancy/kjv.txt");
        File koran = new File("/home/logan/Documents/javaClassProjects/bibliomancy/koran.txt");
        File iliad = new File("/home/logan/Documents/javaClassProjects/bibliomancy/iliad.txt");

        File[] files = {kjv, koran, iliad};

        Random random = new Random();
        File selectedFile = files[random.nextInt(files.length)];

        try {
            Scanner fileScanner = new Scanner(selectedFile);

            java.util.ArrayList<String> lines = new java.util.ArrayList<>();
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }

            String chosenLine = lines.get(random.nextInt(lines.size()));

            System.out.println("Here's your answer:");
            System.out.println(chosenLine);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}


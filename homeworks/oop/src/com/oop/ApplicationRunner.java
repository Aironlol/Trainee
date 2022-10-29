package com.oop;

import java.io.File;
import java.util.*;

public class ApplicationRunner {

    public static void main(String[] args) {

        try {
            PrincessesCollections princessesCollections = new PrincessesCollections(new HashMap<>());
            File myFile = new File(String.join(File.separator, "resources", "disney-princesses.txt"));

            if (myFile.exists()) {
                System.out.println("File found.");
                princessesCollections.addFile(myFile);
                System.out.println("The application is ready to work.");
                System.out.println("Start typing commands:");

                Scanner scanner = new Scanner(System.in);
                ReadConsole consoleStroke;

                do {
                    consoleStroke = new ReadConsole(scanner.nextLine());
                    RunCommand runCommand = new RunCommand(
                            consoleStroke.getCommand(),
                            consoleStroke.getValidField(),
                            princessesCollections);
                    runCommand.run();
                } while (!consoleStroke.getCommand().contains("exit"));

            } else {
                System.out.println("File not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

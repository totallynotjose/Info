package biomon.services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HighscoreSaveService {

    /**
     * The filename of the Highscore save file.
     */
    final static String secondFileName = "highscore.dat";

    /**
     * Creates a Highscore save file if it does not already exist.
     * Prints a success message if the file is successfully created.
     */
    public static void createHighscoreSaveFile() {
        File highscoreFile = new File(secondFileName);
        try {
            if(highscoreFile.createNewFile()) {
                //System.out.println("Save File was successfully created");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Checks if the Highscore save file exists.
     *
     * @return true if the Highscore save file exists, false otherwise.
     */
    public static boolean isHighscoreSaveFileExisting() {
      return Files.exists(Paths.get(secondFileName));
    }

    /**
     * Saves the given Highscore object to a file.
     * If the Highscore save file does not exist, it creates the file first.
     *
     * @param int the Highscore object to be saved.
     */
    public static void saveHighscoreToFile(int highscore) {
        if (!isHighscoreSaveFileExisting()) {
            createHighscoreSaveFile();
        }
        try (ObjectOutputStream writeHighscore = new ObjectOutputStream(new FileOutputStream(secondFileName))) {
        	writeHighscore.writeObject(highscore);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Reads a Highscore object from the save file.
     *
     * @return the Highscore object read from the file, or null if an error occurs.
     */
    public static int readHighscoreFromFile() {
        int savedHighscore = 0;

        try (ObjectInputStream highscoreSaveFile = new ObjectInputStream(new FileInputStream(secondFileName))) {
            savedHighscore = (int) highscoreSaveFile.readObject();
            return savedHighscore;
        } catch (ClassNotFoundException | IOException exception) {
            exception.printStackTrace();
        }
        return savedHighscore;
    }
}


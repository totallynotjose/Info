package services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This class includes the methods used for saving the high score.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class HighscoreSaveService {

    /**
     * The filename of the High Score save file.
     */
    final static String secondFileName = "highscore.dat";

    /**
     * Creates a High Score save file if it does not already exist.
     * Prints a success message if the file is successfully created.
     */
    public static void createHighscoreSaveFile() {
        File highscoreFile = new File(secondFileName);
        try {
            if(highscoreFile.createNewFile()) {
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Checks if the High Score save file exists.
     *
     * @return true if the High Score save file exists, false otherwise.
     */
    public static boolean isHighscoreSaveFileExisting() {
      return Files.exists(Paths.get(secondFileName));
    }

    /**
     * Saves the given High Score object to a file.
     * If the High Score save file does not exist, it creates the file first.
     *
     * @param int the High Score object to be saved.
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
     * Reads a High Score object from the save file.
     *
     * @return the High Score object read from the file, or null if an error occurs.
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


package services;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import model.Biomon;

/**
 * This class includes the methods used for saving.
 * 
 * @author Lennart Alexander Brockmann
 * @author Josephine Franke
 * @author Kay Kiontke
 * 
 */

public class SaveService {

    /**
     * The filename of the Biomon save file.
     */
    final static String fileName = "biomon.dat";

    /**
     * Creates a Biomon save file if it does not already exist.
     * Prints a success message if the file is successfully created.
     */
    private static void createBiomonSaveFile() {
        File file = new File(fileName);
        try {
            if(file.createNewFile()) {
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Checks if the Biomon save file exists.
     *
     * @return true if the Biomon save file exists, false otherwise.
     */
    public static boolean isBiomonSaveFileExisting() {
      return Files.exists(Paths.get(fileName));
    }

    /**
     * Saves the given Biomon object to a file.
     * If the Biomon save file does not exist, it creates the file first.
     *
     * @param biomon the Biomon object to be saved.
     */
    public static void saveBiomonToFile(Biomon biomon) {
        if (!isBiomonSaveFileExisting()) {
            createBiomonSaveFile();
        }
        try (ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(fileName))) {
            write.writeObject(biomon);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Reads a Biomon object from the save file.
     *
     * @return the Biomon object read from the file, or null if an error occurs.
     */
    public static Biomon readBiomonFromFile() {
        Biomon savedBiomon = null;

        try (ObjectInputStream saveFile = new ObjectInputStream(new FileInputStream(fileName))) {
            savedBiomon = (Biomon) saveFile.readObject();
            return savedBiomon;
        } catch (ClassNotFoundException | IOException exception) {
            exception.printStackTrace();
        }
        return savedBiomon;
    }
}

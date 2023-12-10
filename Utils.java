import java.io.*;

public class Utils {

    /**
     * Read the content of a file via filepath.
     * @param path The filepath.
     * @return Result as a string.
     */
    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**
     * Write the content to a file.
     * @param content The content to be written.
     * @param path The filepath.
     */
    public static void writeContentToFile(String content, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Append new content to the bottom of a file.
     * @param content The content to be written.
     * @param path The filepath.
     */
    public static void appendContentToFile(String content, String path) {
        try {
            String newContent = readContentFromFile(path) + "\n" + content;
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            bw.write(newContent);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find a file by its name from a folder.
     * @param folderPath The folderpath.
     * @param fileName The name of file to find.
     * @return Return the file if it is found, null if not.
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            return null;
        }
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }
}
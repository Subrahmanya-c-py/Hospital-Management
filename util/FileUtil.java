package util;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public final class FileUtil {

    private FileUtil() {
        // Prevent instantiation
    }

    public static <T> void writeToFile(String fileName, Collection<T> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (T item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }

    public static <T> List<T> readFromFile(String fileName, Function<String, T> mapper) {
        List<T> result = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) return result;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                result.add(mapper.apply(line));
            }

        } catch (IOException e) {
            System.out.println("Error reading from file: " + fileName);
        }

        return result;
    }
}
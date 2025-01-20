import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static <T> void writeToFile(String path, ArrayList<T> arrayList, boolean append){
        if (arrayList.isEmpty()){
            return;
        }
        try {
            File file = new File(path);
            if (!file.exists()) {
                System.err.println("Ошибка: файл не существует или недоступен для записи: " + path);
                return;
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, append))) {
                for (T item : arrayList) {
                    writer.write(item.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    public static ArrayList<String> readFiles(String filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.err.println("Ошибка: файл не существует: " + filePath);
                return lines;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        return lines;
    }
}

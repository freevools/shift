import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static <T> void writeToFile(String path, ArrayList<T> arrayList, boolean append){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, append))) {
            for (T item : arrayList) {
                writer.write(item.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> readFiles(String filePath){
        ArrayList<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine())!= null){
                lines.add(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

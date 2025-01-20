import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArgumentParser argParser = new ArgumentParser(args);
        ArrayList<String> allLines = new ArrayList<>();

        for (String file: argParser.getInputFiles()){
            try {
                allLines.addAll(FileManager.readFiles(file));
            }catch (Exception e){
                System.err.println("Ошибка при чтении файла " + file + ": " + e.getMessage());
            }
        }

        LineParser lineParser = new LineParser();
        for(String line: allLines){
            lineParser.splitLine(line);
        }

        ArrayList<Double> doubles = lineParser.getDoubles();
        ArrayList<Integer> integers = lineParser.getIntegers();
        ArrayList<String> strings = lineParser.getStrings();

        try {
            FileManager.writeToFile(argParser.getPath() + argParser.getPrefix() + "floats.txt",doubles, argParser.isAppendToFile());
            FileManager.writeToFile(argParser.getPath() + argParser.getPrefix() + "integers.txt",integers, argParser.isAppendToFile());
            FileManager.writeToFile(argParser.getPath() + argParser.getPrefix() + "strings.txt",strings, argParser.isAppendToFile());
        }catch (Exception e){
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }

        if (argParser.isNeedShortStats()){
            StatsCalculator.shortStats("double", doubles);
            StatsCalculator.shortStats("integer",integers);
            StatsCalculator.shortStats("string", strings);
        }
        if (argParser.isNeedFullStats()){
            StatsCalculator.fullStatsForNumbers(doubles);
            StatsCalculator.fullStatsForNumbers(integers);
            StatsCalculator.fullStatsForString(strings);
        }
    }
}
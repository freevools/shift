import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//-o задаёт путь для результатов
//-p задает префикс имен выходных файлов.
//-a задать режим добавления в существующие файлы, а не перезаписывать
//-s краткая статистика
//-f полная статистика
public class Main {

    public static void main(String[] args) {

        ArgumentParser argParser = new ArgumentParser(args);

        ArrayList<String> inputFiles = argParser.getInputFiles();
        ArrayList<Double> doubles = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        if (argParser.isNeedShortStats()){
            StatsCalculator.shortStats(integers);
            StatsCalculator.shortStats(doubles);
            StatsCalculator.shortStats(strings);
        }
        if (argParser.isNeedFullStats()){
            StatsCalculator.fullStatsForNumbers(doubles);
            StatsCalculator.fullStatsForNumbers(integers);
            StatsCalculator.fullStatsForString(strings);
        }


    }
}
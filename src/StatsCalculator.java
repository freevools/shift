import java.util.ArrayList;

public class StatsCalculator {
    public static <T> void shortStats(String listName, ArrayList<T> arrayList){
        if (arrayList.isEmpty()){
            return;
        }
        System.out.printf("Количество элементов %s: %d \n", listName, arrayList.size());
    }
    public static <T extends Number> void fullStatsForNumbers(ArrayList<T> arrayList){
        if (arrayList.isEmpty()){
            return;
        }
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        double avg;

        for (T d : arrayList){
            double value = d.doubleValue();
            min = Math.min(min, value);
            max = Math.max(max, value);
            sum += value;
        }
        avg = sum / arrayList.size();
        if (arrayList.getFirst() instanceof Integer){
            System.out.printf("Полная статистика для Integer:\n" +
                    "Количество = %d, " +
                    "MIN = %d, " +
                    "MAX = %d, " +
                    "Сумма = %d, " +
                    "Среднее = %f \n", arrayList.size(), (int)min, (int)max, (int)sum, avg);
        }else {
            System.out.printf("Полная статистика для Double:\n" +
                    "Количество = %d, " +
                    "MIN = %.20f, " +
                    "MAX = %f, " +
                    "Сумма = %f, " +
                    "Среднее = %f \n", arrayList.size(),min, max, sum, avg);
        }
    }
    public static void fullStatsForString (ArrayList<String> arrayList){
        if (arrayList.isEmpty()){
            return;
        }
        int maxStringLength = arrayList.getFirst().length();
        int minStringLength = arrayList.getFirst().length();
        for (String s : arrayList){
            if (s.length() > maxStringLength){
                maxStringLength = s.length();
            }
            if (s.length() < minStringLength){
                minStringLength = s.length();
            }
        }
        System.out.printf("Полная статистика для String:\n" +
                "Количество = %d, " +
                "MAX длина = %d, " +
                "MIN длина = %d \n", arrayList.size(), maxStringLength, minStringLength);
    }
}

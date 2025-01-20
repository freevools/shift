import java.util.ArrayList;

public class StatsCalculator {
    public static <T> void shortStats(ArrayList<T> arrayList){
        System.out.printf("Количество элементов: %d",arrayList.size());
    }
    public static <T extends Number> void fullStatsForNumbers(ArrayList<T> arrayList){
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
        if (arrayList.get(0) instanceof Integer){
            System.out.printf("Integer full stats \n" +
                    "Count = %d, " +
                    "Min = %d, " +
                    "Max = %d, " +
                    "Sum = %d, " +
                    "Average = %f%n", arrayList.size(), (int)min, (int)max, sum, avg);
        }else {
            System.out.printf("Double full stats \n" +
                    "Count = %d, " +
                    "Min = %f, " +
                    "Max = %f, " +
                    "Sum = %f, " +
                    "Average = %f%n", arrayList.size(),min, max, sum, avg);
        }

    }
    public static void fullStatsForString (ArrayList<String> arrayList){
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
        System.out.printf("String full stats \n" +
                "Total strings = %d, Max = %d, Min = %d", arrayList.size(), maxStringLength, minStringLength);
    }
}

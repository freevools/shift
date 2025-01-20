import java.util.ArrayList;

public class LineParser {
    private ArrayList<Double> doubles = new ArrayList<>();
    private ArrayList<Integer> integers = new ArrayList<>();
    private ArrayList<String> strings = new ArrayList<>();

    public void splitLine(String line) {
        try {
            integers.add(Integer.parseInt(line));
        } catch (NumberFormatException e1) {
            try {
                doubles.add(Double.parseDouble(line));
            } catch (NumberFormatException e2) {
                strings.add(line);
            }
        }
    }
    public ArrayList<Double> getDoubles() {
        return doubles;
    }
    public ArrayList<Integer> getIntegers() {
        return integers;
    }
    public ArrayList<String> getStrings() {
        return strings;
    }
}

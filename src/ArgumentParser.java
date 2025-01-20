import java.util.ArrayList;

public class ArgumentParser {
    private String path = "";
    private String prefix = "";
    private boolean appendToFile = false;
    private boolean needShortStats = false;
    private boolean needFullStats = false;
    private ArrayList<String> inputFiles = new ArrayList<>();

    public ArgumentParser(String[] args){
        try {
            parseArguments(args);
        }catch (IllegalArgumentException e){
            System.err.println("Ошибка в аргументах командной строки: " + e.getMessage());
        }
    }

    private void parseArguments(String[] args){
        if (args.length == 0){
            throw new IllegalArgumentException("Не указаны входные данные");
        }
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (s.startsWith("-")) {
                switch (s){
                    case "-o":
                        path = args[i + 1] + "/";
                        i++;
                        break;
                    case "-p":
                        prefix = args[i + 1];
                        i++;
                        break;
                    case "-a":
                        appendToFile = true;
                        break;
                    case "-s":
                        needShortStats = true;
                        break;
                    case "-f":
                        needFullStats = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown argument: " + s);
                }
            }
            if (s.endsWith(".txt")){
                inputFiles.add(s);
            }
        }

    }
    public String getPath(){
        return path;
    }
    public String getPrefix(){
        return prefix;
    }
    public boolean isAppendToFile(){
        return appendToFile;
    }
    public boolean isNeedShortStats(){
        return needShortStats;
    }
    public boolean isNeedFullStats(){
        return needFullStats;
    }
    public ArrayList<String> getInputFiles(){
        return inputFiles;
    }
}

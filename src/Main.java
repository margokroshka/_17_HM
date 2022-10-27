import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        main2();
    }

    public static void main1() {
        Pattern pattern = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        Matcher matcher = pattern.matcher(n);
        while (matcher.find()) {
            System.out.println(matcher.group() + " IP-адрес верный");
        }
    }

    public static void main2() {
        System.out.println("Введите кол-во файлов для прочтения  ");
        Scanner scanner1 = new Scanner(System.in);
        int n = scanner1.nextInt();
        String s = "";
        try {
            for (int i = 0; i < n; i++) {
                readSmallFile();
            }

        } catch (IOException e) {
        }
        System.out.println(s);


    }

    public static void readSmallFile() throws IOException {
        System.out.println();
        System.out.println("Введите имя файла  ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        File file = new File(s);
        Path path = Paths.get(s);
        if (!file.exists()) {
            System.out.println("такого файла нет");
        }
        if (!file.canRead()) {
            System.out.println(" файл нельзя прочесть");
        }
        List<String> strings = Files.readAllLines(path);
        Pattern pattern = Pattern.compile("\\+\\(\\d{2}\\)\\d{7}");
        Matcher matcher = pattern.matcher(s);
        Pattern pattern2 = Pattern.compile("\\d{4}-\\w{3}-\\d{4}-\\w{3}-(\\d{1}\\w{1}\\d{1}\\w{1})");
        Matcher matcher2 = pattern2.matcher(s);
        try {
            Util.process(matcher, matcher2);
        } catch (ExceptionaAbsence e) {
            System.out.println(e.getMessage());
        }
        for (String l : strings) {
            System.out.println(l);
            while (matcher.find()) {
                Doc doc = new Doc(matcher.group());
                Map<String, Doc> documentMap = new HashMap<>();
                documentMap.put(s, doc);
                System.out.println(matcher.group());
            }
            while (matcher2.find()) {
                Doc doc2 = new Doc(matcher2.group());
                Map<String, String> documentMap = new HashMap<>();
                documentMap.put(s, matcher2.group());
                System.out.println(matcher2.group());
            }

        }

    }
}
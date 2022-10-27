import java.util.regex.Matcher;

public class Util {
    public static void process(Matcher matcher, Matcher matcher2) throws ExceptionaAbsence{

        if (matcher.find()) {
            String message = "нет совпадений";
            throw new ExceptionaAbsence(message);
        }
        if (matcher2.find()) {
            String message = "нет совпадений";
            throw new ExceptionaAbsence(message);
        }


    }
}

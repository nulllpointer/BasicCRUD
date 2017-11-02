import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class PatternMatcher {

    Pattern pattern = Pattern.compile("^(\\d+(\\.\\d+)?)");
    public static void main(String[] args) {

      /*  String line = "343,23";
        Pattern pattern = Pattern.compile("^(\\d+),(\\d+)");
        Matcher matcher = pattern.matcher(line);

        System.out.println(matcher.matches());
        System.out.println(matcher.groupCount());
       // System.out.println(matcher.find());

        for (int i = 0; i <matcher.groupCount() ; i++) {
            System.out.println(matcher.group(i));

        }
*/



        String line = "[3000.0009,100.5560]";
        Pattern pattern = Pattern.compile("\\[(\\d+|\\d+.\\d+),(\\d+|\\d+.\\d+)\\]$");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println("group 1: " + matcher.group(1));
            System.out.println("group 2: " + matcher.group(2));


        }
        }


    }



package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hitesh on 4/26/17.
 */
public class PatternMatcherExtended {

    public static void main(String[] args) {

        String line = "created-lt-eq=2016-09-13T05:52:42.135-04:00";
        Pattern pattern = Pattern.compile("created-(lt-eq|gt-eq)=(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}-\\d{2}:\\d{2})$");
        Matcher matcher = pattern.matcher(line);

        System.out.println(matcher.groupCount());
        while (matcher.find()) {
            System.out.println("group 1: " + matcher.group(1));
            System.out.println("group 2: " + matcher.group(2));


        }


    }

}

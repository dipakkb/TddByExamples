import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dipakkb on 12/10/2017.
 */
public class MolarMass {
    private static final Map<String, Integer> atomicMass = new HashMap<String, Integer>();
    private static final String FORMULA_REGEX = "([A-Z][a-z]?)(\\d*)|\\((.*)\\)(\\d*)";

    static {
        atomicMass.put("H", 1);
        atomicMass.put("C", 12);
        atomicMass.put("O", 16);
        atomicMass.put("Fe", 56);
        atomicMass.put("Ca", 40);
        atomicMass.put("P", 31);
        atomicMass.put("Co", 59);
        atomicMass.put("N", 14);
    }

    public static int of(String c) {
        int mass = 0;
        Pattern pattern = Pattern.compile(FORMULA_REGEX);
        Matcher matcher = pattern.matcher(c);
        while (matcher.find()) {
            if(matcher.group(1) != null) {
                String atom = matcher.group(1);
                String u = matcher.group(2);
                System.out.println(atom);
                System.out.println(u);
                int units =  u.isEmpty() ? 1 : Integer.parseInt(u);
                mass = mass + units * atomicMass.get(atom);
            }

            if(matcher.group(3) != null) {
                String formula = matcher.group(3);
                String u = matcher.group(4);
                System.out.println(formula);
                System.out.println(u);
                int units =  u.isEmpty() ? 1 : Integer.parseInt(u);
                mass = mass + units * MolarMass.of(formula);
            }
        }
        System.out.println("mass " + mass);
        return mass;
    }
}

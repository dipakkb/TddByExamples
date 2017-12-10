import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaBuilder {
    static final String FORMULA_REGEX = "([A-Z][a-z]?)(\\d*)|\\((.*)\\)(\\d*)";
    private static Pattern pattern = Pattern.compile(FORMULA_REGEX);

    static ArrayList<IFormula> formulas(String formula) {
        ArrayList<IFormula> formulas = new ArrayList<IFormula>();
        Matcher matcher = pattern.matcher(formula);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                String atomGroups = matcher.group(1);
                String u = matcher.group(2);

                int units = u.isEmpty() ? 1 : Integer.parseInt(u);
                formulas.add(new SimpleFormula(units, atomGroups));
            }

            if (matcher.group(3) != null) {
                String atomGroups = matcher.group(3);
                String u = matcher.group(4);
                int units = u.isEmpty() ? 1 : Integer.parseInt(u);
                formulas.add(new CompoundFormula(units, formulas(atomGroups)));
            }
        }
        return formulas;
    }
}
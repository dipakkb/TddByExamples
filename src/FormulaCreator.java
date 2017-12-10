import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormulaCreator {
    static final String FORMULA_REGEX = "([A-Z][a-z]?)(\\d*)|\\((.*)\\)(\\d*)";
    private static Pattern pattern = Pattern.compile(FORMULA_REGEX);

    static ArrayList<IFormula> createFormulas(String formula) {
        ArrayList<IFormula> formulas = new ArrayList<IFormula>();
        Matcher matcher = pattern.matcher(formula);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                SimpleFormula e = createSimpleFormula(matcher);
                formulas.add(e);
            }

            if (matcher.group(3) != null) {
                CompoundFormula e = createCompoundFormula(matcher);
                formulas.add(e);
            }
        }
        return formulas;
    }

    private static CompoundFormula createCompoundFormula(Matcher matcher) {
        String atomGroups = matcher.group(3);
        String u = matcher.group(4);
        int units = getUnits(u);
        return new CompoundFormula(units, createFormulas(atomGroups));
    }

    private static int getUnits(String u) {
        return u.isEmpty() ? 1 : Integer.parseInt(u);
    }

    private static SimpleFormula createSimpleFormula(Matcher matcher) {
        String atomGroups = matcher.group(1);
        String u = matcher.group(2);

        int units = getUnits(u);
        return new SimpleFormula(units, atomGroups);
    }
}
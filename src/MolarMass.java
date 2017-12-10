import java.util.ArrayList;

/**
 * Created by dipakkb on 12/10/2017.
 */
public class MolarMass {

    public static int of(String c) {
        ArrayList<IFormula> formulas = FormulaBuilder.buildFormulas(c);
        return formulas.stream().mapToInt(formula -> formula.mass()).sum();
    }
}

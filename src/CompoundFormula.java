import java.util.ArrayList;

/**
 * Created by dipakkb on 12/10/2017.
 */
public class CompoundFormula implements IFormula {
    private final int units;
    private final ArrayList<IFormula> formulas;

    public CompoundFormula(int units, ArrayList<IFormula> formulas) {

        this.units = units;
        this.formulas = formulas;
    }

    @Override
    public int mass() {
        int m = formulas.stream().mapToInt(formula -> formula.mass()).sum();
        return units * m;
    }
}

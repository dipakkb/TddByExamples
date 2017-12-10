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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompoundFormula that = (CompoundFormula) o;

        if (units != that.units) return false;
        return formulas != null ? formulas.equals(that.formulas) : that.formulas == null;
    }

    @Override
    public int hashCode() {
        int result = units;
        result = 31 * result + (formulas != null ? formulas.hashCode() : 0);
        return result;
    }
}

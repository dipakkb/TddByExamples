/**
 * Created by dipakkb on 12/10/2017.
 */
public class SimpleFormula implements IFormula {
    private final int units;
    private final String atom;

    public SimpleFormula(int units, String atom) {
        this.units = units;
        this.atom = atom;
    }

    public int mass() {
        return units * AtomicMass.of(atom);
    }
}

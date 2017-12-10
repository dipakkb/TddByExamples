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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleFormula that = (SimpleFormula) o;

        if (units != that.units) return false;
        return atom != null ? atom.equals(that.atom) : that.atom == null;
    }

    @Override
    public String toString() {
        return "SimpleFormula{" +
                "units=" + units +
                ", atom='" + atom + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = units;
        result = 31 * result + (atom != null ? atom.hashCode() : 0);
        return result;
    }
}

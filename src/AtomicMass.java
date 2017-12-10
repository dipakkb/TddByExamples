import java.util.HashMap;
import java.util.Map;

public class AtomicMass {
    private static final Map<String, Integer> atomicMass = new HashMap<String, Integer>();
    static {
        AtomicMass.atomicMass.put("H", 1);
        AtomicMass.atomicMass.put("C", 12);
        AtomicMass.atomicMass.put("O", 16);
        AtomicMass.atomicMass.put("Fe", 56);
        AtomicMass.atomicMass.put("Ca", 40);
        AtomicMass.atomicMass.put("P", 31);
        AtomicMass.atomicMass.put("Co", 59);
        AtomicMass.atomicMass.put("N", 14);
    }

    public static int of(String atom) {
        return atomicMass.get(atom);
    }
}
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by dipakkb on 12/10/2017.
 */
public class MolarMassTest {
    @Test
    public void testMolarMassOfCarbonIs12(){
        assertEquals(12, MolarMass.of("C"));
    }

    @Test
    public void testMolarMassOfHydrogenIs1(){
        assertEquals(1, MolarMass.of("H"));
    }

    @Test
    public void testMolarMassOfIronIs26(){
        assertEquals(56, MolarMass.of("Fe"));
    }

    @Test
    public void testMolarMassOfH2OIs18() {
        assertEquals(18, MolarMass.of("H2O"));
    }
    @Test
    public void testMolarMassOfCalciumPhospateIs18() {
        assertEquals(310, MolarMass.of("Ca3(PO4)2"));
    }

    @Test
    public void testMolarMassOfCobaltFerricyanideIs601() {
        assertEquals(601, MolarMass.of("Co3(Fe(CN)6)2"));
    }
}

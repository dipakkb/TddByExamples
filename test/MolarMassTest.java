import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by dipakkb on 12/10/2017.
 */
public class MolarMassTest {
//    @Test
//    public void test_molar_mass_of_carbon_is_12(){
//        assertEquals(12, MolarMass.of("C"));
//    }
//
//    @Test
//    public void test_molar_mass_of_hydrogen_is_1(){
//        assertEquals(1, MolarMass.of("H"));
//    }
//
//    @Test
//    public void test_molar_mass_of_iron_is_26(){
//        assertEquals(26, MolarMass.of("Fe"));
//    }

//    @Test
//    public void test_molar_mass_of_H2O_is_18() {
//        assertEquals(18, MolarMass.of("H2O"));
//    }
//    @Test
//    public void test_molar_mass_of_calcium_phospate_is_18() {
//        assertEquals(310, MolarMass.of("Ca3(PO4)2"));
//    }

    @Test
    public void test_molar_mass_of_cobalt_ferricyanide_is_601() {
        assertEquals(601, MolarMass.of("Co3(Fe(CN)6)2"));
    }
}

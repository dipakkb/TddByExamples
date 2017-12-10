import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class FormulaBuilderTest {

    @Test
    public void shouldBuildSimpleFormulaForHydrogen() {
        ArrayList<IFormula> simpleFormula = FormulaBuilder.buildFormulas("H");
        assertEquals(new SimpleFormula(1, "H"), simpleFormula.get(0));
    }

    @Test
    public void shouldBuildSimpleFormulasForWater() {
        ArrayList<IFormula> simpleFormula = FormulaBuilder.buildFormulas("H2O");
        assertEquals(new SimpleFormula(2, "H"), simpleFormula.get(0));
        assertEquals(new SimpleFormula(1, "O"), simpleFormula.get(1));
    }

    @Test
    public void shouldBuildSimpleAndComplexFormulasForCalciumPhosphate() {
        ArrayList<IFormula> simpleFormulas = new ArrayList<>();
        simpleFormulas.add(new SimpleFormula(1, "P"));
        simpleFormulas.add(new SimpleFormula(4, "O"));

        ArrayList<IFormula> simpleFormula = FormulaBuilder.buildFormulas("Ca3(PO4)2");

        assertEquals(new SimpleFormula(3, "Ca"), simpleFormula.get(0));
        assertEquals(new CompoundFormula(2, simpleFormulas), simpleFormula.get(1));
    }

    @Test
    public void shouldBuildSimpleAndCompoundComplexFormulasForCobaltFerriCyanide() {
        ArrayList<IFormula> cyanide = new ArrayList<>();
        cyanide.add(new SimpleFormula(1, "C"));
        cyanide.add(new SimpleFormula(1, "N"));

        CompoundFormula compundCynaide = new CompoundFormula(6, cyanide);

        ArrayList<IFormula> ferriCynaide = new ArrayList<>();
        ferriCynaide.add(new SimpleFormula(1, "Fe"));
        ferriCynaide.add(compundCynaide);
        CompoundFormula compoundFerriCyanide = new CompoundFormula(2, ferriCynaide);

        ArrayList<IFormula> simpleFormula = FormulaBuilder.buildFormulas("Co3(Fe(CN)6)2");

        assertEquals(new SimpleFormula(3, "Co"), simpleFormula.get(0));
        assertEquals(compoundFerriCyanide, simpleFormula.get(1));
    }
}
package bo.sterenborg;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class JavaFuzzyLogic {
    public static void main(String[] args) {

// Load from 'FCL' file
        String fileName = "src/main/resources/fcl/donor.fcl";
        FIS fis = FIS.load(fileName, true);

        // Error while loading?
        if (fis == null) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        // Show
        JFuzzyChart.get().chart(fis);

        // Set inputs
        fis.setVariable("capital", 20000);
        fis.setVariable("influence", 3);
        fis.setVariable("spend_rate", 7);

        // Evaluate
        fis.evaluate();

        // Show output variable's chart
        Variable tip = fis.getVariable("donation");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);
    }
}


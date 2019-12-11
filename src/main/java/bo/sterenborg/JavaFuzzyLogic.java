package bo.sterenborg;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

/**
 * @author Bo Sterenborg
 */
public class JavaFuzzyLogic {
    public static void main(String[] args) {

        //Load the FIS
        String fileName = "src/main/resources/fcl/donor.fcl";
        FIS fis = FIS.load(fileName, true);

       //Check if exists
        if (fis == null) {
            System.err.println("Can't load file: '" + fileName + "'");
            return;
        }

        //Show the fis itself
        JFuzzyChart.get().chart(fis);

        //Set input variables
        fis.setVariable("capital", 20000);
        fis.setVariable("influence", 3);
        fis.setVariable("spend_rate", 7);

        //Start the evaluation
        fis.evaluate();

        //Show the output
        Variable tip = fis.getVariable("donation");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);
    }
}


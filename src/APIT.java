import java.util.ArrayList;
import java.util.Arrays;

public class APIT {
    private static final Double freeBracket = 1200000.0;
    private static final ArrayList<ArrayList<Double>> taxBrackets = new ArrayList<>();

    public APIT() {

        taxBrackets.add(new ArrayList<>(Arrays.asList(500000.0, 0.06)));
        taxBrackets.add(new ArrayList<>(Arrays.asList(500000.0, 0.12)));
        taxBrackets.add(new ArrayList<>(Arrays.asList(500000.0, 0.18)));
        taxBrackets.add(new ArrayList<>(Arrays.asList(500000.0, 0.24)));
        taxBrackets.add(new ArrayList<>(Arrays.asList(500000.0, 0.30)));
        taxBrackets.add(new ArrayList<>(Arrays.asList(null, 0.36)));
    }

    public double calculateYearlyTax(double annualIncome) {
        double tax = 0.0;

        if (annualIncome > freeBracket) {
            annualIncome -= freeBracket;

            for (ArrayList<Double> bracket : taxBrackets) {
                if (bracket.get(0) == null) {
                    tax += (annualIncome * bracket.get(1));
                    break;
                }
                else {
                    if (annualIncome > bracket.get(0)) {
                        tax += (bracket.get(0) * bracket.get(1));
                        annualIncome -= bracket.get(0);
                    }
                    else {
                        tax += (annualIncome * bracket.get(1));
                        break;
                    }
                }
            }
        }

        return tax;
    }
}

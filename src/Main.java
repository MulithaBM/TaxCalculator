import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        APIT apit = new APIT();

        System.out.println("Welcome to APIT (Advance Personal Income Tax) tax calculator");
        System.out.println("Enter income amount and type to view your monthly and annual tax amounts and detailed tax calculation");
        System.out.println("Income must be in rupees and must only containing numeric characters except a single period character to denote cents. (Ex. 200000.00)");
        System.out.println("Type (monthly income or annual income) must be denoted by '-m' for monthly income and '-a' for annual income");
        System.out.println("Input data must be in the format of <income><space><type>");
        System.out.print("Income: ");

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Pattern pattern = Pattern.compile("^(\\d+\\.?\\d{0,2})\\s+-([m|a])\\s*$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            System.out.println("Invalid input format");
            return;
        }

        double income = Double.parseDouble(matcher.group(1));
        String type = matcher.group(2).toLowerCase();

        double annualTax;

        if (type.equals("m")) {
            annualTax = apit.calculateYearlyTax(income * 12);

            System.out.printf("Annual tax: Rs. %.2f\n", annualTax);
            System.out.printf("Monthly tax: Rs. %.2f\n", annualTax / 12);
        }
        else if (type.equals("a")) {
            annualTax = apit.calculateYearlyTax(income);

            System.out.printf("Annual tax: Rs. %.2f\n", annualTax);
            System.out.printf("Monthly tax: Rs. %.2f\n", annualTax / 12);
        }
    }
}
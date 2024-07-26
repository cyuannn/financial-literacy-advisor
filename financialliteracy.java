import java.util.Scanner;

public class FinancialLiteracy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assess current financial situation
        System.out.println("Enter your current monthly income:");
        double income = scanner.nextDouble();

        System.out.println("Enter your current monthly expenses:");
        double expenses = scanner.nextDouble();

        System.out.println("Enter your current credit card debt:");
        double creditCardDebt = scanner.nextDouble();

        System.out.println("Enter your current savings:");
        double savings = scanner.nextDouble();

        // Short-term financial goals
        System.out.println("Enter your short-term savings goal (within 1 year):");
        double shortTermGoal = scanner.nextDouble();

        System.out.println("Enter your short-term debt reduction goal (within 1 year):");
        double shortTermDebtReduction = scanner.nextDouble();

        // Long-term financial goals
        System.out.println("Enter your long-term savings goal (1-5 years):");
        double longTermGoal = scanner.nextDouble();

        System.out.println("Enter your long-term debt reduction goal (1-5 years):");
        double longTermDebtReduction = scanner.nextDouble();

        // Monthly budget breakdown
        System.out.println("Enter your target monthly budget for housing:");
        double housingBudget = scanner.nextDouble();

        System.out.println("Enter your target monthly budget for transportation:");
        double transportationBudget = scanner.nextDouble();

        System.out.println("Enter your target monthly budget for groceries:");
        double groceriesBudget = scanner.nextDouble();

        System.out.println("Enter your target monthly budget for discretionary spending:");
        double discretionaryBudget = scanner.nextDouble();

        // Display current financial situation
        System.out.println("\nCurrent Financial Situation:");
        System.out.printf("Monthly Income: $%.2f\n", income);
        System.out.printf("Monthly Expenses: $%.2f\n", expenses);
        System.out.printf("Credit Card Debt: $%.2f\n", creditCardDebt);
        System.out.printf("Current Savings: $%.2f\n", savings);

        // Financial recommendations
        System.out.println("\nFinancial Recommendations:");

        // Calculate monthly savings potential
        double savingsPotential = income - expenses;
        System.out.printf("Potential Monthly Savings: $%.2f\n", savingsPotential);

        // Short-term goals
        if (savingsPotential >= shortTermGoal) {
            System.out.println("You are on track to reach your short-term savings goal!");
        } else {
            double shortTermGoalShortfall = shortTermGoal - savingsPotential;
            System.out.printf("You need to save an additional $%.2f per month to reach your short-term savings goal.\n", shortTermGoalShortfall);
        }

        if (creditCardDebt > 0) {
            System.out.printf("To meet your short-term debt reduction goal of $%.2f per month, allocate this amount from your savings potential.\n", shortTermDebtReduction);
            double newCreditCardDebt = creditCardDebt - shortTermDebtReduction;
            System.out.printf("New Credit Card Debt: $%.2f\n", newCreditCardDebt);
            if (newCreditCardDebt <= 0) {
                System.out.println("Great job! You've paid off your credit card debt.");
            }
        }

        // Long-term goals
        double longTermSavingsPotential = savings + (savingsPotential * 12); // Assume 1 year for simplicity
        if (longTermSavingsPotential >= longTermGoal) {
            System.out.println("You are on track to reach your long-term savings goal!");
        } else {
            double longTermGoalShortfall = longTermGoal - longTermSavingsPotential;
            System.out.printf("You need to save an additional $%.2f per year to reach your long-term savings goal.\n", longTermGoalShortfall);
        }

        double longTermDebtReductionPotential = creditCardDebt - (shortTermDebtReduction * 12); // Assume 1 year for simplicity
        if (longTermDebtReductionPotential <= longTermDebtReduction) {
            System.out.println("You are on track to reduce your debt as planned.");
        } else {
            double longTermDebtReductionShortfall = longTermDebtReductionPotential - longTermDebtReduction;
            System.out.printf("You need to increase your debt reduction efforts by $%.2f per year to meet your long-term debt reduction goal.\n", longTermDebtReductionShortfall);
        }

        // Budget recommendations
        double totalMonthlyBudget = housingBudget + transportationBudget + groceriesBudget + discretionaryBudget;
        if (totalMonthlyBudget > income) {
            System.out.println("Your budget exceeds your monthly income. Consider adjusting your budget.");
        } else {
            System.out.printf("Your total budgeted expenses are within your income: $%.2f\n", totalMonthlyBudget);
        }

        // Credit Card Recommendations
        System.out.println("\nCredit Card Recommendations:");
        recommendCreditCards(creditCardDebt, income);

        // Suggestions
        System.out.println("\nSuggestions:");
        System.out.println("1. Track your expenses to ensure you're staying within budget.");
        System.out.println("2. Use credit cards with rewards or cash back based on your spending patterns.");
        System.out.println("3. Consider high-yield savings accounts to grow your savings faster.");
        System.out.println("4. Review and adjust your budget periodically based on changes in income or expenses.");

        scanner.close();
    }

    private static void recommendCreditCards(double creditCardDebt, double income) {
        if (creditCardDebt > 0) {
            System.out.println("1. **Balance Transfer Cards**: Consider using a card with a 0% APR balance transfer offer to save on interest while paying down debt.");
            System.out.println("2. **Cash Back Cards**: If you spend a lot on groceries or gas, look for cards offering cash back in those categories.");
            System.out.println("3. **Rewards Cards**: For frequent travelers or diners, choose cards that offer rewards on travel or dining.");
        } else {
            System.out.println("1. **Cash Back Cards**: Maximize your spending benefits with cards offering cash back on everyday purchases.");
            System.out.println("2. **Travel Rewards Cards**: Earn points or miles on your purchases if you travel frequently.");
        }
    }
}

package myMortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgagePaymentCalculator {

		public static double calculateMonthlyPayment(
				int loanAmount, int termInYears, double interestRate){
			
			//e.g. 3.4 -> .0034
			interestRate /= 100.0;
			
			double monthlyRate = interestRate / 12.0;
			
			int termInMonths = termInYears * 12;
			
			double monthlyPayment =
						(loanAmount * monthlyRate) /
						(1-Math.pow(1+monthlyRate, -termInMonths));
			return monthlyPayment;
		}
		
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Enter Loan Amount : ");
			int loanAmount = scanner.nextInt();
			
			System.out.print("Enter Loan Term in Years : ");
			int termInYears = scanner.nextInt();
			
			System.out.println("Enter Interest Rate : ");
			double interestRate = scanner.nextDouble();
			
			//display loan details 
			double monthlyPayment = 
					calculateMonthlyPayment(loanAmount, termInYears, interestRate);
			
			//number format
			NumberFormat currencyformat = 
					NumberFormat.getCurrencyInstance();
			NumberFormat interestformat = 
					NumberFormat.getPercentInstance();
			
			//display loan details
			System.out.println("Loan Amount: " +
					currencyformat.format(loanAmount));
			//dollar sign format
			System.out.println("Laon Term: " +
					termInYears + " years");
			System.out.println("Monthly Payment: " +
					currencyformat.format(monthlyPayment));
			//dollar sign format
			
		}//end main
		
}//end class

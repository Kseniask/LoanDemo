
public class GradLoan extends Loan {

	public GradLoan(int loanNum, String studName, double amount, int term) {
		super( loanNum, studName,  amount,  term);
	}
	@Override
	public double calculateIntRate(double rate) {
		intRate = rate;
		intRate = intRate+0.02;

		return intRate;
	}

}

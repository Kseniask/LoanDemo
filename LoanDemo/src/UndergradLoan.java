
public class UndergradLoan extends Loan {

	public UndergradLoan(int loanNum, String studName, double amount, int term) {
		super( loanNum, studName,  amount,  term);
	}
	@Override
	public double calculateIntRate(double rate) {
		intRate = rate;
		super.intRate += 0.01;
		return super.intRate;
	}

}

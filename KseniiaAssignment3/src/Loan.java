import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public abstract class Loan implements LoanInterface{
	protected int loanNum;
	protected String studName;
	protected double amount;
	protected double intRate;
	protected int term;

	public Loan(int loanNum, String studName, double amount, int term) {
		if(amount > MAX) {
			while(amount > MAX) {
			amount = Double.parseDouble(JOptionPane.showInputDialog("Amount cannot be bigger than $100,000. \n Enter the less number:"));
			this.amount = amount;
			}
		}
		else {
			this.amount = amount;
		}
		
		this.loanNum = loanNum;
		this.studName = studName;
		if(term != SHORT && term !=LONG) {
			JOptionPane.showMessageDialog(null, "The short term should be either 2 or 4. the default tem of 2 years is chosen automatically", "The default is chosen", JOptionPane.ERROR_MESSAGE);
			this.term = SHORT;
		}
		else {
		this.term = term;
		}
	}
	public abstract double calculateIntRate(double rate);
	
	public int getLoanNum() {
		return loanNum;
	}
	public String getName(){
		return studName;
	}

	public boolean equals(Loan anotherLoan) {
		if(this.getLoanNum() == anotherLoan.getLoanNum()) {
			
			return true;
		}
		else {
			
			return false;
		}
	}
	@Override 
	public String toString() {
		DecimalFormat df2 = new DecimalFormat("#.##");
		return "Loan #" + loanNum + "; Name: "+ studName + "; Amount: $" + amount + "; Inerest Rate: " + df2.format(intRate*100) + "%; Term: " + term + " years";
	}
	}


import javax.swing.JOptionPane;

public class Demo {
public static void main(String[] args) {
	
	Loan[] loans = new Loan[5];
	double rate;
	//ask for a rate
	rate = Double.parseDouble(JOptionPane.showInputDialog("Enter the current prime interest rate as a decimal number, for example, .05"));
	System.out.println(rate);
	//ask for info 5 times
	
	for(int i=0; i<loans.length; i++) {
		
		String name;
		int loanNum, term, loanType;
		double amount;
		//ask for loan number
		loanType = Integer.parseInt(JOptionPane.showInputDialog("Is this a (1) Grad loan or (2) Undergrad loan"));
		
		//ask for the loan type while it is not 2 or 4
			while(loanType != 1 && loanType != 2) {
				loanType = Integer.parseInt(JOptionPane.showInputDialog("Please enter either (1) Grad loan or (2) Undergrad loan"));
			}
			
		//ask other info
		loanNum = Integer.parseInt(JOptionPane.showInputDialog("Enter loan number"));
		name = JOptionPane.showInputDialog("Enter student full name");
		amount = Double.parseDouble(JOptionPane.showInputDialog("Enter the amount of loan"));
		term = Integer.parseInt(JOptionPane.showInputDialog("Enter term/years 2 or 4"));
		
		//if gradLoan is chosen
		if(loanType ==1) {
			//create gradloan object
			GradLoan newLoan = new GradLoan(loanNum, name, amount, term);
			//set the rate
			newLoan.calculateIntRate(rate);
			
			//check if the record exists
			//only if the counter is more than 1
			if( i > 0) {
				
				for(int c=0;c < i; c++) {
					
					//if loan exists decrement counter and forget about this object
					if(loans[c].equals(newLoan)) {
						JOptionPane.showMessageDialog(null,"This record Already exists");
						i--;
					}
					//if doesn't exist - add object to the array

					else {
						loans[i] = newLoan;
					}
				}
			}
			else {
				loans[i] = newLoan;
			}
				
		}
		else {
			//create undergradloan object

			UndergradLoan newLoan = new UndergradLoan(loanNum, name, amount, term);
			//set the rate
			newLoan.calculateIntRate(rate);
			//check if the record exists
			//only if the counter is more than 1
			if( i > 0) {
				for(int c=0;c<i; c++) {
					//if loan exists decrement counter and forget about this object
					if(loans[c].equals(newLoan)) {
						
						JOptionPane.showMessageDialog(null,"This record Already exists");
						i--;
					}
					//if doesn't exist - add object to the array
					else {
						loans[i] = newLoan;
					}
				}
			}
			//if counter is 0 - don't check, just add to the array
			else {
				loans[i] = newLoan;
			}
			
		}//if else ends	
	
	} // ends for(i<5)
	loans = sortLoans(loans);
	
	String text ="Loan DB: \n";
	for(Loan loan : loans) {
		text += loan + "\n";
	}
	JOptionPane.showMessageDialog(null, text);
	compare(loans);
	
	
}//main class ends

//insertion sort function
public static Loan[] sortLoans(Loan[] loans) {
	int a =1;
	int b;
	Loan temp;
	
 while(a<loans.length) {
	 
	 temp = loans[a];
	 b = a-1;
	 
	 while(b >=0 && loans[b].getName().compareTo(temp.getName()) > 0) {
		 loans[b+1] = loans[b];
		 b--;
	 }
	 loans[b+1] = temp;
	 a++;
 }
 return loans;
}

public static void compare(Loan[] loans) {
	//ask for the first number
	int firstNum = Integer.parseInt(JOptionPane.showInputDialog("Let's compare! Enter one of the loan numbers"));
	Loan found = findObject(firstNum,loans);
	//if it doesn't exist ask one more time
	while(found == null) {
		firstNum = Integer.parseInt(JOptionPane.showInputDialog("Loan number doesn't exist, enter new one"));
		found = findObject(firstNum,loans);
	}
	//ask for the second number

	int secNum = Integer.parseInt(JOptionPane.showInputDialog("Enter another loan number"));
	Loan found2 = findObject(secNum,loans);
	//if it doesn't exist ask one more time

	while(found2 == null) {
		secNum = Integer.parseInt(JOptionPane.showInputDialog("Loan number doesn't exist, enter new one"));
		found2 = findObject(secNum,loans);
	}
	//if equals display relative message
	if(found.equals(found2)) {
		JOptionPane.showMessageDialog(null, "Accounts are equal");
	}
	//if are not equal, another message
	else {
		JOptionPane.showMessageDialog(null, "Accounts are NOT equal");
	}
}

//find object function
public static Loan findObject(int loanNum, Loan[] loans) {
	Loan found= null;
	for(Loan loan : loans) {
		if(loan.getLoanNum() == loanNum) {
			found = loan;
		}
		
	}
	return found;
}
}

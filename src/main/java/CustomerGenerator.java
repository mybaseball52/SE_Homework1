/* CustomerGenerator.java is a thread class generates customers for * 					a bank queue simulation * * Started by: Charles Hoot, for Hands On Java. * Date: July, 2000       * Finished by: *****************************************************************/import Customer;import BankLine;class CustomerGenerator extends Thread{	private static final int MAX_TIME = 5000;	private static final int MIN_TIME = 100;		private BankLine myLine;	private int count;	private boolean makeCustomerVerbose;	/*****************************************************************	 * CustomerGenerator constructor	 *	 * Input: The line associated with the Teller	 * PostCondition: remembers the line	 *				number of customers generated is zero	 *****************************************************************/	public CustomerGenerator(BankLine line, boolean verbose){		myLine = line;		count = 0;		makeCustomerVerbose = verbose;	}			/*****************************************************************	 * what to do when the thread is run	 *	 *****************************************************************/	public void run(){		while(true){			try {				Customer aCustomer = 					new Customer((new Integer(count)).toString(), makeCustomerVerbose);				count++;				myLine.addCustomer(aCustomer);				int nextCustomerIn = MIN_TIME  								+ (int) Math.round(Math.random() * (MAX_TIME - MIN_TIME));				sleep(nextCustomerIn);			} catch( InterruptedException ex) {				// just continue on			}		}	}	} // end of class
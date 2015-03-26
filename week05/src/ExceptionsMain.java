
public class ExceptionsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/////////////////////////////////////
		//THROWING AND CATCHING AN EXCEPION//
		/////////////////////////////////////
		
		String s = null;	//string was set to null
		Sequence mySequence = new Sequence(s);	//null string passed into a Sequence object
		//char temp = mySequence.getLetter(0); //will return an exception, can check oracle docs to see what it means
		
		try {char temp2 = mySequence.getLetter(0); // make our own exception
		} catch (Exception e) {
			System.out.println("reinitializing sequence");
			mySequence = new Sequence ("ACTG");
			char temp3 = mySequence.getLetter(0);
			System.out.println("first letter is " + temp3);
		}
		
		try { char temp2 = mySequence.getLetter(5);
		} catch (StringIndexOutOfBoundsException myException) { 
			System.out.println("Exception message: " + myException.getMessage()); //getMessage function is included in the Exception class
		}
		
		System.out.println("End of Program");

	}

}

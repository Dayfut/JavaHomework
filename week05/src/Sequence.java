
public class Sequence {	//simple sequence class
	private String rawSequence;
	
	Sequence (String s) {	//constructor
		rawSequence = s;
	}
	
	public char getLetter (int pos) throws StringIndexOutOfBoundsException //throw a specific exception
	{	//simple get method
		return rawSequence.charAt(pos);
	}
}

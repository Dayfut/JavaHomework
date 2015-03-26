package sequencePackage;

public class Sequence {
	
	protected String rawSequence;
	protected String domain; //if 'protected' it can be modified from subclass
	
	//Default constructor
	public Sequence(){
		rawSequence = "Not initialized";
		domain = "Not initialized";
	}
	
	//Non-default constructor
	public Sequence(String rs, String dom){
		rawSequence = rs;
		domain = dom;
	}
	
	//Accessor methods
	public String getSequence(){
		return rawSequence;
	}
	public String getDomain(){
		return domain;
	}
	public String toString(){
		return "Sequence: " + rawSequence + " Domain: " + domain;
	}
	
	
}

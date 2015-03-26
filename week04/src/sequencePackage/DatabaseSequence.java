package sequencePackage;

public class DatabaseSequence extends Sequence { //extends means its a subclass of Sequence
	private String sourceURL;
	
	public DatabaseSequence(String rs, String dom, String source){
		
		//rawSequence = rs; calls variables directly..
		//domain = dom;
		//BUT.. you can chain constructors
		
		super(rs, dom); //calls the constructor in the superclass
		sourceURL = source;
	}
	
	public void printSource(){
		System.out.println("Source URL: " + sourceURL);
	}
	
	//overriding allows for polymorphisms, so if the object
	//is detected as part of a subclass, the corresponding
	//method in the subclass will be run instead of 
	//the superclass method
	@Override
	public String toString(){
		return "Sequence: " + rawSequence + " src: " + sourceURL;
	}
}

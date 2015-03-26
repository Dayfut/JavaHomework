
public class MiniGenBankSeq {
	
	String locus;
	String acc;
	String def;
	String source;
	
	//get methods return their respective variables, if any of the methods detect null for the variable it will return a warning message
	public String getLocus() {							//returns the locus
		if (locus == null) {							
			return "Warning: locus not initialized";
		}
		return locus;
	}
	public String getAcc() {							//returns the accession number
		if (acc == null) {
			return "Warning: accession number not initialized";
		}
		return acc;
	}
	public String getDef() {							//returns the definition
		if (def == null) {
			return "Warning: definition not initialized";
		}
		return def;
	}
	public String getSource(){							//returns the source
		if (source == null) {
			return "Warning: source not initialized";
		}
		return source;
	}
	
	//set methods allow the variables of each instance to be modified
	public void setLocus(String l) {	//modifies the locus
		locus = l;
	}
	public void setAcc(String a) {		//modifies the accession number
		acc = a;
	}
	public void setDef(String d) {		//modifies the definition
		def = d;
	}
	public void setSource(String s){	//modifies the source
		source = s;
	}

	public MiniGenBankSeq() {		//noargs constructor will set all values to null if no arguments are passed
	}
	
	public MiniGenBankSeq(String l, String a) {	//2args constructor will set the locus and accession number if 2 arguments are passed
		locus = l;
		acc = a;

	}
	public MiniGenBankSeq(String l, String a, String d, String s) { //4args constructor will set values for all 4 variables if 4 arguments are passed
		locus = l;
		acc = a;
		def = d;
		source = s;
	}
	
	@Override
	public String toString(){		//overrides the toString method and outputs a formated string of information for a MiniGenBankSeq object
		StringBuilder output = new StringBuilder();		//creates a new StringBuilder object
		output.append("Locus:\t");						//each append method builds lines for each category of information
		output.append(getLocus() + "\n");
		output.append("Accession Number:\t");
		output.append(getAcc() + "\n");
		output.append("Definition:\t");
		output.append(getDef() + "\n");
		output.append("Source:\t");
		output.append(getSource() + "\n");
		return output.toString();					//return all the inforation as a single string
	}
	
}

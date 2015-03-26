import sequencePackage.DatabaseSequence;
import sequencePackage.Sequence;

public class testMain {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating a default sequence
		Sequence defaultSequence = new Sequence();
		System.out.println(defaultSequence.getSequence());
		System.out.println(defaultSequence.getDomain() + "\n");
		
		//creating a sequence using non-default constructor
		Sequence sequenceA = new Sequence("AAAAAAA", "A-domain");
		System.out.println(sequenceA.getSequence());
		System.out.println(sequenceA.getDomain() + "\n");
		
		//array of sequences
		Sequence [] sequences = new Sequence[4];
		sequences[0] = new Sequence("ACTG", "B-Domain");
		sequences[1] = sequenceA;
		sequences[2] = new Sequence("GTCA", "C-Domain");
		sequences[3] = new DatabaseSequence("CCCCCCCC", "C-Domain", "NCBI");
		
		System.out.println ("print out contents from array of sequences");
		for (int i = 0; i < sequences.length; i++){
			System.out.println(sequences[i].toString());
		}
	
	}

}

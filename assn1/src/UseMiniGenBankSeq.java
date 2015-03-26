
public class UseMiniGenBankSeq {

	public static void main(String[] args) {
		
		MiniGenBankSeq noargs = new MiniGenBankSeq();			//creation of a MiniGenBankSeq instance with no arguments
		System.out.println(noargs.toString());	//shows the variables of the object with no arguments, prints warning messages since values have not been assigned to the object variables
		noargs.setLocus("PAU93274");			//assign values to locus, accesssion number, definition, and source for noargs MiniGenBankSeq object
		noargs.setAcc("U93274");
		noargs.setDef("Pseudomonas aeruginosa YafE (yafE), LeuB (leuB), Asd (asd), FimV (fimV), and HisT (hisT) genes, complete cds; TrpF (trpF) gene, partial cds; and unknown gene.");
		noargs.setSource("Pseudomonas aeruginosa PAO1");
		System.out.println(noargs.toString());	//show the variables for noargs with values assigned to its variables  
		
		MiniGenBankSeq twoArgs = new MiniGenBankSeq("CP000560", "CP000560");	//create an object with 2 arguments
		System.out.println(twoArgs.toString());		//show that only 2 arguments contain values
		twoArgs.setDef("Bacillus amyloliquefaciens subsp. plantarum str. FZB42, complete genome.");		//assign values to definition and source
		twoArgs.setSource("Bacillus amyloliquefaciens subsp. plantarum str. FZB42");
		System.out.println(twoArgs.toString());		//show that the twoargs MiniGenBankSeq object now has values assigned to all 4 of its variables
		
		//create an object with 4 arguments
		MiniGenBankSeq allArgs = new MiniGenBankSeq("CP001087", "CP001087", "Desulfobacterium autotrophicum HRM2, complete genome.", "Desulfobacterium autotrophicum HRM2");
		System.out.println(allArgs.toString());	//show that all variables in allArgs contains values
	}

}

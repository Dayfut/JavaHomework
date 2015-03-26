public class Week2Assignment {

	public static void cleanData (double[] input, float threshold, float ep) {
		int zeroedWeights = 0;
		
		for (int i = 0; i < input.length; i++){		//loop through array
			
			if (input[i] < threshold) {			//check if value is less than threshold
				if (Math.abs(input[i] - threshold) < ep){	//check if the number could have been equal
				zeroedWeights++;
				}
		
				input[i] = 0;
			}
		}
		//print results
		System.out.println("The array is now: ");
		for (int i = 0; i < input.length; i++){
		System.out.println(input[i]);
		}
		System.out.println(zeroedWeights + " could have been equal.");
	}
	
	public static void main(String[] args) {
		double[] array = {1.1, 3.2, 6.3, 2.2, 0.2, 10.2, 3.6, 2.2, 2.3, 2.4, 2.8};
		System.out.println("The initial array is:");
		for (int i = 0; i < array.length; i++){
			System.out.println(array[i]);
			}
		cleanData(array, (float) 2.4, (float) 0.4); // dont understand the epsilon thing
		
	}

}


public class Baby {
	String name;	//declare variables that the class will hold
	int age;
	int poops = 0;
	double weight;		// sets default weight for the baby
	boolean isMale;
	
	static int totalBabies = 0; //'static' applies to all instances under a class
	
	//write a constructor method for our 'Baby' class
	Baby(String myName, int babyAge, double birthWeight, boolean maleBaby){
		age = babyAge;
		name = myName;
		weight = birthWeight;
		isMale = maleBaby;	
		
		totalBabies += 1; //adds to the number of total babies every time a new baby is declared
	}
	
	//creating methods for the 'Baby' class
	void eat (double foodWeight) {		//feeds the baby with food and adds to its weight
		if (foodWeight >= 0 && foodWeight < weight){
			weight = foodWeight + weight;
		}
	}
	
	void sayHi (){
		System.out.println("Hi my name is " + name +".");
	}
	
	void starve (){
		weight = 0;
		System.out.println (name + " didn't eat and now weighs " + weight + ".");
		System.out.println (name + " died cause you starved them.");
	}
	
	//static methods
	static void cry (Baby theBaby) { //static methods can be called without creating an object
		System.out.println(theBaby.name + " cries"); //but you have to pass the instance into the method
	}
	
	
}


public class UseBaby {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Baby david = new Baby("David", 1, 5.0, true);
		Baby fuccboi = new Baby("anam", 2 , 20.0, true);
		
		System.out.println("Davids name is: " + david.name); //calling a variable in the object
		david.sayHi(); //using the method we used to do the same thing
		System.out.println("David is " + david.weight + "pounds.");
		System.out.println ("Lets feed david 0.25 pounds of food.");
		david.eat(0.25);  //use method to add to baby's weight
		System.out.println("David is now " + david.weight + " pounds");
		System.out.println("What happens when you starve a baby cause you're an asshole?");
		david.starve();
		
		//just as extra note, arrays and objects are passed by reference into
		//methods while primitives such as ints and strings are passed by value
		
		System.out.println("There have been " + david.totalBabies + " babies made"); //using a static variable in an object to see that 2 babies were made
		
		//using a static method
		Baby.cry(fuccboi);
	}

}

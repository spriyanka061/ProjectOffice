package coreJava;

public class FinalExample extends Animal{
    
  //it is necessary to initialise the final variable
	final int speedlimit; 
//constructor can not be declared as final becausse it can never be inherited. 	
// it is necessary to initialise the static final variable in static final block.
	static final int pancard;
	static {
		pancard=1234;
	   }
	
	FinalExample(){
		speedlimit=60;
		System.out.println("speedlimit is="+speedlimit);
	}
	
	public static void main(String[] args) {
		FinalExample fe=new FinalExample();
		System.out.println("pancard number is="+FinalExample.pancard);
	   }
 }

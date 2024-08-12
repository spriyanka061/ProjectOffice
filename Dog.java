package coreJava;

public class Dog extends Animal{
	 String colour="black";
	 int number=5;
	
	public void print() {
		System.out.println("child colour="+colour);
		System.out.println("Parent colour="+super.colour);
	  }
	
	public void eat() {
		
		System.out.println("dog eats");
	}
	
}

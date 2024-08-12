package coreJava;

public class A {
 int data=10;
	A(){
		B b=new B(this);  //object of the class is passed as argument in the form of this.
		b.display();
		
		//this keyword reference to the instance of the class
		System.out.println("object in the method="+this); 
		}
	
	public static void main(String[] args) {
		A a=new A();
		System.out.println("object in main="+a);
	}
}

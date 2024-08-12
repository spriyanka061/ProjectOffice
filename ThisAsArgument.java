package coreJava;

// this is passed as argument in the method.

public class ThisAsArgument {

	void m(ThisAsArgument obj) {
		System.out.println("method is invoked...");
		}
	void p() {
		m(this);  //obj of class is passed as this(as parameter).
	}
	
	public static void main(String[] args) {
		ThisAsArgument t=new ThisAsArgument();
		t.p();
	}
}

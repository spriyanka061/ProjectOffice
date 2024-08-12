package coreJava;

public class TestInterface {

	public static void main(String[] args) {
		drawableInterface d=new Circle(); //implemented interface object refer to the child class.
		d.draw();
		drawableInterface.shape();   //use interface name to call the static method.
		d.size();                    //by the use of obj we can call default method of interface.
	}

}

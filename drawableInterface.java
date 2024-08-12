package coreJava;

public interface drawableInterface {
 void draw();
 
 //use interface name to call the static method from another class.
 static void shape() {
	 System.out.println("static method- shape in the interface");
     }
 
 default void size() {
	System.out.println("default method- size is in the interface"); 
    }
}

package coreJava;
/*static method can not be overridden.
 *because static method is bound to the class and instance method 
 *is bound to heap area(object of the class).
 */
public class Child extends Parent{
	public void print() {
		System.out.println("child class method");
	    }
      Child(){
	    super();
       }
      
      void sirname() {
  		System.out.println("sirname is of child..");
  	}
  	void property() {
  		System.out.println("property value is of child...");
  		}
  	void car() {
  		System.out.println("car is of child...");
  	}
	public static void main(String[] args) {
		
		System.out.println("hello child class");
		Child c=new Child();
	//runtime polymorphism
		c.sirname();
		c.car();
		c.property();
		
		Parent p=new Parent();
		//parent class object can hold child class reference.
		Parent p1=new Child();
		c.print();
		p.print();
		p1.print();
	}
}

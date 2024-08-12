package coreJava;
//default constructor example
public class Bike1 {
	int id;
	String name;
public void display() {
	
	System.out.println("display method called---");
	System.out.println("id ="+id+" "+"name="+name);
}
	public static void main(String[] args) {
	Bike1 b1=new Bike1();
	b1.display();
	Bike1 b2=new Bike1();
	b2.display();
	}

}

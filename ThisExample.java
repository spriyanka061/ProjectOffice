package coreJava;
//This keyword is used to initialize the current class instance varaibles(variables of class)

public class ThisExample {
	//instance variables
int id;
String name;
Float percentage;

ThisExample(int id,String name,Float percentage){
	//instance variables are assigned the values of parameters passed in the constructor.
	this.id=id;
	this.name=name;
	this.percentage=percentage;
	
}
public void display() {
	System.out.println("id="+id+" name="+name+" percentage="+percentage);
}
	public static void main(String[] args) {
		ThisExample te=new ThisExample(10, "Ria", 89f);
		ThisExample te1=new ThisExample(30, "hina", 78f);
		te.display();
		te1.display();
	}

}

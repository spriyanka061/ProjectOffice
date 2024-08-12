package coreJava;

public class Variables {
	
	int age;
	String name;
	
	Variables(int age,String name){
		this.age=age;
		this.name=name;
	}
	public void printDetails() {
		System.out.println("name is="+this.name);
		System.out.println("age is="+this.age);
	}
	public static void main(String[] args) {
		Variables one=new Variables(10,"Nisha");
		Variables two=new Variables(20,"Anand");
		one.printDetails();
		two.printDetails();
	}

}

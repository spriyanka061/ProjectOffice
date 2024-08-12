package coreJava;

//in this constructore is called in another constructor

public class ConstructorChaining {
	ConstructorChaining(){
		this(10);   //---2
		System.out.println("hello constructor...");
		
	}
	ConstructorChaining(int id){
		//this();---1
		System.out.println("id="+id);
	}

	public static void main(String[] args) {
		
		ConstructorChaining cc=new  ConstructorChaining();     //---2
	  //ConstructorChaining cc=new  ConstructorChaining(10);   //---1 
	}
}

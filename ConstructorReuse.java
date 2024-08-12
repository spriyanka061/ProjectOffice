package coreJava;

//constructor reuse-main use of the this keyword

public class ConstructorReuse {

	int id;
	String name, course;
	float fee;
	
	ConstructorReuse(int id,String name,String course){
		this.id=id;
		this.name=name;
		this.course=course;
	  }
	
	ConstructorReuse(int id,String name,String course,float fee){
		
		this(id,name,course);  // constructor reuse
		this.fee=fee;
    	}
	
	public void display() {
		
		System.out.println("id="+id+" name="+name+" course="+course+" fee="+fee);
	}
	
	public static void main(String[] args) {
		
		ConstructorReuse cr=new ConstructorReuse(10,"Ria","CA"); // bydefault fee will be 0.0
		ConstructorReuse cr1=new ConstructorReuse(20,"Tia","CS",6000f);
		cr.display();
		cr1.display();
	}

}

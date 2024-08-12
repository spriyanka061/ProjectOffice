package coreJava;

public class Student2 {
int id;
String name;
int age;

Student2(int i,String n){
	id=i;
	name=n;
}
Student2(int i,String n, int a){
	id=i;
	name=n;
	age=a;
}
public void display() {
	System.out.println("id="+id+" name="+name+" age="+age);
	}

	public static void main(String[] args) {
		Student2 s1=new Student2(1,"RAM  ");  //bydefault it will take age=0.
		Student2 s2=new Student2(5,"Shyam",22);
		s1.display();
		s2.display();
	    }

}

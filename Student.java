package coreJava;

public class Student {
int id;
String name;

//creating a paramaterized constructor
Student(int i,String n){
	id=i;
	name=n;
}
public void display() {
	System.out.println("student id="+id+" student name="+name);
}
	public static void main(String[] args) {
		Student s1=new Student(1,"Ram");
		Student s2=new Student(2,"Ria");
		s1.display();
		s2.display();
	}

}

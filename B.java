package coreJava;

public class B {

	A Aobj;
	B(A a){
		this.Aobj=a;
	}
   void display() {
		System.out.println("object.data of class A="+Aobj.data);
	}
}

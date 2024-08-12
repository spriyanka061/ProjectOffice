package coreJava;

public class Overloading {

	public void calculation(int x,int y) {
		int result=x+y;
		System.out.println("sum of two is="+result);
	}
	public void calculation(int x,int y,int z) {
		int result=x+y+z;
		System.out.println("sum of three is="+result);
	}
	
	public void calculation(float x,float y) {
		float result=x+y;
		System.out.println("sum of three is="+result);
	}
	//mains method overloading but JVM will call only main() with String[] method.
	
	public static void main(String[] args) {
		System.out.println("String[] args called by JVM");
		Overloading a=new Overloading();
		a.calculation(3,8);
		a.calculation(2,3,5);
		a.calculation(10.9f, 10.1f);
	}
	public static void main(String args) {
		System.out.println("String args called...");
	}
	public static void main() {
		System.out.println("no arguments method called..");
	}

}

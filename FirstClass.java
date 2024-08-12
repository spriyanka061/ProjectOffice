package coreJava;

public class FirstClass {

	static int x=11;
	private int y=12;
	public void method1(int x) {
		FirstClass t=new FirstClass();
		//this.x=100;
		y=44;
		System.out.println("this.x="+this.x);
		System.out.println("t.x="+t.x);
		System.out.println("t.y="+t.y);
		System.out.println("y="+y);
		
	}
	public static void main(String[] args) {
		System.out.println("hello java");
		FirstClass t=new FirstClass();
		t.method1(6);
	}
}

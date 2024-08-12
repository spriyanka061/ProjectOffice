package coreJava;
// this keyword can be used to call the instance 
public class ThisMethodCall {
public void m() {
	System.out.println("hello m()");
}
public void n() {
	System.out.println("hello n()");
	m(); //compiler converts this into this.m()
	this.m();
}
	public static void main(String[] args) {
		ThisMethodCall t=new ThisMethodCall();
		t.n();
	}

}

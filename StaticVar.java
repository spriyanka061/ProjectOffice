package coreJava;
//static variable is used to assign a memory at once in class area.
public class StaticVar {
 int a=10;
	int std;
	String name;
    static String school="DAV";
    static int counter=0;
	
    public void display() {
    	
    	System.out.println("std="+std+"th"+" Name="+name+" school name="+school);
    	System.out.println("counter is="+counter);
    	counter++;
    }
    StaticVar(int std,String name){
    	//these stores memory in heap area
    	this.std=std;
    	this.name=name;
    }
    // static method to access or change static data.
    static void Change(){
    	school="SKV";
    	  	
    }
    static void get(){
    	//System.out.println("non static data="+a); // this will give compile time error
    	  	
    }
    //static block-it is used to initialize the static members
    //invoked before the main method.
    static{
    	System.out.println("static block invoked");
    }
    
	public static void main(String[] args) {
		
		StaticVar s=new StaticVar(6,"Tara");
		StaticVar s1=new StaticVar(8,"Ria");
		StaticVar s2=new StaticVar(11,"Lisa");
	// no need to use instance of the class, we can directly call static method with class name.
		StaticVar.Change(); //or s.method();
		//s.get(); this will give compile time error.
		s.display();
		s1.display();
		s2.display();
	}
}

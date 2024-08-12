package coreJava;

public class InitialiseBlock {
	int id;
	{    id=10;
		System.out.println("Hello block...");
	}
	
	InitialiseBlock(){
		System.out.println("hello constructor...");
		System.out.println("id="+this.id);
	}
	public static void main(String[] args) {
		InitialiseBlock i=new InitialiseBlock();
		InitialiseBlock b=new InitialiseBlock();
		}

}

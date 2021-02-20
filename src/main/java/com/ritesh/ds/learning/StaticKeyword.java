package com.ritesh.ds.learning;

class StaticKeyword {
	int roll;
	String name;
	static String college = "KIIT";
	int count = 0;
	static int staticCount = 0;
	
	static void change(){
		college = "Kalinga Institute Of Industrial Technology";
	}
	
	StaticKeyword(int r,String n){
		roll = r;
		name = n;
		count++;
		staticCount++;
		System.out.println("Count = "+count+"\n"+"Static Count = "+staticCount+"\n");
	}
	
	void display(){
		System.out.println("Name : "+name+"\n"+"Roll : "+roll+"\n"+"College : "+college
				+"\n");
	}
	
	public static void main(String args[]){
		StaticKeyword.change();
		StaticKeyword sk1 = new StaticKeyword(907120,"Ritesh");
		StaticKeyword sk2 = new StaticKeyword(907114,"Rahul");
		StaticKeyword sk3 = new StaticKeyword(907003,"Avishek");
		sk1.display();
		sk2.display();
		sk3.display();
		System.out.println(college);
	}

}

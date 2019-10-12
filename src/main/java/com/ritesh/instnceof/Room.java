package com.ritesh.instnceof;

class Home{
}
class Room extends Home {
	static void method(Home h){
		if(h instanceof Room){
			Room r = (Room)h;
			System.out.println("Downcasting Performed");
		}
	}
	public static void main(String args[]){
		Home h = new Room();
		Room.method(h);
	}
}
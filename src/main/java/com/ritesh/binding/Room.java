package com.ritesh.com.ritesh.binding;

class Home{
	void display(){
		System.out.println("You are in Home.");
	}
}

public class Room extends Home {
	void display(){
		System.out.println("You are in Room.");
	}
	public static void main(String args[]){
		Home obj = new Room();
		obj.display();
	}
}

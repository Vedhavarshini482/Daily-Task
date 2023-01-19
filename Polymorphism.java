abstract class Animal {
	float weight;
	String colour;
	Animal(float a, String b) {
		this.weight = a;
		this.colour = b;
	}

	abstract void eat() ;
}

class Dog extends Animal {

	Dog(float a, String b) {
		super(a, b);
	}

	public void eat() {
		System.out.println("Dogs like to eat bones");
		System.out.println("My Weight is " + weight + "kg");
		System.out.println("My colur is " + colour);
	}
}

class Cat extends Animal {
	Cat(float a, String b) {
		super(a, b);
	}

	public void eat() {
		System.out.println("Cats like to eat fishes");
		System.out.println("My Weight is " + weight + "kg");
		System.out.println("My Colour is " + colour);
	}
}

public class Polymorphism {

	public static void main(String[] args) {
		Animal animal = new Dog(5, "Black");
		animal.eat();
		animal = new Cat(4, "White");
		animal.eat();
	}
}

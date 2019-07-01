package myCodes.testcode;

class A {
	void show() {
		System.out.println("in A");
	}

	A() {
		System.out.println("hi constructor of A");
	}
}

class B extends A {
	// this constructor implicitly calls the parent constructor and if it is private
	// then compile time
	// error is thrown.
	B() {

		System.out.println("in B constructor");
	}
}

public class OverDemo {

	public static void main(String[] args) {
		B b = new B();

	}

}

package mytest;

public class Test {
	public static void main(String[] args) {
		Derived b = new Derived();
		b.f();
		b.g();
		b.g(0);
	}
}

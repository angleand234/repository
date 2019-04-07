package mytest;

public class Derived extends Base {
	private static StringBuffer q;
	public Derived() {
		// TODO Auto-generated constructor stub
		q=new StringBuffer("jel");
		q=new StringBuffer("sss");
		System.out.println(q.toString());
	}
	public void g() {
		System.out.println("Derived g()");
	}
	public void f() {
		System.out.println("Derived f()");
	}
	public void h() {
		System.out.println("Derived h()");
	}
	public void g(int b) {
		System.out.println("Derived g(0)");
	}
}

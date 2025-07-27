public class DeadLock {
	public static void main(String[] args) {
		Object r1 = new Object();
		Object r2 = new Object();

		A a = new A(r1, r2, "A");
		B b = new B(r1, r2, "B");

		a.t.start();
		b.t.start();
		
		// Press CTRL-C to quit
	}
}

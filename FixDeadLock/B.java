public class B implements Runnable {
	Object r1;
	Object r2;
	Thread t;

	public B(Object r1, Object r2, String name) {
		t = new Thread(this, name);
		this.r1 = r1;
		this.r2 = r2;
	}

	public void run() {
		synchronized (r1) {
			System.out.print(Thread.currentThread().getName());
			System.out.println(": I have the lock on r1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught!!!");
			}
			System.out.print(Thread.currentThread().getName());
			System.out.println(": Attempting to access lock on r2");
			synchronized (r2) {
				System.out.print(Thread.currentThread().getName());
				System.out.println(": I have the lock on r2");
			}
		}
	}
}

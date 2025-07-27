public class PingPong {
	boolean lock = false; // we need lock to prevent deadlock
							// (both methods calling wait)

	public synchronized void ping() {
		while (!lock) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}

		System.out.println("Ping");
		lock = false;
		notify();
	}

	public synchronized void pong() {
		while (lock) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println("InterruptedException caught");
			}
		}

		System.out.println("Pong");
		lock = true;
		notify();
	}
}

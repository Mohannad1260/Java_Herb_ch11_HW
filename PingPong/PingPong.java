public class PingPong {
	boolean flag = false; // we need flag to prevent deadlock
							// (both methods calling wait)

	public synchronized void ping() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught");
			}
		}

		System.out.println("Ping");
		flag = false;
		notify();
	}

	public synchronized void pong() {
		while (flag) {
			try {
				wait();
			} catch (Exception e) {
				System.out.println("InterruptedException caught");
			}
		}

		System.out.println("Pong");
		flag = true;
		notify();
	}
}

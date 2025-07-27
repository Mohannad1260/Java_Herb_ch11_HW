public class PingCaller implements Runnable {
	public int n;
	public PingPong pp;
	public Thread t;

	public PingCaller(String name, PingPong pp, int n) {
		this.n = n;
		this.pp = pp;
		t = new Thread(this, name);
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			pp.ping();
		}
	}
}

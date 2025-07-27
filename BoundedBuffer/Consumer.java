public class Consumer implements Runnable {

	public Thread t;
	public BoundedBuffer<Integer> bf;
	public int n;

	public Consumer(BoundedBuffer<Integer> bf, String name, int n) {
		t = new Thread(this, name);
		this.bf = bf;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			try {
				Integer item = bf.take();
			} catch (InterruptedException e) {
				System.out.println("InterrputedException caught");
			}
		}
	}
}

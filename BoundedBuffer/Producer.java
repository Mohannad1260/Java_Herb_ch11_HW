public class Producer implements Runnable {

	public Thread t;
	public BoundedBuffer<Integer> bf;
	public int n;

	public Producer(BoundedBuffer<Integer> bf, String name, int n) {
		t = new Thread(this, name);
		this.bf = bf;
		this.n = n;
	}

	public void run() {
		for (int i = 0; i < n; i++) {
			try {
				bf.put(Integer.valueOf(i));
			} catch (InterruptedException e) {
				System.out.println("InterrputedException caught");
			}
		}
	}
}

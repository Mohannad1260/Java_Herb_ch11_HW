import java.util.ArrayList;
import java.util.List;

public class App {

	public static final int M = 7;
	public static final int N = 7;

	public static void main(String[] args) {
		List<Thread> threads = new ArrayList<>();
		BoundedBuffer<Integer> bf = new BoundedBuffer<>();

		for (int i = 0; i < M; i++) {
			Producer p = new Producer(bf, "p: " + (i + 1), 10);
			threads.add(p.t);
			p.t.start();
		}

		for (int i = 0; i < N; i++) {
			Consumer c = new Consumer(bf, "c: " + (i + 1), 10);
			threads.add(c.t);
			c.t.start();
		}

		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException caught!!!");
			}
		}
	}
}

import java.util.ArrayList;
import java.util.List;

public class BoundedBuffer<T> {

	public final int CAPACITY = 10;
	public List<T> buffer = new ArrayList<>(CAPACITY);

	public synchronized void put(T item) throws InterruptedException {
		// calls to wait should be within a loop to gaurd again spurious wakeup
		while (buffer.size() == CAPACITY) {
			wait();
		}
		buffer.add(item);
		System.out.print(Thread.currentThread().getName());
		System.out.println(". Item produced: " + item);
		notifyAll();
	}

	public synchronized T take() throws InterruptedException {
		while (buffer.isEmpty()) {
			wait();
		}
		T item = buffer.removeLast();
		System.out.print(Thread.currentThread().getName());
		System.out.println(". Item consumed: " + item);
		notifyAll();
		return item;
	}
}

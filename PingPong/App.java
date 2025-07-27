import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		PingPong pp = new PingPong();
		Scanner console = new Scanner(System.in);
		System.out.print("Enter the number of times you want the threads to alternate: ");
		int n;
		try {
			n = console.nextInt();
			console.close();
		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException caught");
			System.out.println("Setting n to 1");
			n = 1;
		} catch (IllegalStateException e) {
			System.out.println("IllegalStateException caught");
			System.out.println("Setting n to 1");
			n = 1;
		}

		PingCaller pingCaller = new PingCaller("Ping", pp, n);
		PongCaller pongCaller = new PongCaller("Pong", pp, n);

		pingCaller.t.start();
		pongCaller.t.start();

		try {
			pingCaller.t.join();
			pongCaller.t.join();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
	}
}

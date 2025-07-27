PingPong:
	I created the threads in PingCaller and PongCaller, by using the Thread
	class constructor and passing "this", while keeping the Thread as a field
	, so each either of the two classes is called another thread is created.
	I started the threads in the App.java by accessing the thread field in PingCaller
	and PongCaller. At the end I called join() on every thread to make sure that 
	the main thread is the last one to terminate.
	
	I used the synchronized keyword in the method signature of ping() and pong()
	in the class PingPong, this is the shared resource that prints ping and pong
	to the console, since both methods are synchronized only a single thread can 
	be in ping() or ping() at a time.

	I used wait() and notify() along with a boolean flag with the identified "lock".
	if the boolean flag is false then we have the thread in ping wait() and transfer 
	control to the other thread. There, since lock is false it won't wait() 
	it will print "pong" then switch the boolean flag (lock) (perhaps I should change
	the name of this flag :) ) and notify the ping thread that it can now resume.
	We use wait(), notify(), and the boolean flag to make sure that ping() and 
	pong() alternate printing to the screen.
	
BoundedBuffer:
	I created the Threads in the constructors of Produce and Consumer and stored
	it as a field in each class. Then in the App.java I created a list of producers
	and consumers started each as I created them, then after starting all of them,
	I looped through them again and called join() to ensure that the main thread 
	terminated last.
	
	I used the synchronized keyowrd in the shared resource BoundedBuffer so that 
	only a single thread can be in put() or take() at a time. We don't want to 
	two threads to produce and a thread to produce and another to consume at the 
	same time that can create race conditions. 

	We use wait() when the buffer is full to stop any producer from producing 
	any more items and we use wait() when the buffer is empty() to stop consumers
	from consuming from an empty buffer. We use notify() after each consuming action
	to tell the producers that you may awaken and we use notify() in put() in a symetrical
	fasion. 

DeadLock:
	In the deadlock demo I had thread A and thread B share two dummy resources 
	r1 and r2. Thread A would enter and lock on r1 then inside the lock on r1 it would
	go to sleep for a second this for all intents and purposes transfers control to
	the B thread which lock on r2 and sleeps and transfers back to A, now in A we attempt
	to enter the lock on r2 but we cannot since the B thread holds the lock so we 
	transfer to the B thread, which tries to gain the lock on r1 but we cannot since
	A holds the lock on r1. Both, threads are blocking each other and will never 
	be able to break the stalemate.

Fix Deadlock:
	I fixed this by having both threads hold the lock r1 then sleep then hold the lock r2
	in this case A enters holds r1 sleeps B enters holds r1 sleeps A comes back 
	gains r2 and exists B comes back gains r2 and exists. 

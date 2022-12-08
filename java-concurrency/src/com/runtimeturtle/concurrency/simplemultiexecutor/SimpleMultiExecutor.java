package com.runtimeturtle.concurrency.simplemultiexecutor;

import java.util.ArrayList;
import java.util.List;

/**
 * In this We are going to Create a Simple Multi-Executor The client of this
 * class can create a list of Runnable Tasks and set this list to Executors
 * constructor. When client runs executeAll(), it will execute all the given
 * tasks in parallel by passing each task to a different thread
 *
 * @author runtime-turtle
 *
 */
public class SimpleMultiExecutor {

	private final List<? extends Runnable> workers;
	private int i = 13;

	/* Constructor to Set List of Runnable Tasks */
	public SimpleMultiExecutor(List<? extends Runnable> workers) {
		this.workers = workers;
	}

	/* Method to Execute all the Tasks in Parallel */
	public void executeAll() {
		workers.forEach((worker) -> {
			if (worker instanceof Thread) {
				((Thread) worker).start();
			} else {
				
				worker.run();
				
				/* Proper Way to Run Runnable Tasks*/
				Thread t = new Thread(worker);
				t.setName("");
			}
		});


		/* Proper way to Run Runnable Tasks */
		workers.forEach((worker) -> {
			if(worker instanceof Runnable) {
				Thread t = new Thread(worker);
				t.setName("Runnable Thread - "+ i++);
				t.start();
			}
		});
	}

	/* Main method to Test and Run our methods */
	public static void main(String[] args) throws InterruptedException {

		/* Create a List of Threads */
		List<Thread> threadList = new ArrayList<Thread>();

		Thread d1 = new Thread(() -> {
			System.out.println("Message #01 : Thread Created - " + Thread.currentThread().getName());
		});
		d1.setName("first-thread");

		Thread d2 = new Thread(() -> {
			System.out.println("Message #02 : Thread Created - " + Thread.currentThread().getName());
		});
		d2.setName("second-thread");

		Thread d3 = new Thread(() -> {
			System.out.println("Message #03 : Thread Created - " + Thread.currentThread().getName());
		});
		d3.setName("third-thread");

		Thread d4 = new Thread(() -> {
			System.out.println("Message #04 : Thread Created - " + Thread.currentThread().getName());
		});
		d4.setName("fourth-thread");

		Thread d5 = new Thread(() -> {
			System.out.println("Message #05 : Thread Created - " + Thread.currentThread().getName());
		});
		d5.setName("fifth-thread");

		Thread d6 = new Thread(() -> {
			System.out.println("Message #06 : Thread Created - " + Thread.currentThread().getName());
		});
		d6.setName("sixth-thread");

		threadList.add(d1);
		threadList.add(d2);
		threadList.add(d3);
		threadList.add(d4);
		threadList.add(d5);
		threadList.add(d6);

		/* Set this List to Constructor */
		SimpleMultiExecutor executor = new SimpleMultiExecutor(threadList);

		/* Execute all the Threads in Parallel */
		executor.executeAll();

		/*-----------------------------start vs run --------------------------------*/

		Thread.sleep(2000);
		/* Create a List of Runnable */
		List<Runnable> runnalbeList = new ArrayList<Runnable>();

		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Message #07 : Thread Created - " + Thread.currentThread().getName());
			}
		};

		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Message #08 : Thread Created - " + Thread.currentThread().getName());
			}
		};

		Runnable r3 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Message #09 : Thread Created - " + Thread.currentThread().getName());
			}
		};

		Runnable r4 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Message #10 : Thread Created - " + Thread.currentThread().getName());
			}
		};

		Runnable r5 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Message #11 : Thread Created - " + Thread.currentThread().getName());
			}
		};

		Runnable r6 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Message #12 : Thread Created - " + Thread.currentThread().getName());
			}
		};

		
		runnalbeList.add(r1);
		runnalbeList.add(r2);
		runnalbeList.add(r3);
		runnalbeList.add(r4);
		runnalbeList.add(r5);
		runnalbeList.add(r6);

		/* Set this List to Constructor */
		executor = new SimpleMultiExecutor(runnalbeList);

		/* Execute all the Threads in Parallel */
		executor.executeAll();

	}

	/**
	 * Note : Instead of Thread you can use runnable too. But when you use Runnable
	 * interface you can use Start method To start the thread, you need to call the
	 * run method. and when you call run method instead of start, the thread starts
	 * immediately even before setting the thread name. But when you use start
	 * method, OS schedules it and internally it calls Run method to start the
	 * thread. You can see the Difference in Below code
	 */
	/* Main method to Test and Run our methods */
	public static void runDemo(String[] args) {

		/* Create a List of Threads */
		List<Thread> threadList = new ArrayList<Thread>();

		Thread d1 = new Thread(() -> {
			System.out.println("Message #01 : Thread Created - " + Thread.currentThread().getName());
		});
		d1.setName("first-thread");

		Thread d2 = new Thread(() -> {
			System.out.println("Message #02 : Thread Created - " + Thread.currentThread().getName());
		});
		d2.setName("second-thread");

		Thread d3 = new Thread(() -> {
			System.out.println("Message #03 : Thread Created - " + Thread.currentThread().getName());
		});
		d3.setName("third-thread");

		Thread d4 = new Thread(() -> {
			System.out.println("Message #04 : Thread Created - " + Thread.currentThread().getName());
		});
		d4.setName("fourth-thread");

		Thread d5 = new Thread(() -> {
			System.out.println("Message #05 : Thread Created - " + Thread.currentThread().getName());
		});
		d5.setName("fifth-thread");

		Thread d6 = new Thread(() -> {
			System.out.println("Message #06 : Thread Created - " + Thread.currentThread().getName());
		});
		d6.setName("sixth-thread");

		threadList.add(d1);
		threadList.add(d2);
		threadList.add(d3);
		threadList.add(d4);
		threadList.add(d5);
		threadList.add(d6);

		/* Set this List to Constructor */
		SimpleMultiExecutor executor = new SimpleMultiExecutor(threadList);

		/* Execute all the Threads in Parallel */
		executor.executeAll();
	}

}

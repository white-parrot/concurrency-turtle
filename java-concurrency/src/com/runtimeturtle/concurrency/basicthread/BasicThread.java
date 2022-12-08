package com.runtimeturtle.concurrency.basicthread;

/**
 * A Class for Basic Thread Example
 * 
 * @author runtime-turtle
 *
 */
public class BasicThread {

	public static void main(String[] args) {
		
		emptyThread();
		emptyRunnableThread();
		basicThreadWithRunnableConstructor();
		basicThreadWithRunnableLambda();
		basicRunnableThread();
		
		SimpleThreadClass t = new SimpleThreadClass();
		t.run();
		t.start();
		t.run();
		t.run();
		
		SimpleRunnableThreadClass r = new SimpleRunnableThreadClass();
		r.run();
		
	}

	/**
	 * A simple way to Create Thread
	 * Using Thread instance
	 */
	public static void emptyThread() {
		Thread d = new Thread();
		d.start();
		System.out.println("Message #01 : A Empty Thread, Need to Override Run method of Runnable to Perform any Task");
	}

	/**
	 * A simple way to create Thread
	 * Using Runnable
	 */
	public static void emptyRunnableThread() {
		Runnable r = new Thread();
		r.run();
		System.out.println("Message #02 : A Empty Runnable Thread, Need to Override Run method of Runnable to Perform any Task");
	}

	/**
	 * A simple way of Create Thread
	 * And overriding run method using
	 * Runnable Instance
	 */
	public static void basicThreadWithRunnableConstructor() {
		Thread d = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Message #03 : Thread Name - " + Thread.currentThread().getName());
			}
		});

		d.start();
	}
	
	/**
	 * A simple way to Create a Thread
	 * And overriding Run method using
	 * Runnable Instance as Lambda 
	 */
	public static void basicThreadWithRunnableLambda() {
		Thread d = new Thread(() -> {
			System.out.println("Message #04 : Thread Name - " + Thread.currentThread().getName());
		});
		
		d.start();
	}
	
	/**
	 * A simple way of creating Thread
	 * and overriding Run method
	 * using Runnable instance itself
	 */
	public static void basicRunnableThread() {
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Message #05 : " + "Can't Use Thread class here");
			}
		};
		
		r.run();
	}
	
	/**
	 * A way of Creating Thread
	 * Through Extending Thread Class
	 * itself
	 */
	public static class SimpleThreadClass extends Thread{
		@Override
		public void run() {
			System.out.println("Message #06 : Thread Name - " + Thread.currentThread().getName());
			super.run();
		}
	}
	
	/**
	 * A way of Creating Thread 
	 * Implementing Runnable interface
	 */
	public static class SimpleRunnableThreadClass implements Runnable{

		@Override
		public void run() {
			System.out.println("Message #07 : Thread Name - " + Thread.currentThread().getName());
		}
		
	}
}

package com.runtimeturtle.concurrency.simplebruteforce;

import java.util.Scanner;

/**
 * Simple Brute Force Example Using Thread
 *
 * @author runtime-turtle
 */
public class SimpleBruteForceThread {

	static int passcode;
	static int guessAttempt = 0;

	/**
	 * To Run Apps and Call Methods
	 *
	 * @param args
	 * @throws InterruptedException
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {

		/* Set the Passcode */
		Scanner sc = new Scanner(System.in);
		System.out.print("Message #01 : Enter the Passcode in range 1000 - 9999 : ");
		passcode = sc.nextInt();

		/* Crack the Passcode Using Bruteforce through Concurrent Threads */
		System.out.println("Message #02 : Passcode Cracking Begins Now");
		Thread.sleep(2500);

		crackThePasscode();

		/*
		 * Counting For 10 Sec, If Method is Not Able to Break the Passcode in 10 Sec
		 * System Will Stop Them
		 */
		System.out.print("Message #04 : Counting : ");
		for (int i = 10; i > 0; i--) {
			Thread.sleep(1000);
			System.out.print(i + " ");
		}
		System.out.println("\nMessage #05 : !!! Mission Failed !!!");
		System.exit(0);
	}

	/**
	 * Passcode Vault
	 *
	 * @param guess
	 * @return
	 * @throws InterruptedException 
	 */
	public static boolean passcode(int guess) {

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (passcode == guess) {
			return true;
		}
		return false;
	}

	public static void crackThePasscode() {
		bruteforceWorkerOne();
		bruteforceWorkerTwo();
	}

	/**
	 * One Worker Thread to Crack the Passcode Using Brute Force, in Ascending Order
	 */
	public static void bruteforceWorkerOne() {
		Thread d = new Thread(() -> {
			for (int i = 0; i < 9999; i++) {
				if (passcode(i)) {
					System.out.println("\nMessage #06 : The Passcode is > " + i);
					System.exit(0);
				}
			}
		});

		d.start();
	}

	/**
	 * Second Worker Thread to Crack the Passcode Using Brute Force in Descending
	 * Order
	 */
	public static void bruteforceWorkerTwo() {
		Thread d = new Thread(() -> {
			for (int i = 9999; i > 0; i--) {
				if (passcode(i)) {
					System.out.println("\nMessage #07 : The Passcode is > " + i);
					System.exit(0);
				}
			}
		});

		d.start();
	}

}

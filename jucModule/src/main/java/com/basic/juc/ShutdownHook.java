package com.basic.juc;

/**
 * locate com.basic.juc
 * Created by mastertj on 2018/4/7.
 */
/**
 * test shutdown hook
 * All rights released and correctness not guaranteed.
 */
public class ShutdownHook implements Runnable {

    public ShutdownHook() {
        // register a shutdown hook for this class.
        // a shutdown hook is an initialzed but not started thread, which will get up and run
        // when the JVM is about to exit. this is used for short clean up tasks.
        Runtime.getRuntime().addShutdownHook(new Thread(this));
        System.out.println(">>> shutdown hook registered");
    }

    /**
     * there're couple of cases that JVM will exit, according to the Java api doc.
     * typically:
     * 1. method called: System.exit(int)
     * 2. ctrl-C pressed on the console.
     * 3. the last non-daemon thread exits.
     * 4. user logoff or system shutdown.
     * @param args
     */
    public static void main(String[] args) {

        new ShutdownHook();

        System.out.println(">>> Sleeping for 5 seconds, try ctrl-C now if you like.");

        try {
            Thread.sleep(5000);     // (-: give u the time to try ctrl-C
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }

    // this method will be executed of course, since it's a Runnable.
    // tasks should not be light and short, accessing database is alright though.
    public void run() {
        System.out.println("/n>>> About to execute: " + ShutdownHook.class.getName() + ".run() to clean up before JVM exits.");
        this.cleanUp();
        System.out.println(">>> Finished execution: " + ShutdownHook.class.getName() + ".run()");
    }

    // (-: a very simple task to execute
    private void cleanUp() {
        for(int i=0; i < 7; i++) {
            System.out.println(i);
        }
    }

}

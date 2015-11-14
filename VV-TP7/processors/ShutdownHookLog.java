package org.apache.commons.math4.processors;

public class ShutdownHookLog extends Thread {
	public void run() {
        TestWriter.writeLog();
    }
}

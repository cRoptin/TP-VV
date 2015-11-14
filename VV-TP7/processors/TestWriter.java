package org.apache.commons.math4.processors;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestWriter {
	private static PrintWriter fileWriter;

    public static void writeLog() {
        fileWriter.close();
    }

    
    
    public static  void count(String string, int count) {
        try {
            PrintWriter writer = getWriter();

            /*if(error) {
                writer.write("ERROR: ");
            } else {
                writer.write("INFO: ");
            }*/
            writer.write(string + " : " + count + "\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static PrintWriter getWriter() throws FileNotFoundException {
        if(fileWriter == null) {
            ShutdownHookLog shutdownHook = new ShutdownHookLog();
            Runtime.getRuntime().addShutdownHook(shutdownHook);
            fileWriter = new PrintWriter("log");
        }
        return fileWriter;
    }
}

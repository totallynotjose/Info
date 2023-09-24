package biomon;

/*
 *  Copyright (C) 2022 Christian Knorr, Simon Lenz.
 *  All rights reserved.
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Simplifies reading from {@link System#in} by providing dedicated methods
 * for reading each primitive data type (strings are treated as 'primitive'
 * data as well in this context). The behaviour of all methods is that the
 * methods block until the user enters valid data through {@link System#in}.
 * In case of type mismatches of the provided data the user will be requested
 * for input repeatedly until valid input data has been provided.
 *
 * @author  <a href="mailto:christian.knorr@gmx.de">Christian Knorr</a>
 */
public class SystemInReader {

    private static final BufferedReader IN;


    static {
        IN = new BufferedReader(new InputStreamReader(System.in));
    }


    /**
     * Read a <code>String</code> object from standard input. The user input
     * will be terminated by a line break (pressing ENTER-key). This method
     * has been named in accordance with {@link java.io.PrintStream#println(String)}.
     *
     * @return  The user's input as string
     * @see     #readString
     */
    public static String readln() {
        try {
            return IN.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Read a <code>String</code> object from standard input. The user input
     * will be terminated by a line break (pressing ENTER-key). This method
     * has been named in accordance with other read-methods in this class and
     * just maps to {@link #readln()}.
     *
     * @return  The user's input as string
     * @see     #readln
     */
    public static String readString() {
        return readln();
    }


    /**
     * Read <code>int</code> data from standard input. The user input will be
     * terminated by a line break (pressing ENTER-key).
     *
     * @return  The user's input as <code>int</code>
     */
    public static int readInt() {
        try {
            while (true) {
                try {
                    String str = IN.readLine();
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    System.out.print("No parsable int found, enter again: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Read <code>long</code> data from standard input. The user input will be
     * terminated by a line break (pressing ENTER-key).
     *
     * @return  The user's input as <code>long</code>
     */
    public static long readLong() {
        try {
            while (true) {
                try {
                    String str = IN.readLine();
                    return Long.parseLong(str);
                } catch (NumberFormatException e) {
                    System.out.print("No parsable long found, enter again: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Read <code>short</code> data from standard input. The user input will be
     * terminated by a line break (pressing ENTER-key).
     *
     * @return  The user's input as <code>short</code>
     */
    public static short readShort() {
        try {
            while (true) {
                try {
                    String str = IN.readLine();
                    return Short.parseShort(str);
                } catch (NumberFormatException e) {
                    System.out.print("No parsable short found, enter again: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Read <code>float</code> data from standard input. The user input will be
     * terminated by a line break (pressing ENTER-key).
     *
     * @return  The user's input as <code>float</code>
     */
    public static float readFloat() {
        try {
            while (true) {
                try {
                    String str = IN.readLine();
                    return Float.parseFloat(str);
                } catch (NumberFormatException e) {
                    System.out.print("No parsable float found, enter again: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Read <code>double</code> data from standard input. The user input will
     * be terminated by a line break (pressing ENTER-key).
     *
     * @return  The user's input as <code>double</code>
     */
    public static double readDouble() {
        try {
            while (true) {
                try {
                    String str = IN.readLine();
                    return Double.parseDouble(str);
                } catch (NumberFormatException e) {
                    System.out.print("No parsable double found, enter again: ");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Read a single <code>char</code> from standard input. The user input
     * will be terminated by a line break (pressing ENTER-key) but only single
     * characters will be accepted as valid input.
     *
     * @return  The user's input as <code>char</code>
     */
    public static char readChar() {
        while (true) {
            String str = readln();
            if (str.length() == 1)
                return str.charAt(0);
            System.out.print("No parsable char found, enter again: ");
        }
    }


    /**
     * Test stub which utilizes all defined methods of this class.
     *
     * @param args  Unused
     */
    public static void main(String[] args) {
        System.out.print("Enter a short: ");
        short s = readShort();
        System.out.println("Read short: " + s);

        System.out.print("Enter an int: ");
        int i = readInt();
        System.out.println("Read int: " + i);

        System.out.print("Enter a long: ");
        long l = readLong();
        System.out.println("Read long: " + l);

        System.out.print("Enter a float: ");
        float f = readFloat();
        System.out.println("Read float: " + f);

        System.out.print("Enter a double: ");
        double d = readDouble();
        System.out.println("Read double: " + d);

        System.out.print("Enter a char: ");
        char c = readChar();
        System.out.println("Read char: " + c);
    }
}

package de.ccd.nback.adapter;

import java.util.Scanner;

public class ConsoleImpl implements Console {

    @Override
    public char nextChar() {
        Scanner s = new Scanner(System.in);
        var input = s.nextLine();
        return input.charAt(0);
    }

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void clear() {
        System.out.println("CLEAR");
    }
}

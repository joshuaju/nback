package de.ccd.nback.app;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.adapter.FileSystem;
import de.ccd.nback.data.TestProtocol;

public class Evaluator {
    private final Console console;
    private final FileSystem fs;

    public Evaluator(Console console, FileSystem fs) {
        this.console = console;
        this.fs = fs;
    }

    public void evaluate(TestProtocol protocol) {
        System.out.println("evaluate");
        // TODO implement
    }

    public void write(TestProtocol protocol) {
        System.out.println("write");
        // TODO implement
    }

}

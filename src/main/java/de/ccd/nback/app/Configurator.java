package de.ccd.nback.app;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.data.TestConfiguration;

import java.time.Instant;

public class Configurator {

    private final Console console;

    public Configurator(Console console) {
        this.console = console;
    }

    public TestConfiguration configure() {
        System.out.println("configure");
        return new TestConfiguration("dummy", 1, 2, 3, Instant.now());
        // TODO implement
    }

}

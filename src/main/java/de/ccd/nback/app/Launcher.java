package de.ccd.nback.app;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.adapter.FileSystem;

public class Launcher {

    public static void main(String[] args) {
        var console = new Console() { // TODO replace with impl
        };
        var fs = new FileSystem() { // TODO replace with impl
        };

        var configurator = new Configurator(console);
        var nback = new NBack(console);
        var evaluator = new Evaluator(console, fs);

        var config = configurator.configure();
        var protocol = nback.nback(config);
        evaluator.evaluate(protocol);
        evaluator.write(protocol);
    }

}

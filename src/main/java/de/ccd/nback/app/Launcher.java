package de.ccd.nback.app;

import de.ccd.nback.adapter.ConsoleImpl;
import de.ccd.nback.adapter.FileSystemImpl;
import de.ccd.nback.logic.RandomStimulusGenerator;

public class Launcher {

    public static void main(String[] args) {
        var console = new ConsoleImpl();
        var fs = new FileSystemImpl();
        var generator = new RandomStimulusGenerator();

        var configurator = new Configurator(console);
        var evaluator = new Evaluator(console, fs);
        var nback = new NBack(console, generator);

        var config = configurator.configure();
        var protocol = nback.nback(config);
        evaluator.evaluate(protocol);
        evaluator.write(protocol);
    }

}

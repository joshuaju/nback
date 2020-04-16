package de.ccd.nback.app;

import de.ccd.nback.adapter.ConsoleImpl;
import de.ccd.nback.adapter.FileSystemImpl;
import de.ccd.nback.logic.EvaluateNBack;
import de.ccd.nback.logic.RandomStimulusGenerator;

import java.nio.file.Paths;
import java.text.MessageFormat;

public class Launcher {

    public static void main(String[] args) {
        var console = new ConsoleImpl();
        var fs = new FileSystemImpl();
        var generator = new RandomStimulusGenerator(1);

        var configurator = new Configurator(console);
        var nback = new NBack(console, generator);

        var config = configurator.configure();
        var protocol = nback.nback(config);

        var score = EvaluateNBack.evaluate(protocol.stimuli(), protocol.answers(), protocol.config().n());
        console.writeLine(MessageFormat.format("Score {0,number, #.##}%", score*100d));
        fs.writeFile(Paths.get(protocol.name()), protocol.toString());
    }

}

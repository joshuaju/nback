package de.ccd.nback.app;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.data.TestConfiguration;
import de.ccd.nback.data.TestProtocol;
import de.ccd.nback.logic.StimulusGenerator;
import de.ccd.nback.logic.StimulusPresenter;

public class NBack {

    private final Console console;
    private final StimulusGenerator generator;

    public NBack(Console console, StimulusGenerator generator) {
        this.console = console;
        this.generator = generator;
    }

    public TestProtocol nback(TestConfiguration config) {
        var protocol = new TestProtocol(config);
        var presenter = new StimulusPresenter(console);


        var stimuli = generator.generateStimuli(config);
        stimuli.forEach(stimulus -> {
            presenter.displayStimulus(0, stimulus);
            var answer = presenter.waitForAnswer();
            presenter.clearDisplay();
            protocol.append(stimulus, answer);
        });

        return protocol;
    }

}

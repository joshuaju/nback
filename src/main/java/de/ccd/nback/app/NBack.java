package de.ccd.nback.app;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.data.TestConfiguration;
import de.ccd.nback.data.TestProtocol;
import de.ccd.nback.logic.StimulusGenerator;
import de.ccd.nback.logic.StimulusPresenter;

import java.util.List;

public class NBack {

    private final Console console;

    public NBack(Console console) {
        this.console = console;
    }

    public TestProtocol nback(TestConfiguration config) {
        var protocol = new TestProtocol(config);
        var presenter = new StimulusPresenter(console);


        var stimuli = StimulusGenerator.decideNextStimulus(config);
        stimuli.forEach(stimulus -> {
            presenter.displayStimulus(0, stimulus);
            var answer = presenter.waitForAnswer();
            presenter.clearDisplay();
            protocol.append(stimulus, answer);
        });

        return protocol;
    }

}

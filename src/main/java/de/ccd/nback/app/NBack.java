package de.ccd.nback.app;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.data.Answer;
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

        var stimuli = generator.generateStimuli(config.numberOfStimuli(), config.n());


        for (var stimulus : stimuli) {
            presenter.displayStimulus(stimulus);
            var answer = presenter.waitForAnswer(config.stimulusDuration());

            if (answer == Answer.Cancel) break;

            presenter.clearDisplay();
            protocol.append(stimulus, answer == Answer.Repetition);
        }

        return protocol;
    }

}

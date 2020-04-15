package de.ccd.nback.data;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class TestProtocol {

    private TestConfiguration config;
    private List<Character> stimuli = new LinkedList<>();
    private List<Boolean> answers = new LinkedList<>();

    public TestProtocol(TestConfiguration config) {
        this.config = config;
    }

    public void append(char stimulus, boolean answer) {
        stimuli.add(stimulus);
        answers.add(answer);
    }

    public TestConfiguration config() {
        return this.config;
    }

    public List<Character> stimuli() {
        return List.copyOf(this.stimuli);
    }

    public List<Boolean> answers() {
        return List.copyOf(answers);
    }

    @Override
    public String toString() {
        // TODO change to proper format
        return MessageFormat.format(
                """
                        *** Protocol ***
                        Config: {0}
                        > Stimuli {1}
                        > Answers {2}
                        """, config, stimuli, answers);
    }
}

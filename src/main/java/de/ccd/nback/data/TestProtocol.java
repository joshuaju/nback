package de.ccd.nback.data;

import java.util.LinkedList;
import java.util.List;

public class TestProtocol {

    private TestConfiguration config;
    private List<Character> stimuli = new LinkedList<>();
    private List<Boolean> answer = new LinkedList<>();

    public TestProtocol(TestConfiguration config) {
        this.config = config;
    }

    public void append(char stimulus, boolean answer) {
        // TODO implement
    }

    @Override
    public String toString() {
        // TODO change to proper format
        return "TestProtocol{" +
                "config=" + config +
                ", stimuli=" + stimuli +
                ", answer=" + answer +
                '}';
    }
}

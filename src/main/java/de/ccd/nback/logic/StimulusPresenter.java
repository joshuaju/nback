package de.ccd.nback.logic;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.adapter.ConsoleImpl;
import de.ccd.nback.data.Answer;

import java.util.Optional;

public class StimulusPresenter {

    private final Console console;

    public StimulusPresenter(Console console) {
        this.console = console;
    }

    public void displayStimulus(char stimulus) {
        console.writeLine("Stimulus: " + stimulus);
    }

    public Answer waitForAnswer(int duration) {
        // TODO implement timeout, return false upon timeout
        var answer = console.nextChar();
        return switch (Character.toUpperCase(answer)) {
            case 'J', 'Y' -> Answer.Repetition;
            case 'X' -> Answer.Cancel;
            default -> Answer.NoRepetition;
        };
    }

    public void clearDisplay() {
        console.clear();
    }

}

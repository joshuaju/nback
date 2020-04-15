package de.ccd.nback.logic;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.adapter.ConsoleImpl;

public class StimulusPresenter {

    private final Console console;

    public StimulusPresenter(Console console) {
        this.console = console;
    }

    public void displayStimulus(char stimulus) {
        console.writeLine("Stimulus: " + stimulus);
    }

    public boolean waitForAnswer(int duration) {
        // TODO implement timeout, return false upon timeout
        var answer = console.nextChar();
        return switch (Character.toUpperCase(answer)) {
            case 'J', 'Y' -> true;
            default -> false;
        };
    }

    public void clearDisplay() {
        console.clear();
    }

    public static void main(String[] args) {
        var presenter = new StimulusPresenter(new ConsoleImpl());
        presenter.displayStimulus('A');

        var answer = presenter.waitForAnswer(1000);
        System.out.println("Answer: " + answer);

        presenter.clearDisplay();
    }

}

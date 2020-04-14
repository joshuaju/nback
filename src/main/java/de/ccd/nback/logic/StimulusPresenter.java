package de.ccd.nback.logic;

import de.ccd.nback.adapter.Console;

public class StimulusPresenter {

    private final Console console;

    public StimulusPresenter(Console console) {
        this.console = console;
    }

    public void displayStimulus(int duration, char stimulus) {
        System.out.println("display");
        // TODO implement
    }

    public boolean waitForAnswer() {
        System.out.println("wait for answer -> false");
        return false; // TODO implement
    }

    public void clearDisplay() {
        System.out.println("clear");
        // TODO implement
    }

}

package de.ccd.nback;

import de.ccd.nback.adapter.Console;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DeterministicConsole implements Console {

    private Deque<Character> nextChars;

    public DeterministicConsole(Character... nextChars) {
        this.nextChars = new ArrayDeque<>(Arrays.asList(nextChars));
    }

    @Override
    public char nextChar() {
        return this.nextChars.pop();
    }
}

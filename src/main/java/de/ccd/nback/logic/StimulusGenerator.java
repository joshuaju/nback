package de.ccd.nback.logic;

import de.ccd.nback.data.TestConfiguration;

import java.util.List;

public class StimulusGenerator {

    public static List<Character> decideNextStimulus(TestConfiguration configuration) {
        System.out.println("decide next");
        return List.of(repeatStimulus(0), createDifferentStimulus(0)); // TODO implement
    }

    public static char repeatStimulus(int n) {
        System.out.println("repeating: +");
        return '+'; // TODO implement
    }

    public static char createDifferentStimulus(int n) {
        System.out.println("random: -");
        return '-'; // TODO implement
    }


}

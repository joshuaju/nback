package de.ccd.nback.logic;

import de.ccd.nback.data.TestConfiguration;

import javax.swing.*;
import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomStimulusGenerator implements StimulusGenerator {

    private static final double repetitionProbability = 0.5;

    @Override
    public List<Character> generateStimuli(TestConfiguration configuration) {
        System.out.println("decide next: random");
        var n = configuration.n();
        var numberOfStimuli = configuration.numberOfStimuli();

        return Stream.generate(decideNext(repeatStimulus(n), createDifferentStimulus(n)))
                .limit(numberOfStimuli)
                .collect(Collectors.toList());
    }

    private static Supplier<Character> decideNext(Supplier<Character> onRepeat, Supplier<Character> onRandom) {
        var random = Math.random();
        if (random < repetitionProbability) return onRandom;
        else return onRepeat;
    }

    private static Supplier<Character> repeatStimulus(int n) {
        System.out.println("repeating: +");
        return () -> '+'; // TODO implement
    }

    private static Supplier<Character> createDifferentStimulus(int n) {
        System.out.println("random: -");
        return () -> '-'; // TODO implement
    }


}

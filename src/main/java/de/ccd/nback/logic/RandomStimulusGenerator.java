package de.ccd.nback.logic;

import de.ccd.nback.data.TestConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomStimulusGenerator implements StimulusGenerator {

    private final double repetitionProbability;
    private final Random random = new Random();

    public RandomStimulusGenerator(double repetitionProbability) {
        this.repetitionProbability = repetitionProbability;
    }

    @Override
    public List<Character> generateStimuli(int numbersOfStimuli, int n) {
        System.out.println("decide next: random");

        List<Character> stimuli = new ArrayList<>(numbersOfStimuli);
        for (int generated = 0; generated < numbersOfStimuli; generated++) {
            var next = decideNext(stimuli, n);
            stimuli.add(next);
        }
        return stimuli;
    }

    private Character decideNext(List<Character> stimuli, int n) {
        boolean notRepeatable = (stimuli.size() - n) < 0;
        if (notRepeatable) return randomChar();

        if (random.nextDouble() >= repetitionProbability) return randomCharButNotNBack(stimuli, n);
        else return repeatCharNBack(stimuli, n);
    }

    private Character repeatCharNBack(List<Character> chars, int nBack) {
        return chars.get(chars.size() - nBack);
    }

    private Character randomChar() {
        int letterIndex = random.nextInt(26);
        return (char) (letterIndex + 'a');
    }

    private Character randomCharButNotNBack(List<Character> chars, int nBack) {
        var nbackChar = repeatCharNBack(chars, nBack);
        Character randomCharButNotNBack;
        do {
            randomCharButNotNBack = randomChar();
        } while (randomCharButNotNBack == nbackChar);
        return randomCharButNotNBack;
    }

}

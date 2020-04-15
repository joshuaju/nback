package de.ccd.nback;

import de.ccd.nback.data.TestConfiguration;
import de.ccd.nback.logic.StimulusGenerator;

import java.util.Arrays;
import java.util.List;

public class DeterministicStimulusGenerator implements StimulusGenerator {

    private final List<Character> stimuli;

    public DeterministicStimulusGenerator(Character... stimuli){
        this.stimuli = Arrays.asList(stimuli);
    }

    @Override
    public List<Character> generateStimuli(int numbersOfStimuli, int n) {
        return stimuli;
    }
}

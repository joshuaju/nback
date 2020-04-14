package de.ccd.nback.logic;

import de.ccd.nback.data.TestConfiguration;

import java.util.List;

public interface StimulusGenerator {

    List<Character> generateStimuli(TestConfiguration config);

}

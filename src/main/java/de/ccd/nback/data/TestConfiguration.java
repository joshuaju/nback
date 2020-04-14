package de.ccd.nback.data;

import java.time.Instant;

public record TestConfiguration(String subjectName,
                                int stimulusDuration,
                                int n,
                                int numberOfStimuli,
                                Instant startTime) {
}

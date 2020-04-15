package de.ccd.nback.data;

import java.time.Instant;

public record TestConfiguration(String subjectName,
                                int stimulusDuration,
                                int n,
                                int numberOfStimuli,
                                Instant startTime) {

    @Override
    public String toString() {
        return "subjectName='" + subjectName + '\'' +
                ", stimulusDuration=" + stimulusDuration +
                ", n=" + n +
                ", numberOfStimuli=" + numberOfStimuli +
                ", startTime=" + startTime +
                '}';
    }
}

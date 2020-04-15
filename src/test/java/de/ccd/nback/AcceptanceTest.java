package de.ccd.nback;

import de.ccd.nback.app.NBack;
import de.ccd.nback.data.TestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class AcceptanceTest {

    @Test
    void allAnswersCorrect() {
        TestConfiguration config = new TestConfiguration(
                "Mr. Cool",
                1,
                3,
                10,
                Instant.parse("2001-01-01T00:00:00.000Z")
        );
        Character[] answers = {'N', 'N', 'N', 'J', 'J', 'N', 'J', 'N', 'J', 'J'};
        var console = new DeterministicConsole(answers);

        Character[] stimuli = {'A', 'B', 'C', 'A', 'B', 'B', 'A', 'C', 'B', 'A'};
        var generator = new DeterministicStimulusGenerator(stimuli);

        var nBack = new NBack(console, generator);
        var protocol = nBack.nback(config);

        assertThat(protocol.config()).as("Check config is identical").isEqualTo(config);
        assertThat(protocol.stimuli()).as("Check stimuli are recorded").isEqualTo(Arrays.asList(stimuli));
        assertThat(protocol.answers()).as("Check answers are translated").isEqualTo(answersAsBool(Arrays.asList(answers)));
        assertThat(protocol.calculateScore()).as("Check score").isEqualTo(1.00);
    }

    @Test
    void mostAnswersWrong() {
        TestConfiguration config = new TestConfiguration(
                "Mr. Cool",
                1,
                3,
                11,
                Instant.parse("2001-01-01T00:00:00.000Z")
        );

        Character[] answers = {'J', 'J', 'J', 'J', 'N', 'J', 'N', 'J', 'N', 'N', 'J'};
        var console = new DeterministicConsole(answers);

        Character[] stimuli = {'A', 'B', 'C', 'A', 'B', 'B', 'A', 'C', 'B', 'A', 'A'};
        var generator = new DeterministicStimulusGenerator(stimuli);

        var nBack = new NBack(console, generator);
        var protocol = nBack.nback(config);

        assertThat(protocol.config()).as("Check config is identical").isEqualTo(config);
        assertThat(protocol.stimuli()).as("Check stimuli are recorded").isEqualTo(Arrays.asList(stimuli));
        assertThat(protocol.answers()).as("Check answers are translated").isEqualTo(answersAsBool(Arrays.asList(answers)));
        assertThat(protocol.calculateScore()).as("Check score").isEqualTo(0.0909);
    }

    private List<Boolean> answersAsBool(List<Character> answers) {
        return answers.stream()
                .map(c -> switch (c) {
                    case 'J' -> true;
                    default -> false;
                })
                .collect(Collectors.toList());
    }

}

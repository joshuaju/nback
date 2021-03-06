package de.ccd.nback.app;

import de.ccd.nback.adapter.Console;
import de.ccd.nback.data.TestConfiguration;

import java.time.Instant;
import java.util.Scanner;

public class Configurator {

    private final Console console;

    public Configurator(Console console) {
        this.console = console;
    }

    public TestConfiguration configure() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter subject name: ");
        var subjectName = sc.nextLine();
        System.out.print("Enter n (1..9): ");
        var n = sc.nextInt();
        System.out.print("Enter stimulus duration (ms): ");
        var duration = sc.nextInt();
        System.out.print("Enter number stimuli (10..100): ");
        var numberOfStimuli = sc.nextInt();

        return new TestConfiguration(subjectName, duration, n, numberOfStimuli, Instant.now());
    }

}

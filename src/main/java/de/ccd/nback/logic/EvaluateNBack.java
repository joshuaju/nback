package de.ccd.nback.logic;

import java.util.List;

public class EvaluateNBack {

    public static double evaluate(List<Character> stimuli, List<Boolean> answers, int n) {
        int correctAnswers = 0;
        for (int index = 0; index < stimuli.size(); index++) {
            int indexNBack = index - n;
            boolean isRepeatable = indexNBack >= 0;

            boolean expectedAnswer = isRepeatable && stimuli.get(indexNBack) == stimuli.get(index);

            boolean actualAnswer = answers.get(index);
            if (expectedAnswer == actualAnswer) correctAnswers++;
        }

        return (correctAnswers * 1d) / stimuli.size();
    }

}

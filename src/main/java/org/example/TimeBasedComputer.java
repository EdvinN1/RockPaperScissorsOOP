package org.example;

import java.time.LocalTime;

public class TimeBasedComputer extends Player {

    @Override
    public void ChooseOption() {
        // Implement a strategy based on the current time
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        if (hour < 12) {
            setChoice(Choice.ROCK);
        } else if (hour < 18) {
            setChoice(Choice.PAPER);
        } else {
            setChoice(Choice.SCISSORS);
        }
    }
}

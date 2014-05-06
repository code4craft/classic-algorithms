package com.gugugua.fizzBuzz;

import com.gugugua.fizzBuzz.numbersayer.NumberSayer;

/**
 * @author code4crafter@gmail.com
 * @date 14-5-6
 */
public class NumberSequenceSayer {

    private final NumberSayer numberSayer;

    private final int startNumber;

    private final int endNumber;

    private static String SEPARATOR = System.lineSeparator();

    public NumberSequenceSayer(NumberSayer numberSayer, int startNumber, int endNumber) {
        this.numberSayer = numberSayer;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
    }

    public String say() {
        StringBuilder accum = new StringBuilder();
        for (int i = startNumber; i <= endNumber; i++) {
            String say = numberSayer.say(i);
            if (say != null) {
                accum.append(say).append(SEPARATOR);
            }
        }
        return accum.toString();
    }
}

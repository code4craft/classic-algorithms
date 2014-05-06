package com.gugugua.fizzBuzz;

import org.junit.Test;

import static com.gugugua.fizzBuzz.NumberSayers.*;

/**
 * @author code4crafter@gmail.com
 * @date 14-5-6
 */
public class NumberSequenceSayerTest {

    @Test
    public void testAll() throws Exception {
        NumberSequenceSayer numberSequenceSayer = NumberSequenceSayerBuilder.custom().setNumberSayer(
                or(
                    contains(3, "Fizz"),
                    all(mod(3, "Fizz"), mod(5, "Buzz"), mod(7, "Whizz")),
                    echo()
                )
             ).setStartNumber(1).setEndNumber(100).get();
        System.out.println(numberSequenceSayer.say());
    }
}

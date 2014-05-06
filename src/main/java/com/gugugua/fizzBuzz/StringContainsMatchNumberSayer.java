package com.gugugua.fizzBuzz;

/**
 * @author code4crafter@gmail.com
 * @date 14-5-6
 */
public class StringContainsMatchNumberSayer extends AbstractMatchNumberSayer {

    protected StringContainsMatchNumberSayer(int matchNumber, String mapWord) {
        super(matchNumber, mapWord);
    }

    @Override
    protected boolean isMatch(int number) {
        return Integer.toString(number).contains(String.valueOf(getMatchNumber()));
    }
}

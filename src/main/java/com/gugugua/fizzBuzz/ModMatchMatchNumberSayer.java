package com.gugugua.fizzBuzz;

/**
 * @author code4crafter@gmail.com
 * @date 14-5-6
 */
public class ModMatchMatchNumberSayer extends AbstractMatchNumberSayer {

    protected ModMatchMatchNumberSayer(int matchNumber, String mapWord) {
        super(matchNumber, mapWord);
    }

    @Override
    protected boolean isMatch(int number) {
        return number == getMatchNumber();
    }

}

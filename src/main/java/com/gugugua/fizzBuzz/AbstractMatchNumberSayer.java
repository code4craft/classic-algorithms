package com.gugugua.fizzBuzz;

/**
 * @author code4crafter@gmail.com
 * @date 14-5-6
 */
public abstract class AbstractMatchNumberSayer implements NumberSayer {

    private final int matchNumber;

    private final String mapWord;

    protected AbstractMatchNumberSayer(int matchNumber, String mapWord) {
        this.matchNumber = matchNumber;
        this.mapWord = mapWord;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public String getMapWord() {
        return mapWord;
    }

    @Override
    public String say(int number) {
        if (isMatch(number)) {
            return getMapWord();
        } else {
            return null;
        }
    }

    protected abstract boolean isMatch(int number);

}

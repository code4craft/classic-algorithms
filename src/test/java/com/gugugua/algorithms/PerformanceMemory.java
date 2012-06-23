package com.gugugua.algorithms;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class PerformanceMemory {

    private long[] memory;

    private boolean silence;

    /**
     * 
     */
    public PerformanceMemory() {
        this(100);

    }

    public PerformanceMemory(int size, boolean silence) {
        memory = new long[size];
        this.silence = silence;
    }

    public PerformanceMemory(int size) {
        this(size, false);
    }

    public void reset() {
        memory[0] = Runtime.getRuntime().totalMemory();
    }

    public void print() {
        System.out.println("memory used " + (Runtime.getRuntime().totalMemory() - memory[0]));
        memory[0] = Runtime.getRuntime().totalMemory();
    }

    public void start(int round) {
        memory[round] = Runtime.getRuntime().totalMemory();
    }

    public void end(int round) {
        memory[round] = Runtime.getRuntime().totalMemory() - memory[round];
        if (!silence) {
            System.out.println("memory used " + memory[round] + " round " + round);
        }
    }

    public long average(int round) {
        long total = 0;
        for (int i = 0; i < round; i++) {
            total += memory[i];
        }
        return total / round;

    }

}

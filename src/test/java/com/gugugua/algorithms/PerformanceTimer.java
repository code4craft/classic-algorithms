package com.gugugua.algorithms;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class PerformanceTimer {

    private long[] time;

    private boolean silence;

    /**
     * 
     */
    public PerformanceTimer() {
        this(100);

    }

    public PerformanceTimer(int size, boolean silence) {
        time = new long[size];
        this.silence = silence;
    }

    public PerformanceTimer(int size) {
        this(size, false);
    }

    public void reset() {
        time[0] = System.currentTimeMillis();
    }

    public void print() {
        System.out.println("time cast " + (System.currentTimeMillis() - time[0]));
        time[0] = System.currentTimeMillis();
    }

    public void start(int round) {
        time[round] = System.currentTimeMillis();
    }

    public void end(int round) {
        time[round] = System.currentTimeMillis() - time[round];
        if (!silence) {
            System.out.println("time cost " + time[round] + " round " + round);
        }
    }

    public long average(int round) {
        long total = 0;
        for (int i = 0; i < round; i++) {
            total += time[i];
        }
        return total / round;

    }

}

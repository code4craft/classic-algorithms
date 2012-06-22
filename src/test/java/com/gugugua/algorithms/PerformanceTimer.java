package com.gugugua.algorithms;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class PerformanceTimer {

    private long[] time;

    /**
     * 
     */
    public PerformanceTimer() {
        time = new long[100];
    }

    public PerformanceTimer(int size) {
        time = new long[size];
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
        System.out.println("time cost " + time[round] + " round " + round);
    }

    public long average(int round) {
        long total = 0;
        for (int i = 0; i < round; i++) {
            total += time[i];
        }
        return total / round;

    }

}

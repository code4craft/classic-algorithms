package com.gugugua.algorithms;

/**
 * @author cairne huangyihua@diandian.com
 * @date 2012-6-22
 */
public class PerformanceTimer {

    private long time;

    public void reset() {
        time = System.currentTimeMillis();
    }

    public void print() {
        System.out.println("time cast " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
    }

}

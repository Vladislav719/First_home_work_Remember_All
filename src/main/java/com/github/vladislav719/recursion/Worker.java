package com.github.vladislav719.recursion;

/**
 * Created by vladislav on 07.09.14.
 */
public class Worker {


    int types[] = new int[]{1, 5, 10, 25};
    public int count_change(int amount, final int n) {
        if (amount == 0) {
            return 1;
        } else if( amount < 0 || n == 0) {
            return 0;
        } else {
            return count_change(amount, n - 1) + count_change(amount- getType(n), n);
        }
    }

    private int getType(int n){
        return types[n - 1];
    }

}

package com.tsystems.javaschool.tasks.subsequence;

import java.util.List;

public class Subsequence {

    /**
     * Checks if it is possible to get a sequence which is equal to the first
     * one by removing some elements from the second one.
     *
     * @param x first sequence
     * @param y second sequence
     * @return <code>true</code> if possible, otherwise <code>false</code>
     */
    @SuppressWarnings("rawtypes")
    public boolean find(List x, List y) {
        if (x == null){
            throw new IllegalArgumentException();
        }
        if (y == null) {
            throw new IllegalArgumentException();
        }
        boolean check = true;
        int cursor = 0;

            for (int ix = 0; ix < x.size(); ix++) {
                if (!check) break;
                check = false;
                for (int iterY = cursor; iterY < y.size(); iterY++) {
                    if (x.get(ix).equals(y.get(iterY))) {
                        check = true;
                        cursor = iterY + 1;
                        break;
                    }
                }
            }

        return check;
    }
}

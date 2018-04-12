package com.tsystems.javaschool.tasks.pyramid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PyramidBuilder {

    /**
     * Builds a pyramid with sorted values (with minumum value at the top line and maximum at the bottom,
     * from left to right). All vacant positions in the array are zeros.
     *
     * @param inputNumbers to be used in the pyramid
     * @return 2d array with pyramid inside
     * @throws {@link CannotBuildPyramidException} if the pyramid cannot be build with given input
     */
    public int[][] buildPyramid(List<Integer> inputNumbers) {
        try {
            List<Integer> list = new ArrayList<>(inputNumbers);

            try {
                Collections.sort(list);
            } catch (NullPointerException e) {
                throw new CannotBuildPyramidException();
            }
            // Check for numbers of line in Array

            int res = list.size();
            if (res < 3) {
                throw new CannotBuildPyramidException();
            }
            int i = 1;
            while (res > 0) {
                res = res - i;
                i++;
            }
            if (res < 0) {
                throw new CannotBuildPyramidException();
            }
            // i - numbers of lines in array we can create
            i = i - 1;
            //create new matrix and fill it by zeros
            int[][] matrixA;
            matrixA = new int[i][i + i - 1];
            for (int j = 0; j < i; j++) {
                for (int g = 0; g < i + i - 1; g++) {
                    matrixA[j][g] = 0;
                }
            }

            for (int h = 0; h < i; h++) {
                int count = h + 1;
                int propusk = i - count;
                for (int w = propusk; count > 0; count--) {
                    matrixA[h][w] = list.remove(0);
                    w += 2;
                }
            }


            return matrixA;
        } catch (OutOfMemoryError e) {
            throw new CannotBuildPyramidException();
        }
    }
}

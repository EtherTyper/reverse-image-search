package main;

import java.util.Collection;
import java.util.LinkedList;

public class Keypoints {
    static Collection<Point> localMaxima(int[][] image) {
        LinkedList<Point> maxima = new LinkedList<>();

        for (int i = 1; i + 1 < image.length; i++) {
            for (int j = 1; j + 1 < image[i].length; j++) {
                boolean isMaximum = true;

                for (int xShift = -1; xShift <= 1; xShift++) {
                    for (int yShift = -1; yShift <= 1; yShift++) {
                        isMaximum &= image[i][j] >= image[i + xShift][j + yShift];
                    }
                }

                if (isMaximum)
                    maxima.add(new Point(i, j));
            }
        }

        return maxima;
    }
}

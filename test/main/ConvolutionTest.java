package main;

import org.junit.Test;

import java.util.Arrays;

public class ConvolutionTest {
    @Test
    public void gaussianFilter() {
        double[] gaussian = ImageManipulation.gaussianFilter(10, 5);

        System.out.println(Arrays.toString(gaussian));
    }
}

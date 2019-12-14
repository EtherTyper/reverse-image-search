package main;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ConvolutionTest {
    @Test
    public void gaussianFilter() {
        double[] gaussian = ImageManipulation.gaussianFilter(10, 4.5);
        double sum = Arrays.stream(gaussian).sum();

        Assert.assertTrue(sum >= 0.95);
        Assert.assertTrue(sum <= 1.00);

        System.out.println(Arrays.toString(gaussian));
        System.out.println(sum);
    }
}

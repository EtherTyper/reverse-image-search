package main;

public class ImageManipulation {
    static final double invSqrt2Pi = 1.0 / Math.sqrt(2 * Math.PI);

    /**
     * Applies a 1-dimensional convolution filter to both X and Y dimensions.
     *
     * @param filter A one dimensional filter.
     * @param target Array.
     * @return The target array convolved with the filter.
     */
    public static int[] convolve(int[] filter, int[] target) {
        int[] result = new int[target.length - filter.length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < filter.length; j++) {
                result[i] += filter[j] * target[i + j];
            }
        }

        return result;
    }

    /**
     * Applies a symmetric convolution filter to both X and Y dimensions.
     *
     * @param filter A one dimensional filter.
     * @param target Two dimensional array.
     * @return The target array convolved with filter in both X and Y dimensions.
     */
    public static int[][] convolve(int[] filter, int[][] target) {
        int xLength = target.length;
        int yLength = target[0].length;

        int newXLength = xLength - filter.length;
        int newYLength = yLength - filter.length;

        // Process each row.
        int[][] convolvedRows = new int[xLength][newYLength];

        for (int row = 0; row < xLength; row++) {
            for (int i = 0; i < newYLength; i++) {
                for (int j = 0; j < filter.length; j++) {
                    convolvedRows[row][i] += filter[j] * target[row][i + j];
                }
            }
        }

        // Convolve those rows.
        int[][] result = new int[newXLength][newYLength];

        for (int col = 0; col < newYLength; col++) {
            for (int i = 0; i < newXLength; i++) {
                for (int j = 0; j < filter.length; j++) {
                    result[i][col] += filter[j] * convolvedRows[i + j][col];
                }
            }
        }

        return result;
    }

    /**
     * Returns a single-variable Gaussian filter.
     * Can be extended to higher-dimensional images by product symmetry.
     *
     * @param size Filter size.
     * @param var Variance of Gaussian.
     * @return A double array representing this filter.
     */
    public static double[] gaussianFilter(int size, int var) {
        double[] filter = new double[2 * size + 1];

        for (int x = -size; x <= size; x++) {
            double zScore = (double) x / var;
            filter[size + x] = invSqrt2Pi / var * Math.exp(-0.5 * zScore * zScore);
        }

        return filter;
    }
}

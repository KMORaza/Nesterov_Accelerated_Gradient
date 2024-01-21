package Nesterov_Accelerated_Gradient;
// Created: November 2022
public class TestFunction implements OptimizationProblem {
    @Override
    public double computeValue(double[] parameters) {
        double x = parameters[0];
        return Math.pow(x, 3) - 6 * Math.pow(x, 2) + 11 * x - 6;
    }
    @Override
    public double[] computeGradient(double[] parameters) {
        double x = parameters[0];
        double gradient = 3 * Math.pow(x, 2) - 12 * x + 11;

        return new double[]{gradient};
    }
    @Override
    public int getDimension() {
        return 1; // One parameter (x)
    }
}
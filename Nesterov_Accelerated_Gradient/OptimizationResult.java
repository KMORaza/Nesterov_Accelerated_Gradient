package Nesterov_Accelerated_Gradient;
// Created: November 2022
public class OptimizationResult {
    private double[] optimalSolution;
    private double optimalValue;
    private boolean converged;
    private int iterations;
    public OptimizationResult(double[] optimalSolution, double optimalValue, boolean converged, int iterations) {
        this.optimalSolution = optimalSolution.clone();
        this.optimalValue = optimalValue;
        this.converged = converged;
        this.iterations = iterations;
    }
    public double[] getOptimalSolution() {
        return optimalSolution.clone();
    }
    public double getOptimalValue() {
        return optimalValue;
    }
    public boolean hasConverged() {
        return converged;
    }
    public int getIterations() {
        return iterations;
    }
}
